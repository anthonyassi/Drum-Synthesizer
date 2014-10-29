import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

class Actions implements ActionListener{
 MyPanel[] panels;
 Container pane;
 int numPanel;
 Actions(MyPanel[] panels,Container pane,int numPanel){
  this.panels = panels;
  this.pane = pane;
  this.numPanel = numPanel;
 }
 //if an action event occurs some of this code will execute depending on the action event
 public void actionPerformed(ActionEvent e){
 // System.out.println(e.getActionCommand()); 
  
  String cmd = e.getActionCommand();
  
   
  
  
    
    //if user hits add button, then increment numPanels and update the interface 
    if(cmd.contains("ADD")){
        MyPanel.numPanels++;
        Interface.updateGUI(pane);
        }
   //PLAY AUDIO CLIP 
    if(cmd.contains("PLAY")){
      System.out.println("Panel:"+numPanel+"PLAY");
     JButton b =((JButton)e.getSource());
    //Panels[numPanel].playAudio();
    }
 
}
 
 


}