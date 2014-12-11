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

class DrumSynthPanel extends JPanel{
  
  JLabel synthLabel, volumeLabel, pitchLabel, lowLabel, highLabel, attLabel, susLabel, relLabel;
  JButton play, synthType;
  JPopupMenu typeMenu = new JPopupMenu();
  JMenuItem newSin = new JMenuItem("sine");
  JMenuItem newNoise = new JMenuItem("noise"); 
  JSlider volumeSlider;
  JSlider pitchSlider;
  JSlider lowCutoffSlider;
  JSlider highCutoffSlider;
  JSlider attackSlider, sustainSlider, releaseSlider;
  SequencerPanel sequencer;
  Border border;

  public DrumSynthPanel( SequencerPanel seq ){
    setLayout( new MigLayout() );
    border = BorderFactory.createEtchedBorder();
    setBorder( border );
    this.sequencer = seq;
    this.synthLabel = new JLabel();
    this.volumeLabel = new JLabel();
    this.pitchLabel = new JLabel();
    this.lowLabel = new JLabel();
    this.highLabel = new JLabel();
    this.attLabel = new JLabel();
    this.susLabel = new JLabel();
    this.relLabel = new JLabel();
    this.volumeSlider = new JSlider( 0, 100, 100 );
    this.pitchSlider = new JSlider( 0, 1000, 250 );
    this.lowCutoffSlider = new JSlider( 0, 1000, 100 );
    this.highCutoffSlider = new JSlider( 0, 1000, 100 );
    this.attackSlider = new JSlider( 0, 20 );
    this.sustainSlider = new JSlider( 0, 20 );
    this.releaseSlider = new JSlider( 0, 20 );
    this.synthType = new JButton( "Sine" ); // createImageIcon("Open.png")); 
    this.play = new JButton( "PLAY" );
    addComponents();
  }
  
  public void addComponents(){
    typeMenu.add( newSin );
    typeMenu.add( newNoise );
    synthType.setPreferredSize( new Dimension( 95, 25 ) );
    volumeSlider.setOrientation( SwingConstants.VERTICAL );
    pitchSlider.setOrientation( SwingConstants.VERTICAL );
    pitchSlider.setOrientation( SwingConstants.VERTICAL );
    lowCutoffSlider.setOrientation( SwingConstants.VERTICAL );
    highCutoffSlider.setOrientation( SwingConstants.VERTICAL );
    attackSlider.setOrientation( SwingConstants.VERTICAL );
    sustainSlider.setOrientation( SwingConstants.VERTICAL );
    releaseSlider.setOrientation( SwingConstants.VERTICAL );
    volumeSlider.setBackground( Color.gray );
    pitchSlider.setBackground( Color.gray );
    pitchSlider.setBackground( Color.gray );
    lowCutoffSlider.setBackground( Color.gray );
    highCutoffSlider.setBackground( Color.gray );
    attackSlider.setBackground( Color.gray );
    sustainSlider.setBackground( Color.gray );
    releaseSlider.setBackground( Color.gray );
    sequencer.setBackground( Color.gray );
    synthLabel.setText( "Synthesizer" );
    volumeLabel.setText( "Volume" );
    pitchLabel.setText( "Pitch" );
    lowLabel.setText( "LowCut" );
    highLabel.setText( "HighCut" );   
    attLabel.setText( "Attack" ); 
    susLabel.setText( "Sustain" ); 
    relLabel.setText( "Release" );
    //add( synthLabel, "wrap" );
    add( synthType, "split 10" );
    add( play );
    add( volumeSlider, "gapleft 82" );
    add( pitchSlider, "gapleft 60" );
    add( lowCutoffSlider, "gapleft 60" );
    add( attackSlider, "gapleft 60" );
    add( releaseSlider, "gapleft 60" );
    add( sequencer, "gapleft 372, wrap" );
    add( volumeLabel, "split 7, gapleft 228" );
    add( pitchLabel, "gapleft 42" );
    add( lowLabel, "gapleft 38" );
    add( attLabel, "gapleft 34" );
    add( relLabel, "gapleft 35, wrap" );
  }
  
  public double getVolume(){ return volumeSlider.getValue(); }
  
  public double getPitch(){ return pitchSlider.getValue(); }
  
  public double getLowCut(){ return lowCutoffSlider.getValue(); }

  public double getHighCut(){ return highCutoffSlider.getValue(); }
  
  public double getAttack(){ return attackSlider.getValue(); }
  
  public double getSustain(){ return sustainSlider.getValue(); }
  
  public double getRelease(){ return releaseSlider.getValue(); }
  
}