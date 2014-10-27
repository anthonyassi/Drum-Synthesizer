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
  SliderListener(MyPanel[] panels,Container pane,int numPanel){
  this.panels = panels;
  this.pane = pane;
  this.numPanel = numPanel;
 }
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        System.out.println("Panel: "+numPanel+" value: "+source.getValue());
           
            
    }
}
