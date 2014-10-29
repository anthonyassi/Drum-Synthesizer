import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.security.*;
import javax.sound.sampled.*;



public class ClipTest {

  public static void main (String[] args) throws Exception {

    // specify the sound to play
    // (assuming the sound can be played by the audio system)
    File soundFile = new File("Yamaha-SY-35-Clarinet-C5.wav");
    AudioInputStream sound = AudioSystem.getAudioInputStream(soundFile);

    // load the sound into memory (a Clip)
    DataLine.Info info = new DataLine.Info(Clip.class, sound.getFormat());
    Clip clip = (Clip) AudioSystem.getLine(info);
    clip.open(sound);
    
    FloatControl setVolume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);  //controlling volume
    
    // play the sound clip
    clip.start();        ///trying to call it from MyPanel.java instead
    
    Thread.sleep(1000);    //should be implemented in MyPanel.java under stop
    clip.stop();           //
    clip.close();          //
 
    // due to bug in Java Sound, explicitly exit the VM when
    // the sound has stopped.
    clip.addLineListener(new LineListener() {
      public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
          event.getLine().close();
          System.exit(0);
        }
      }
    });


    
  }
} 