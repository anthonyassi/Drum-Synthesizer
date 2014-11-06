import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

import com.jsyn.*;
import com.jsyn.data.SequentialData;
import com.jsyn.unitgen.*;
import com.jsyn.util.*;
import com.jsyn.data.*;
import java.io.*;


class Sampler extends JPanel
{
   static JButton addChannel = new JButton("ADD");
   static int numSamplers;
   int num;
   JLabel label;
   JButton play, openButton;
   JSlider volumeSlider;
   JSlider pitchSlider;
   JSlider cutoffSlider;
   File sample = new File("/Users/Chris/Documents/GitHub/Drum-Synthesizer/samples/Snare1.wav");
   
   JTextArea log;
   JFileChooser fc;
 

   public Sampler(String chanVal)
  {
 setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
 
     num = numSamplers;
     //creating sampler labels, buttons, and sliders
     label = new JLabel();
     label.setText(chanVal);
     
     fc = new JFileChooser();
     fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

     openButton = new JButton("Open a File");
                                // createImageIcon("Open.png"));
     
     
     
     play = new JButton("PLAY");
     volumeSlider = new JSlider(0,100,100);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
     pitchSlider = new JSlider(0,100,100);
     pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
     cutoffSlider = new JSlider(0,1000,100);
     cutoffSlider.setOrientation(SwingConstants.VERTICAL);
     
     //add sampler parameters to the sampler
     add(label);
     add(openButton);
     add(play);
     add(volumeSlider);
     add(pitchSlider);
     add(cutoffSlider);
    
  }
   void playAudio(){
      
   }

 }