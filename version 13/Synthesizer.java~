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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class Synthesizer extends JPanel
{
   
   static int numSynths;
   int num;
   JLabel label;
   JButton play,sine, noise;
   JSlider volumeSlider;
   JSlider pitchSlider;
   JSlider cutoffSlider;
   boolean sin; //true= sin oscillator ; false = noise oscillator
 

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
     
     sine = new JButton("SINE");
     sin = true;
     noise = new JButton("NOISE");
    
     volumeSlider = new JSlider(0,100,100);
     volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
     pitchSlider = new JSlider(0,1000,250);
     pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
     cutoffSlider = new JSlider(0,1000,100);
     cutoffSlider.setOrientation(SwingConstants.VERTICAL);
     
     //add sampler parameters to the sampler
     add(label);
     add(play);
     add(sine);
     add(noise);
     add(volumeSlider);
     add(pitchSlider);
     add(cutoffSlider);
     
    
  }

 }