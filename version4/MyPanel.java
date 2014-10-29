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
   int num;
   JLabel label;
   JButton play;
   JSlider volumeSlider;
   JSlider pitchSlider;
   

   public MyPanel(String chanVal)
  {
 // setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
  //setLayout(createHorizontalBox());
     num = numPanels;
     label = new JLabel();
     label.setText(chanVal);
     add(label);
     
     setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
     
     play = new JButton("PLAY");
     volumeSlider = new JSlider(0,100,100);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     pitchSlider = new JSlider(0,100,100);
     pitchSlider.setOrientation(SwingConstants.VERTICAL);
     //add panel parameters to the panel
     add(play);
     add(volumeSlider);
     add(pitchSlider);
    
  }


 }