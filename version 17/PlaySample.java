//package com.jsyn.examples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.data.FloatSample;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.VariableRateDataReader;
import com.jsyn.unitgen.VariableRateMonoReader;
import com.jsyn.unitgen.VariableRateStereoReader;
import com.jsyn.util.SampleLoader;

import com.jsyn.*;
import com.jsyn.data.SequentialData;
import com.jsyn.unitgen.*;
import com.jsyn.util.*;
import com.jsyn.data.*;
import java.io.*;


/**
 * Play a sample from a WAV file using JSyn.
 * 
 * @author Phil Burk (C) 2010 Mobileer Inc
 * 
 */
public class PlaySample{
  private Synthesizer synth;
  private VariableRateDataReader samplePlayer;
  private FilterStateVariable filter;
  private FilterStateVariable highpass;
  private LineOut lineOut;
  
  
 
  void play( File loadedSample,double volume, double lowCutoff, double highCutoff ){
    
    if( loadedSample == null ) return;
    
    URL sampleFile;
    // File loadedSample = new File("/Users/anthony/Desktop/Drum-Synthesizer/samples/Snare1.wav");
    try{
      //sampleFile = new URL("http://www.softsynth.com/samples/Clarinet.wav");
      sampleFile = new URL("http://www.softsynth.com/samples/NotHereNow22K.wav");
    } 
    catch( MalformedURLException e2 ){
      e2.printStackTrace();
      return;
    }
  
    synth = JSyn.createSynthesizer();
    // add a filter generator and set cutoff frequency
    filter = new FilterStateVariable();
    highpass = new FilterStateVariable();
    filter.frequency.set( lowCutoff );
    highpass.frequency.set( highCutoff );
    FloatSample sample;
    try{
      // Add an output mixer.
      synth.add( lineOut = new LineOut() );

      // Load the sample and display its properties.
      SampleLoader.setJavaSoundPreferred( false );
      sample = SampleLoader.loadFloatSample( loadedSample );
      System.out.println( "Sample has: channels  = " + sample.getChannelsPerFrame() );
      System.out.println( "            frames    = " + sample.getNumFrames() );
      System.out.println( "            rate      = " + sample.getFrameRate() );
      System.out.println( "            loopStart = " + sample.getSustainBegin() );
      System.out.println( "            loopEnd   = " + sample.getSustainEnd() );

      if( sample.getChannelsPerFrame() == 1 ){
        synth.add( samplePlayer = new VariableRateMonoReader() );
        synth.add( filter );
        // route sample output to filter, route filter output to lineout
        samplePlayer.output.connect( 0, filter.input, 0 );
        filter.lowPass.connect( 0, lineOut.input, 0 );
      }
      else if( sample.getChannelsPerFrame() == 2 ){
        synth.add( samplePlayer = new VariableRateStereoReader() );
        synth.add( filter );
        // again, route inputs. for some reason, filter has only mono output?
        samplePlayer.output.connect( 0, filter.input, 0 );
        filter.lowPass.connect( 0, lineOut.input, 1 );
      }
      else{
        throw new RuntimeException(
        "Can only play mono or stereo samples." );
      }

      // Start synthesizer using default stereo output at 44100 Hz.
      synth.start();

      samplePlayer.rate.set( sample.getFrameRate() );
      //set volume
      samplePlayer.amplitude.set(volume/100);
      // We only need to start the LineOut. It will pull data from the
      // sample player.
      lineOut.start();
     
      // We can simply queue the entire file.
      // Or if it has a loop we can play the loop for a while.
      if( sample.getSustainBegin() < 0 ){
        System.out.println( "queue the sample" );
        samplePlayer.dataQueue.queue( sample );
      }
      else{
        System.out.println( "queueOn the sample" );
        samplePlayer.dataQueue.queueOn( sample );
        synth.sleepFor( 8.0 );
        System.out.println( "queueOff the sample" );
        samplePlayer.dataQueue.queueOff( sample );
      }
   
      // Wait until the sample has finished playing.
      do{
        synth.sleepFor( 1.0 );
      }
      while( samplePlayer.dataQueue.hasMore() );

      synth.sleepFor( 0.5 );
   
    }
    catch( IOException e1 ){
      e1.printStackTrace();
    }
    catch( InterruptedException e ){
      e.printStackTrace();
    }
    // Stop everything.
    synth.stop();
  }
// END
}
