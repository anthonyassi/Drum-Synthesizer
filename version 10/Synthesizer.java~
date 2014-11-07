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

class Synthesizer extends JPanel
{
   
   static int numSynths;
   int num;
   JLabel label;
   JButton play;
   JSlider volumeSlider;
   JSlider pitchSlider;
   JSlider cutoffSlider;
   
 

   public Synthesizer()
  {
     JPanel outsidePanel = new JPanel();
     outsidePanel.setLayout(new BoxLayout(outsidePanel, BoxLayout.Y_AXIS));
     
     JPanel insidePanel = new JPanel();
     insidePanel.setLayout(new BoxLayout(insidePanel, BoxLayout.X_AXIS));
     
     outsidePanel.add(insidePanel);
     
     num = Interface.numPanels;
     //creating sampler labels, buttons, and sliders
     label = new JLabel();
     label.setText("Synthesizer "+num);
     
     play = new JButton("PLAY");
     volumeSlider = new JSlider(0,100,100);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
     pitchSlider = new JSlider(0,100,100);
     pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
     cutoffSlider = new JSlider(0,1000,100);
     cutoffSlider.setOrientation(SwingConstants.VERTICAL);
     
     //add sampler parameters to the sampler
     add(label);
     add(play);
     add(volumeSlider);
     add(pitchSlider);
     add(cutoffSlider);
    
  }

 }