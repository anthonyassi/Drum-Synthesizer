import javax.swing.event.ChangeEvent.*;
import javax.swing.event.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;

//CHANGE LISTNER FOR SYNTH SLIDERS
class SynthListener implements ChangeListener {
  Synthesizer[] synthesizers;
  Container pane;
  int numSynthesizer;
  char parameter; // v=volume, p=pitch & f=filter cutoff 
  
  SynthListener(Synthesizer[] synthesizers,Container pane,int numSynthesizer,char parameter){
    this.synthesizers = synthesizers;
    this.pane = pane;
    this.numSynthesizer = numSynthesizer;
    this.parameter = parameter; 
  }
  //listens to any changes of any slider
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    //volume
    if(parameter=='v'){
      System.out.println("Panel: "+numSynthesizer+" volume: "+source.getValue());
    }
    //volume
    else if(parameter=='p'){
      System.out.println("Panel: "+numSynthesizer+" pitch: "+source.getValue());
    }
    else if(parameter=='f'){
      System.out.println("Panel: "+numSynthesizer+" filter cutoff: "+source.getValue());
    }
  }
// END
}
