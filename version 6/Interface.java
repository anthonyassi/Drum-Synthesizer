//VERSION 3
//THIS VERSION STARTS WITH ONE PANEL WITH PLAY BUTTON 
// AND VOLUME SLIDER THAT DONT DO ANYTHING. IMPLEMENTED 
//"ADD" BUTTON THAT ADDS PANELS TO THE WINDOW.
//FEEL FREE TO ADD, REPLACE, FIX CODE, JUST SAVE IT 
//AS A NEW VERSION.


import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

class Interface{

  static Sampler[] samplers = new Sampler[8];
  public static void main(String[] args){
  JFrame frame = new JFrame("Drum Synthesizer");
  Container pane = frame.getContentPane();
  
  buildGUI(pane);
  
  frame.addWindowListener(new Exiter());
  
  frame.setSize(800,500);
  frame.setVisible(true);
  }
  
  
  static void buildGUI(Container pane){
    
    //Create Initial panel
    samplers[0] = new Sampler("Channel 1");
    Sampler.numPanels = 1;
    //Create action listen and give it to addpanel button
    Actions doAction = new Actions(samplers,pane,0);
    Sampler.addChannel.addActionListener(doAction);
   samplers[0].openButton.addActionListener(doAction);
    samplers[0].play.addActionListener(doAction);
    samplers[0].volumeSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'v'));
    samplers[0].pitchSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'p'));
    updateGUI(pane);
    
  }
  
  static void updateGUI(Container pane){
   //if updateGUI is called from Actions class then creat new panel
    if(Sampler.numPanels>1){
      int i = Sampler.numPanels-1;
      samplers[i]  = new Sampler("Channel"+(i+1));
      samplers[i].openButton.addActionListener(new Actions(samplers,pane,i));
      samplers[i].play.addActionListener(new Actions(samplers,pane,i));
      samplers[i].volumeSlider.addChangeListener(new SliderListener(samplers, pane, i,'v'));
      samplers[i].pitchSlider.addChangeListener(new SliderListener(samplers, pane, i,'p'));
      samplers[0].add(samplers[i]);
    }
  
    
    //Put addchannel button button under last channel
    samplers[(Sampler.numPanels-1)].add(Sampler.addChannel);
    samplers[0].revalidate();
    //add panels to pane(window)
    pane.add(samplers[0]);
  }
}