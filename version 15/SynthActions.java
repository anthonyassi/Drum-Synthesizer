import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;


//ACTION LISTENER FOR SYNTH BUTTONS
class SynthActions implements ActionListener{
  Synthesizer[] synthesizers;
  Container pane;
  int numSynthesizer;
 
  SynthActions(Synthesizer[] synthesizers,Container pane,int numSynthesizer){
    this.synthesizers = synthesizers;
    this.pane = pane;
    this.numSynthesizer = numSynthesizer;
  }
  //if an action event occurs some of this code will execute depending on the action event
  public void actionPerformed(ActionEvent e){
    // System.out.println(e.getActionCommand()); 
  
    String cmd = e.getActionCommand();
  
    //if user hits sine button
    if(cmd.contains("sine")){
      synthesizers[numSynthesizer].sin =true; 
      synthesizers[numSynthesizer].synthType.setText("Type[sine]");
    }
    //if user hits noise button
    if(cmd.contains("noise")){
      synthesizers[numSynthesizer].sin =false; 
      synthesizers[numSynthesizer].synthType.setText("Type[noise]");
    }
  
    //if user hits play button
    if(cmd.contains("PLAY")){
      System.out.println("Panel:"+numSynthesizer+"PLAY");
      PlaySynth p = new PlaySynth();
      p.play(synthesizers[numSynthesizer].volumeSlider.getValue(), synthesizers[numSynthesizer].pitchSlider.getValue(),
        synthesizers[numSynthesizer].lowCutoffSlider.getValue(),synthesizers[numSynthesizer].sin );
    }
    
  }
 
 

// END
}