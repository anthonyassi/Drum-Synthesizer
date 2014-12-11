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

class SamplePlayer{
  
  private static Synthesizer synth;
  private static FilterStateVariable filter;
  private static FilterStateVariable highpass;
  private static LineOut lineOut;
  private static FloatSample sample;
  private static VariableRateDataReader player;
  private static VariableRateMonoReader mono;
  private static VariableRateStereoReader stereo;
  
  public SamplePlayer( LineOut line ){
    this.synth = JSyn.createSynthesizer();
    this.lineOut = line;
    this.filter = new FilterStateVariable();
    this.highpass = new FilterStateVariable();
    this.sample = null;
    this.player = null;
    this.mono =  new VariableRateMonoReader();
    this.stereo = new VariableRateStereoReader();
  }
  
  private static void route(){
      synth.add( lineOut );
      if( sample.getChannelsPerFrame() == 1 ){
        player = mono;
        synth.add( player );
        synth.add( filter );
        // route sample output to filter, route filter output to lineout
        player.output.connect( 0, filter.input, 0 );
        filter.lowPass.connect( 0, lineOut.input, 0 );
      }
      else if( sample.getChannelsPerFrame() == 2 ){
        player = stereo;
        synth.add( player );
        synth.add( filter );
        // again, route inputs. for some reason, filter has only mono output?
        player.output.connect( 0, filter.input, 0 );
        filter.lowPass.connect( 0, lineOut.input, 1 );
      }
      else{
        throw new RuntimeException(
        "Can only play mono or stereo samples." );
      }  
  }
  
  public void play( LineOut line, File loadedSample, double volume, double lowCutoff, double highCutoff ){
    lineOut = line;
    filter.frequency.set( lowCutoff );
    highpass.frequency.set( highCutoff );
    try{
      synth.start();
      SampleLoader.setJavaSoundPreferred( false );
      sample = SampleLoader.loadFloatSample( loadedSample );
      route();
      player.rate.set( sample.getFrameRate() );
      player.amplitude.set( volume / 100 );
      lineOut.start(); // We only need to start the LineOut. It will pull data from player.
      if( sample.getSustainBegin() < 0 ){
        System.out.println( "queue the sample" );
        player.dataQueue.queue( sample );
      }
      else{
        System.out.println( "queueOn the sample" );
        player.dataQueue.queueOn( sample );
        synth.sleepFor( 8.0 );
        System.out.println( "queueOff the sample" );
        player.dataQueue.queueOff( sample );
      }
      // Wait until the sample has finished playing.
      do{ synth.sleepFor( 1.0 ); }
      while( player.dataQueue.hasMore() );
      synth.sleepFor( 0.5 );
    }
    catch( IOException e1 ){ e1.printStackTrace(); }
    catch( InterruptedException e ){ e.printStackTrace(); }
    // Stop everything.
    synth.stop();
  }
  
  
  
}