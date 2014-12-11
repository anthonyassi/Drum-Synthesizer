import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.*;


class InterfaceActions implements ActionListener{

  //if an action event occurs some of this code will execute depending on the action event
  boolean isSeqPlaying;
  ScheduledExecutorService exec; 
  
  public InterfaceActions(){
    this.isSeqPlaying = false;
    this.exec = null;
  }
  
  public void actionPerformed(ActionEvent e){
    
    String cmd = e.getActionCommand();
    System.out.println( cmd );
  
    //if user adds new sampler or synth, then increment numSamplers and update the interface 
    if( cmd.contains( "Sampler") ){
      Interface.addSampler();
    }
    if( cmd.contains( "Synth" ) ){
      Interface.addSynthesizer();
    }
    
    if( cmd.equals("Play") ){
      exec = Executors.newSingleThreadScheduledExecutor();
      if( isSeqPlaying == false ){
        isSeqPlaying = true;
        System.out.println("play sequencer");
        //start the sequencer
        //iterate through each step (k)
        exec.scheduleAtFixedRate( new Runnable() {
          
          @Override
          public void run() {
            if( isSeqPlaying == false ) return;
            for( int k = 0; k < 16; k++ ){
              System.out.println(k);
              //iterate through each channel (j)
              for( int j = 0; j < Interface.numChannels; j++ ){
                Channel channel = Interface.channels[j];
                int[] aSequence = channel.getSequence(); 
                System.out.println("sampler:"+j+" step"+k+"="+aSequence[k]);
                if( aSequence[k] == 1 ) channel.play(); 
              }
            }
            isSeqPlaying = false;
          }
        }, 0, 100, TimeUnit.MILLISECONDS);
      }
      else{
        isSeqPlaying = false;
        System.out.println("stop sequencer");
     }
  } 
   //if user hits play button
  }
//END    
}
 
 

