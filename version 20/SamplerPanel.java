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
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class SamplerPanel extends JPanel{
  
  JLabel samplerLabel, volumeLabel, pitchLabel, lowLabel, highLabel;
  JButton play, openButton;
  JSlider volumeSlider;
  JSlider pitchSlider;
  JSlider lowCutoffSlider;
  JSlider highCutoffSlider;
  JFileChooser fc;
  SequencerPanel sequencer;
  Border border;
  
  public SamplerPanel( SequencerPanel seq ){
    setLayout( new MigLayout() );
    border = BorderFactory.createEtchedBorder();
    setBorder( border );
    this.sequencer = seq;
    this.samplerLabel = new JLabel();
    this.volumeLabel = new JLabel();
    this.pitchLabel = new JLabel();
    this.lowLabel = new JLabel();
    this.highLabel = new JLabel();
    this.fc = new JFileChooser();
    fc.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );
    openButton = new JButton("Open a File"); // createImageIcon("Open.png")); 
    this.play = new JButton("PLAY");
    volumeSlider = new JSlider(0,100,100);
    volumeSlider.setOrientation(SwingConstants.VERTICAL);
    pitchSlider = new JSlider(0,100,100);
    pitchSlider.setOrientation(SwingConstants.VERTICAL);
    lowCutoffSlider = new JSlider(0,1000,1000);
    lowCutoffSlider.setOrientation(SwingConstants.VERTICAL);      
    highCutoffSlider = new JSlider(0,1000,0);
    highCutoffSlider.setOrientation(SwingConstants.VERTICAL);
    volumeSlider.setBackground( Color.lightGray );
    pitchSlider.setBackground( Color.lightGray );
    lowCutoffSlider.setBackground( Color.lightGray );     
    highCutoffSlider.setBackground( Color.lightGray );
    sequencer.setBackground( Color.lightGray );
    addComponents();
  }
  
  public void addComponents(){
    samplerLabel.setText( "Sampler" );
    volumeLabel.setText( "Volume" ); 
    pitchLabel.setText( "Pitch" );
    lowLabel.setText( "LowCut" );
    highLabel.setText( "HighCut" );    
    add(openButton, "split 7");
    add(play);
    add(volumeSlider, "gapleft 80");
    add(lowCutoffSlider, "gapleft 60");    
    add(sequencer, "gapleft 600, wrap");
    add(volumeLabel, "split 5, gapleft 228");
    add(lowLabel, "gapleft 38");
  }
  
  
  public double getVolume(){ return volumeSlider.getValue(); }
  
  public double getLowCut(){ return lowCutoffSlider.getValue(); }

  public double getHighCut(){ return highCutoffSlider.getValue(); }
  
}