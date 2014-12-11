import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.util.concurrent.*;

class SequencerButtonActions implements ActionListener{

  SequencerPanel theSequencer;
  JButton[] buttons;
  int index;
  int[] theSequence; 
  
  public SequencerButtonActions( SequencerPanel sequencer, int index ){
    this.theSequencer = sequencer;
    this.index = index;
    this.theSequence = sequencer.sequence; 
    this.buttons = sequencer.buttons;
  }
    
  public void actionPerformed(ActionEvent e){
    if( theSequence[index] == 0){
      System.out.println((""+(index+1)));
      theSequence[index] = 1;
      buttons[index].setBackground(Color.red);
      buttons[index].setForeground(Color.red);
    }
    else{
      System.out.println((""+(index+1)));
      theSequence[index] = 0;
      buttons[index].setBackground(Color.white);
      buttons[index].setForeground(Color.white);
    }
  }
  
}