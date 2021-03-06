//package com.jsyn.examples;

import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitVoice;
import com.softsynth.shared.time.TimeStamp;
import com.jsyn.unitgen.*;
import com.jsyn.unitgen.Circuit;
import com.jsyn.instruments.NoiseHit;
import com.jsyn.data.*;

/**
 * Play notes using timestamped noteOn and noteOff methods of the UnitVoice.
 * 
 * @author Phil Burk (C) 2009 Mobileer Inc
 * 
 */
public class DrumSynthPlayer{
  
  Synthesizer synth;
  UnitGenerator ugen;
  UnitVoice voice;
  LineOut lineOut;
  NoiseHit noise;
  FilterStateVariable filter;

  public DrumSynthPlayer( LineOut lineOut ){
  }
  

  //WhiteNoise noise;
  
  
  void play(double volume, double pitch, double cutoff, boolean sin, double attk, double sust, double release){
    // Create a context for the synthesizer.
    synth = JSyn.createSynthesizer();
    filter = new FilterStateVariable();
    // Set output latency to 123 msec because this is not an interactive app. noise
    synth.getAudioDeviceManager().setSuggestedOutputLatency( 0.010 );
  
    // Add a tone generator.
    //sine 
    if(sin){
      synth.add( ugen = new SineOscillator() );
      voice = (UnitVoice) ugen;
    }
    //noise
    else{
      synth.add( noise  = new NoiseHit());
      // synth.add( noise  = new WhiteNoise());
    }
    // Add an output mixer.
    synth.add( lineOut = new LineOut() );
    synth.add( filter );
  
    // Connect the oscillator to the left and right audio output.
    //sine
    if( sin ){
      voice.getOutput().connect( 0, filter.input, 0 );
      filter.lowPass.connect( 0, lineOut.input, 0 );
    }
    else{
      noise.getOutput().connect( 0, lineOut.input, 0 );
      noise.getOutput().connect( 0, lineOut.input, 1 );
    }
    
    
    //if(env){
             // Create an amplitude envelope and fill it with data.
        double[] ampData = {
                attk, -0.9, // duration,value pair 0, "attack"
                sust, -0.5, // pair 1, "decay"
                release, -0.4,  // pair 2, "release"
        };
        SegmentedEnvelope ampEnvelope = new SegmentedEnvelope( ampData );

        // Hang at end of decay segment to provide a "sustain" segment.
        //ampEnvelope.setSustainBegin( 3 );
        //ampEnvelope.setSustainEnd( 3 );

        // Play the envelope using queueOn so that it uses the sustain and release information.
        VariableRateDataReader ampEnv = new VariableRateMonoReader() ;
        synth.add( ampEnv );
        ampEnv.output.connect( 0, lineOut.input, 0 );
        ampEnv.dataQueue.queueOn( ampEnvelope );    
    
 //}     

    
    // Start synthesizer using default stereo output at 44100 Hz.
    synth.start();
 
    // Get synthesizer time in seconds.
    double timeNow = synth.getCurrentTime();

    // Advance to a near future time so we have a clean start.
    TimeStamp timeStamp = new TimeStamp(timeNow + 0.5);

    // We only need to start the LineOut. It will pull data from the
    // oscillator.
    synth.startUnit( lineOut, timeStamp );
  
    // Schedule a note on and off.
   
    double duration = 1.4;
    double onTime = 1.0;
    //set pitch and volume
    //sine
    if(sin){
      voice.noteOn( pitch, volume/100, timeStamp );
      //amp envelope is a function of amplitude(volume over time 
      //between note on and note off. 
      voice.noteOff( timeStamp.makeRelative( onTime ) );
    }
    else{
      noise.noteOn( pitch, volume/100, timeStamp );
      noise.noteOff( timeStamp.makeRelative( onTime ) );
    }
  

    // Sleep while the song is being generated in the background thread.
    try{
      System.out.println("Sleep while synthesizing.");
      synth.sleepUntil( timeStamp.getTime() + 2.0 );
      System.out.println("Woke up...");
    } 
    catch( InterruptedException e ){
      e.printStackTrace();
    }

    // Stop everything.
    synth.stop();
  }
// END
}

