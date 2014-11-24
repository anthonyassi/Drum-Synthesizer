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
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

class Sampler extends JPanel{
  static JButton addChannel = new JButton("+New...");
  int num;
  JLabel samplerLabel, voluLabel, pitchLabel, lowLabel, highLabel;
  JButton play, openButton;
  JSlider volumeSlider;
  JSlider pitchSlider;
  JSlider lowCutoffSlider;
  JSlider highCutoffSlider;
  File sample;
  JTextArea log;
  JFileChooser fc;
  Sequencer sequencer;
   
  public Sampler(){
    setLayout(new MigLayout()); 
    
    num = Interface.numPanels;
     //creating sampler labels, buttons, and sliders
   sequencer = new Sequencer();
   sequencer.add();
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
    
    fc = new JFileChooser();
    fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

    openButton = new JButton("Open a File");
                                // createImageIcon("Open.png"));
     
    play = new JButton("PLAY");
    volumeSlider = new JSlider(0,100,100);
    volumeSlider.setOrientation(SwingConstants.VERTICAL);
     
    pitchSlider = new JSlider(0,100,100);
    pitchSlider.setOrientation(SwingConstants.VERTICAL);
     
    lowCutoffSlider = new JSlider(0,1000,1000);
    lowCutoffSlider.setOrientation(SwingConstants.VERTICAL);
        
    highCutoffSlider = new JSlider(0,1000,0);
    highCutoffSlider.setOrientation(SwingConstants.VERTICAL);


    Interface.channelMenu.add(Interface.newSamp);
    Interface.channelMenu.add(Interface.newSynth);
    addChannel.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        Interface.channelMenu.show(e.getComponent(), e.getX(), e.getY());
      }
    });
    
    //add sampler parameters to the sampler
    add(samplerLabel, "wrap");
    add(openButton, "split 7");
    add(play);
    add(volumeSlider, "gapleft 80");
    add(pitchSlider, "gapleft 60");
    add(lowCutoffSlider, "gapleft 60");    
    add(highCutoffSlider, "gapleft 60");
    add(sequencer,"gapleft 30, wrap"); 
    add(voluLabel, "split 5, gapleft 228");
    add(pitchLabel, "gapleft 42");
    add(lowLabel, "gapleft 38");
    add(highLabel, "gapleft 36, wrap");
    
  }
// END
}