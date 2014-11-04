import javax.swing.event.ChangeEvent.*;
import javax.swing.event.*; 
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;


class SliderListener implements ChangeListener {
  Sampler[] samplers;
 Container pane;
 int numPanel;
 char parameter; // v=volume & p=pitch
  SliderListener(Sampler[] samplers,Container pane,int numPanel,char parameter){
  this.samplers = samplers;
  this.pane = pane;
  this.numPanel = numPanel;
  this.parameter = parameter; 
 }
  //listens to any changes of any slider
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        //volume
        if(parameter=='v'){
        System.out.println("Panel: "+numPanel+" volume: "+source.getValue());
        }
        //volume
        else if(parameter=='p'){
        System.out.println("Panel: "+numPanel+" pitch: "+source.getValue());
        }
     }
}
