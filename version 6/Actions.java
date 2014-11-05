import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;



class Actions implements ActionListener{
 MyPanel[] Panels;
 Container pane;
 int numPanel;
 Actions(MyPanel[] panels,Container pane,int numPanel){
  this.Panels = panels;
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
   //if user hits play button
    if(cmd.contains("PLAY")){
      System.out.println("Panel:"+numPanel+"PLAY");
      //play sample
      PlaySample p = new PlaySample();
      p.play(Panels[numPanel].sample,Panels[numPanel].volumeSlider.getValue());
    }
    if(cmd.contains("Open a File")){
      System.out.println("OpenEnded");
      int returnVal = Panels[numPanel].fc.showOpenDialog(null);
      if(returnVal == JFileChooser.APPROVE_OPTION) {
       System.out.println("You chose to open this file: " );
           System.out.println( Panels[numPanel].fc.getSelectedFile().getName());
           Panels[numPanel].sample = Panels[numPanel].fc.getSelectedFile();
    }
    }
    
}
 
 


}