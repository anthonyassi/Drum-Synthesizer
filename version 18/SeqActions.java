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
  boolean isSeqPlaying;

 
  SeqActions(Sequencer s,Container pane,int index){
    this.s = s;
    this.pane = pane;
    this.buttons = s.buttons;
    this.sequence = s.sequence;
    this.i = index;
    isSeqPlaying = false;
  }
  //if an action event occurs some of this code will execute depending on the action event
  public void actionPerformed(ActionEvent e){
    // System.out.println(e.getActionCommand()); 
  
    String cmd = e.getActionCommand();
    
    
    if(cmd.equals(">")){
      if(isSeqPlaying==false){
        isSeqPlaying = true;
      System.out.println("play sequencer");
      }
      else{
        isSeqPlaying = false;
      System.out.println("stop sequencer");
      }
    }
    //iterate through all buttons
    for(int j=0;j<16;j++){ 
      //find which button
    if(cmd.equals(""+(j+1))){
      //modify sequence array
      if(sequence[j] == 0){
      System.out.println((""+(j+1)));
      sequence[j] = 1;
      buttons[j].setBackground(Color.RED);
      buttons[j].setOpaque(true);
      }
      else{
       System.out.println((""+(j+1)));
      sequence[j] = 0;
      buttons[j].setOpaque(false);
      }
      //print sequence array
      for(int k=0;k<16;k++){
        System.out.println("seqence["+(k+1)+"]"+sequence[k]);
      }
      
      
    }
    }
  }
 
 

// END
}