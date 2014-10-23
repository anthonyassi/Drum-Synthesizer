//VERSION 3
//THIS VERSION STARTS WITH ONE PANEL WITH BUTTON AND SLIDER
//THAT DONT DO ANYTHING. IMPLEMENTED "ADD" BUTTON THAT
//ADDS PANELS TO THE WINDOW. **CLICK "ADD" AND THEN 
//MANUALY RESIZE WINDOW IN ORDER TO SEE THE NEW CHANNEL



import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

class Interface{

  static MyPanel[] Panels = new MyPanel[8];
  public static void main(String[] args) {
  JFrame frame = new JFrame("Drum Synthesizer");
  Container pane = frame.getContentPane();
  
  
  buildGUI(pane);
  
  frame.addWindowListener(new Exiter());
  frame.pack();
  frame.setVisible(true);
  }
  
  
  static void buildGUI(Container pane){
    
    //Create Initial panel
    Panels[0] = new MyPanel("Channel 1");
    MyPanel.numPanels = 1;
    //Create action listen and give it to addpanel button
    Actions doAction = new Actions(Panels,pane);
    MyPanel.addChannel.addActionListener(doAction);
   
    updateGUI(pane);
    
  }
  
  static void updateGUI(Container pane){
   //if updateGUI is called from Actions class then creat new panel
    if(MyPanel.numPanels>1){
      int i = MyPanel.numPanels-1;
      Panels[i]  = new MyPanel("Channel"+(i+1));
      Panels[0].add(Panels[i]);
    }
  
    
    //Put addchannel button button under last channel
    Panels[(MyPanel.numPanels-1)].add(MyPanel.addChannel);
    
    //add panels to pane(window)
    pane.add(Panels[0]);
  }
  
  
}