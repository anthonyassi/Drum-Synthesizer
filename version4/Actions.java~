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
 
 Actions(MyPanel[] panels,Container pane){
  this.panels = panels;
  this.pane = pane;
 }
 //if an action event occurs some of this code will execute depending on the action event
 public void actionPerformed(ActionEvent e){
  System.out.println(e.getActionCommand()); 
  
  String cmd = e.getActionCommand();
  
   
  
  
    
    //if user hits add button, then increment numPanels and update the interface 
    if(cmd.contains("ADD")){
        MyPanel.numPanels++;
        Interface.updateGUI(pane);
        }
   
    if(cmd.contains("PLAY")){
      
    }
 
}
 
 


}