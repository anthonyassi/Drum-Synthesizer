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
class SliderListener implements ChangeListener {
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
        if(parameter=='v'){
        System.out.println("Panel: "+numSampler+" volume: "+source.getValue());
        }
        //volume
        else if(parameter=='p'){
        System.out.println("Panel: "+numSampler+" pitch: "+source.getValue());
        }
        else if(parameter=='f'){
        System.out.println("Panel: "+numSampler+" filter cutoff: "+source.getValue());
        }
     }
}
