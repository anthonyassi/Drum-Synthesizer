import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

import com.jsyn.*;
import com.jsyn.data.SequentialData;
import com.jsyn.unitgen.*;
import com.jsyn.util.*;
import com.jsyn.data.*;
import java.io.*;


class MyPanel extends JPanel
{
   static JButton addChannel = new JButton("ADD");
   static int numPanels;
   int num;
   JLabel label;
   JButton play;
   JSlider volumeSlider;
   JSlider pitchSlider;
   File sample;
   

   public MyPanel(String chanVal)
  {
 // setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
 
     num = numPanels;
     //creating panel labels, buttons, and sliders
     label = new JLabel();
     label.setText(chanVal);
     
     play = new JButton("PLAY");
     volumeSlider = new JSlider(0,100,100);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
     pitchSlider = new JSlider(0,100,100);
     pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
     //add panel parameters to the panel
     add(label);
     add(play);
     add(volumeSlider);
     add(pitchSlider);
    
  }
   void playAudio(){
      
   }

 }