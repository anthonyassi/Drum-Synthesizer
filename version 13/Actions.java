import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//ACTION LISTENER FOR SAMPLER BUTTONS
class Actions implements ActionListener{
 Sampler[] samplers;
 Container pane;
 int numSampler;
 Actions(Sampler[] samplers,Container pane,int numSampler){
  this.samplers = samplers;
  this.pane = pane;
  this.numSampler = numSampler;
 }
 //if an action event occurs some of this code will execute depending on the action event
 public void actionPerformed(ActionEvent e){
 // System.out.println(e.getActionCommand()); 
  
  String cmd = e.getActionCommand();
  
  //if user adds new sampler or synth, increment numSamplers/Synthesizers and update the interface 
    if(cmd.contains("Sampler")){
      Interface.numPanels++;
      Interface.buildSampler(pane);
        }
    if(cmd.contains("Synth")){
      Interface.numPanels++;
      Interface.buildSynthesizer(pane);
        }
   //if user hits play button
    if(cmd.contains("PLAY")){
      System.out.println("Panel:"+numSampler+"PLAY");
      //play sample
      PlaySample p = new PlaySample();
      p.play(samplers[numSampler].sample, samplers[numSampler].volumeSlider.getValue(), samplers[numSampler].cutoffSlider.getValue() );
    }
    if(cmd.contains("Open a File")){
      System.out.println("OpenEnded");
      int returnVal = samplers[numSampler].fc.showOpenDialog(null);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " );
           System.out.println( samplers[numSampler].fc.getSelectedFile().getName());
           samplers[numSampler].sample = samplers[numSampler].fc.getSelectedFile();
    }
    }
    
}
 
 


}