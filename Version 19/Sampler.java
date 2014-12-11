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

class Sampler extends Channel{

  public SamplerPanel panel;
  public SequencerPanel sequencer;

  private File sample;
  private LineOut lineOut;
  private SamplePlayer sampleSynth;

  
  public Sampler(){
    this.sequencer = new SequencerPanel();
    this.panel = new SamplerPanel( sequencer );
    this.sample = null;
    this.lineOut = new LineOut();
    this.sampleSynth = new SamplePlayer( lineOut );
    addListener();
  }
  
  public void addListener(){
    for( int j = 0; j < 16; j++ ){
      //SequencerButtonActions action = new SequencerButtonActions();
      sequencer.buttons[j].addActionListener( new SequencerButtonActions( sequencer, j ) );
    }
    panel.openButton.addMouseListener( 
      new MouseAdapter() {
        public void mousePressed( MouseEvent e ){
          int returnVal = panel.fc.showOpenDialog( null );
          if( returnVal == JFileChooser.APPROVE_OPTION ){
            System.out.println("You chose to open this file: " );
            System.out.println( panel.fc.getSelectedFile().getName());
            load( panel.fc.getSelectedFile() );
          } 
        }
      }
    );
    panel.play.addMouseListener( 
      new MouseAdapter() {
        public void mousePressed( MouseEvent e ){
          System.out.println("Panel: PLAY");
          play(); 
        }
      }
    );
  }
  
  public void play(){
    if( sample == null ) return;
    double volume = panel.getVolume();
    double lowCut = panel.getLowCut();
    double highCut = panel.getHighCut();
    sampleSynth.play( lineOut, sample, volume, lowCut, highCut );
  }
  
  public void load( File file){
    sample = file;
  }
  
  public int[] getSequence(){
    return sequencer.sequence;  
  }
  
}