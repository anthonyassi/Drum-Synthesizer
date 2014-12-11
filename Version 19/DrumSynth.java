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

class DrumSynth extends Channel{

  public DrumSynthPanel panel;
  public SequencerPanel sequencer;

  private LineOut lineOut;
  private DrumSynthPlayer drumSynth;
  private boolean sin;
  
  public DrumSynth(){
    this.sequencer = new SequencerPanel();
    this.panel = new DrumSynthPanel( sequencer );
    this.lineOut = new LineOut();
    this.drumSynth = new DrumSynthPlayer( lineOut );
    this.sin = true;
    addListeners();
  }
  
  public void addListeners(){
    for( int j = 0; j < 16; j++ ){
      sequencer.buttons[j].addActionListener( new SequencerButtonActions( sequencer, j ) );
    }
    panel.synthType.addMouseListener( 
      new MouseAdapter(){
        public void mousePressed(MouseEvent e) {
          panel.typeMenu.show( e.getComponent(), e.getX(), e.getY() );
        }
      }
    );
    panel.newSin.addMouseListener( 
      new MouseAdapter(){
        public void mousePressed(MouseEvent e) {
          sin = true;
          panel.synthType.setText( "Sine" );
          drumSynth.setWaveForm( sin );
        }
      }
    );
    panel.newNoise.addMouseListener( 
      new MouseAdapter(){
        public void mousePressed(MouseEvent e) {
          sin = false;
          panel.synthType.setText( "Noise" );
          drumSynth.setWaveForm( sin );
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
    double volume = panel.getVolume();
    double lowCut = panel.getLowCut();
    double pitch = panel.getPitch();
    double attack = panel.getAttack();
    double sustain = panel.getSustain();
    double release = panel.getRelease();
    drumSynth.play( lineOut, volume, pitch, lowCut, sin, attack, sustain, release );
  }
  
  public int[] getSequence(){
    return sequencer.sequence;  
  }
  
}