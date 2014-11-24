import javax.swing.event.ChangeEvent.*;
import javax.swing.event.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;

//CHNAGE LISENER FOR SAMPLER SLIDERS
class SliderListener implements ChangeListener{
  Sampler[] samplers;
  Container pane;
  int numSampler;
  char parameter; // v=volume, p=pitch & f=filter cutoff 
  
  
  SliderListener(Sampler[] samplers,Container pane,int numSampler,char parameter){
    this.samplers = samplers;
    this.pane = pane;
    this.numSampler = numSampler;
    this.parameter = parameter; 
  }
  //listens to any changes of any slider
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider)e.getSource();
    //volume
    System.out.print( "Panel: "+numSampler );
    switch( parameter ){
      case 'v' : System.out.print( " volume: " ); break;
      case 'p' : System.out.print( " pitch: " ); break; 
      case 'l' : System.out.print( " low cutoff: " ); break;
      case 'h' : System.out.print( " high cutoff: " ); break;
    }
    System.out.println( source.getValue() );
  }
// END
}
