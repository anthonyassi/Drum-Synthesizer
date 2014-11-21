import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;


//ACTION LISTENER FOR sequencer BUTTONS
class SeqActions implements ActionListener{
  Sequencer s;
  JButton[] buttons;
  int[] sequence;
  Container pane;
  int i;

 
  SeqActions(Sequencer s,Container pane,int index){
    this.s = s;
    this.pane = pane;
    this.buttons = s.buttons;
    this.sequence = s.sequence;
    this.i = index;
  }
  //if an action event occurs some of this code will execute depending on the action event
  public void actionPerformed(ActionEvent e){
    // System.out.println(e.getActionCommand()); 
  
    String cmd = e.getActionCommand();
    
    //iterate through all buttons
    for(int j=0;j<16;j++){ 
      //find which button
    if(cmd.equals(""+(j+1))){
      //modify sequence array
      System.out.println((""+(j+1)));
      sequence[j] = 1;
      //print sequence array
      for(int k=0;k<16;k++){
        System.out.println("seqence["+k+"]"+sequence[k]);
      }
      
      
    }
    }
  }
 
 

// END
}