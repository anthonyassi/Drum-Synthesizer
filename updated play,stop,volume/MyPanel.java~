import java.util.Scanner;
import java.io.*;

import javax.sound.sampled.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import static java.awt.BorderLayout.*;

import javax.swing.JLabel;


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.security.*;




class MyPanel extends JPanel
{
   static int numPanels;
   JLabel label;
   JButton play, stop;
   JSlider volumeSlider;
   JSlider pitchSlider;


   public MyPanel(String chanVal)
  {
  final int FPS_MIN = 0;
  final int FPS_MAX = 100;
  final int FPS_INIT = 50;    //ints for range from 0-100 of volume slider
  
     setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     // setLayout(new FlowLayout());
     label = new JLabel();
     label.setText(chanVal);
     
     play = new JButton("PLAY");
     play.addActionListener(
       new ActionListener(){              //once you click play, this will happen
              public void actionPerformed(ActionEvent e){
                //ClipTest.ClipTest().clip.start(); //not sure what arguments to give it
                }});
     stop = new JButton("STOP");
     stop.addActionListener(
       new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  //ClipClipTest.clip.stop() function from cliptest
              }});
     
     
     JSlider volumeRange = new JSlider(JSlider.VERTICAL,
             FPS_MIN, FPS_MAX, FPS_INIT);
     volumeSlider = volumeRange;
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
    
     add(label);
     add(play);
     add(stop);
     add(volumeSlider);
      
  }

}
