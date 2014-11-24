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

import net.miginfocom.swing.MigLayout;


class Synthesizer extends JPanel{
   
  static int numSynths;
  int num;
  JLabel samplerLabel, voluLabel, pitchLabel, lowLabel, highLabel, attLabel, susLabel, relLabel;
  JButton play,synthType;
  JPopupMenu typeMenu = new JPopupMenu();
  JMenuItem newSin = new JMenuItem("sine");
  JMenuItem newNoise = new JMenuItem("noise"); 

  JSlider volumeSlider;
  JSlider pitchSlider;
  JSlider lowCutoffSlider;
  JSlider highCutoffSlider;
  JSlider attackSlider, sustainSlider, releaseSlider;
  boolean sin; //true= sin oscillator ; false = noise oscillator
 

  public Synthesizer(){
    num = Interface.numPanels;
    //creating sampler labels, buttons, and sliders
    samplerLabel = new JLabel();
    samplerLabel.setText("Sampler "+num);
    
    voluLabel = new JLabel();
    voluLabel.setText("Volume");
    
    pitchLabel = new JLabel();
    pitchLabel.setText("Pitch");
    
    lowLabel = new JLabel();
    lowLabel.setText("LowCut");
    
    highLabel = new JLabel();
    highLabel.setText("HighCut");   
    
    attLabel = new JLabel();
    attLabel.setText("Attack"); 
    
    susLabel = new JLabel();
    susLabel.setText("Sustain"); 
    
    relLabel = new JLabel();
    relLabel.setText("Release"); 
    
    sin = true;
    play = new JButton("PLAY");
    synthType = new JButton("Type[sine]");
      
    typeMenu.add(newSin);
    typeMenu.add(newNoise);
    
    synthType.addMouseListener( new MouseAdapter(){
      public void mousePressed(MouseEvent e) {
        typeMenu.show(e.getComponent(), e.getX(), e.getY());
      }
    });    
    
    volumeSlider = new JSlider(0,100,100);
    volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
    pitchSlider = new JSlider(0,1000,250);
    pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
    lowCutoffSlider = new JSlider(0,1000,100);
    lowCutoffSlider.setOrientation(SwingConstants.VERTICAL);
    
    highCutoffSlider = new JSlider(0,1000,100);
    highCutoffSlider.setOrientation(SwingConstants.VERTICAL);
    
    attackSlider = new JSlider(0, 20);
    attackSlider.setOrientation(SwingConstants.VERTICAL);
     
    sustainSlider = new JSlider(0, 20);
    sustainSlider.setOrientation(SwingConstants.VERTICAL);

    releaseSlider = new JSlider(0, 20);
    releaseSlider.setOrientation(SwingConstants.VERTICAL);
     
    //added sampler parameters to the sampler in Interface.buildSynthesizer
       
  }
// END
}