/*import com.jsyn.JSyn;
import com.jsyn.Synthesizer;
import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.SawtoothOscillator;
import com.jsyn.unitgen.UnitGenerator;
import com.jsyn.unitgen.UnitVoice;
import com.softsynth.shared.time.TimeStamp;
import com.jsyn.unitgen.*;
import com.jsyn.unitgen.Circuit;
import com.jsyn.instruments.NoiseHit;
import com.jsyn.data.*;

class DrumSynthPlayer{
  
  private Synthesizer synth;
  private UnitGenerator ugen;
  private UnitVoice voice;
  private LineOut lineOut;
  private NoiseHit noise;
  private FilterStateVariable filter;
  private FilterStateVariable highpass;
  private boolean sin;
  
  public DrumSynthPlayer( LineOut line ){
    this.synth = null;
    this.ugen = new SineOscillator();
    this.lineOut = line;
    this.filter = new FilterStateVariable();
    this.highpass = new FilterStateVariable();
    this.sin = true;
    
    this.voice = ( UnitVoice ) ugen;
    this.noise = new NoiseHit();
    /*if( sin ) synth.add( ugen );
    else synth.add( noise );
    synth.add( lineOut );
    synth.add( filter );*/
  //}
  
/*  void play( LineOut line, double volume, double pitch, double cutoff, boolean sinWave, double attk, double sust, double release ){
    synth = JSyn.createSynthesizer();
    synth.add( lineOut );
    synth.add( filter );
    ugen = new SineOscillator();
    voice = ( UnitVoice ) ugen;
    noise = new NoiseHit();
    if( sinWave ) synth.add( ugen );
    else synth.add( noise );
    // Create a context for the synthesizer.
    // Set output latency to 123 msec because this is not an interactive app. noise
    synth.getAudioDeviceManager().setSuggestedOutputLatency( 0.040 );
      // synth.add( noise  = new WhiteNoise());
    // Add an output mixer.

    // Connect the oscillator to the left and right audio output.
    route();
    // Create an amplitude envelope and fill it with data.
    double[] ampData = {
                attk, -0.9, // duration,value pair 0, "attack"
                sust, -0.5, // pair 1, "decay"
                release, -0.4,  // pair 2, "release"
    };
    SegmentedEnvelope ampEnvelope = new SegmentedEnvelope( ampData );
    // Hang at end of decay segment to provide a "sustain" segment.
    //ampEnvelope.setSustainBegin( 3 );
    //ampEnvelope.setSustainEnd( 3 );
    // Play the envelope using queueOn so that it uses the sustain and release information.
    VariableRateDataReader ampEnv = new VariableRateMonoReader() ;
    synth.add( ampEnv );
    ampEnv.output.connect( 0, lineOut.input, 0 );
    ampEnv.dataQueue.queueOn( ampEnvelope );    
    // Start synthesizer using default stereo output at 44100 Hz.
    synth.start();
    // Get synthesizer time in seconds.
    double timeNow = synth.getCurrentTime();
    // Advance to a near future time so we have a clean start.
    TimeStamp timeStamp = new TimeStamp( timeNow + 0.5 );
    // We only need to start the LineOut. It will pull data from the
    // oscillator.
    synth.startUnit( lineOut, timeStamp );
    // Schedule a note on and off.
    double duration = 1.4;
    double onTime = 1.0;
    //set pitch and volume
    //sine
    if( sin ){
      voice.noteOn( pitch, ( volume / 100 ), timeStamp );
      //amp envelope is a function of amplitude(volume over time 
      //between note on and note off. 
      voice.noteOff( timeStamp.makeRelative( onTime ) );
    }
    else{
      noise.noteOn( pitch, volume/100, timeStamp );
      noise.noteOff( timeStamp.makeRelative( onTime ) );
    }
    // Sleep while the song is being generated in the background thread.
    try{ synth.sleepUntil( timeStamp.getTime() + 2.0 ); } 
    catch( InterruptedException e ){ e.printStackTrace(); }
    // Stop everything.
    synth.stop();
  }
  
  private void route(){
    voice.getOutput().disconnect( 0, filter.input, 0 );
    noise.getOutput().disconnect( 0, filter.input, 0 );
    filter.lowPass.disconnect( 0, lineOut.input, 0 );
    if( sin ){
      voice.getOutput().connect( 0, filter.input, 0 );
      filter.lowPass.connect( 0, lineOut.input, 0 );
    }
    else{
      noise.getOutput().connect( 0, filter.input, 0 );
      filter.lowPass.connect( 0, lineOut.input, 0 );
    }
  }

  public void setWaveForm( boolean sinWave ){
    if( sinWave != sin ){
      sin = sinWave;
      synth = JSyn.createSynthesizer();
      if( sin ) synth.add( ugen );
      else synth.add( noise );
    }
  }
  
}*/