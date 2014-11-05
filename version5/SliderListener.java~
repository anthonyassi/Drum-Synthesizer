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
  MyPanel[] panels;
 Container pane;
 int numPanel;
 char parameter; 
  SliderListener(MyPanel[] panels,Container pane,int numPanel,char parameter){
  this.panels = panels;
  this.pane = pane;
  this.numPanel = numPanel;
  this.parameter = parameter;
 }
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
       
        if(parameter=='v'){
        System.out.println("Panel: "+numPanel+" volume: "+source.getValue());
        }
        else if(parameter=='p'){
        System.out.println("Panel: "+numPanel+" pitch: "+source.getValue());
        }
        
           
            
    }
}
