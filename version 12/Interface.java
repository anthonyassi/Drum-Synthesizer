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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Interface{
  static int numPanels;
  static Sampler[] samplers = new Sampler[8];
  static Synthesizer[] synthesizers = new Synthesizer[8]; 

  static JButton addChannel = new JButton("+New...");
  static JPopupMenu channelMenu = new JPopupMenu();
  static JMenuItem newSamp = new JMenuItem("Sampler");
  static JMenuItem newSynth = new JMenuItem("Synth");  

  public static void main(String[] args){
  JFrame frame = new JFrame("Drum Synthesizer");
  Container pane = frame.getContentPane();
  
  buildGUI(pane);
  
  frame.addWindowListener(new Exiter());
  
  frame.setSize(800,500);
  frame.setVisible(true);
  }
  
  
  static void buildGUI(Container pane){
    numPanels++;
    //Create Initial sampler
    samplers[0] = new Sampler();
    //Create action listener
    Actions doAction = new Actions(samplers,pane,0);
    //create sample/synth popupmenu
    channelMenu.add(newSamp);
    channelMenu.add(newSynth);
    addChannel.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        channelMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    //listen for add button
    addChannel.addActionListener(doAction);
    newSamp.addActionListener(doAction);
    newSynth.addActionListener(doAction);
    
    samplers[0].openButton.addActionListener(doAction);
    samplers[0].play.addActionListener(doAction);
    samplers[0].volumeSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'v'));
    samplers[0].pitchSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'p'));
    samplers[0].cutoffSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'f'));
    buildSampler(pane);
    
  }
  
  static void buildSampler(Container pane){
   //if buildSampler is called from Actions class then creat new channel
    if(numPanels>1){
      int i = numPanels-1;
      samplers[i]  = new Sampler();
      samplers[i].openButton.addActionListener(new Actions(samplers,pane,i));
      samplers[i].play.addActionListener(new Actions(samplers,pane,i));
      samplers[i].volumeSlider.addChangeListener(new SliderListener(samplers, pane, i,'v'));
      samplers[i].pitchSlider.addChangeListener(new SliderListener(samplers, pane, i,'p'));
      samplers[i].cutoffSlider.addChangeListener(new SliderListener(samplers, pane, i,'f'));
      samplers[0].add(samplers[i]);
    }
  
    //Put addchannel button button under last channel
    samplers[(numPanels-1)].add(addChannel);
    samplers[0].revalidate();
    //add samplers to pane(window)
    pane.add(samplers[0]);
  }
  
    static void buildSynthesizer(Container pane){
   //if buildSYNTH is called from Actions class then creat new channel
    if(numPanels>1){
      int i = numPanels-1;
      synthesizers[i]  = new Synthesizer();
      synthesizers[i].play.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].sine.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].noise.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].volumeSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'v'));
      synthesizers[i].pitchSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'p'));
      synthesizers[i].cutoffSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'f'));
      samplers[0].add(synthesizers[i]);
    }
  
    
    //Put addchannel button button under last channel
    synthesizers[(numPanels-1)].add(addChannel);
    samplers[0].revalidate();
    //add samplers to pane(window)
    pane.add(samplers[0]);
  }


}