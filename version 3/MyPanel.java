import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;


class MyPanel extends JPanel
{
   static JButton addChannel = new JButton("ADD");
   static int numPanels;
   JLabel label;
   JButton play;
   JSlider volumeSlider;
   JSlider pitchSlider;


   public MyPanel(String chanVal)
  {
  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     
     label = new JLabel();
     label.setText(chanVal);
     
     play = new JButton("PLAY");
     volumeSlider = new JSlider(0,1,1);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     //add panel parameters to the panel
     add(label);
     add(play);
     add(volumeSlider);
    
  }


 }