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
  JLabel label;
  JButton play, openButton;
  JSlider volumeSlider;
  JSlider pitchSlider;
  JSlider lowCutoffSlider;
  JSlider highCutoffSlider;
  File sample;
  JTextArea log;
  JFileChooser fc;
  Sequencer sequence;
   
  public Sampler(){
    setLayout(new MigLayout()); 
    
    num = Interface.numPanels;
     //creating sampler labels, buttons, and sliders
    sequence = new Sequencer();
    label = new JLabel();
    label.setText("Sampler "+num);
     
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
   // sequencer.add();
    add(label, "wrap");
    add(openButton, "split 5");
    add(play);
    add(volumeSlider, "gapleft 80");
    add(pitchSlider);
    add(lowCutoffSlider );    
    add( highCutoffSlider );
    add( sequence, "wrap" );
  }
// END
}