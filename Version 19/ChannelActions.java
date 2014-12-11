import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



class ChannelActions implements ActionListener{
    
  public void actionPerformed(ActionEvent e){

    String cmd = e.getActionCommand();
    System.out.println( cmd );
  
    if( cmd.contains( "PLAY" ) ){
      System.out.println("Panel: PLAY");
      //play sample
      //PlaySample p = new PlaySample();
      //p.play(samplers[numSampler].sample, samplers[numSampler].volumeSlider.getValue(), samplers[numSampler].lowCutoffSlider.getValue(), 
        //samplers[numSampler].highCutoffSlider.getValue();
    }

  }
  
}
