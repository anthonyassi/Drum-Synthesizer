import com.jsyn.*;
import com.jsyn.data.SequentialData;
import com.jsyn.unitgen.*;
import com.jsyn.util.*;
import com.jsyn.data.*;
import java.io.*;

class SamplePlayer{

  public static void main( String[] args ) throws IOException{

    Synthesizer synth = JSyn.createSynthesizer();
    synth.start();
    File sample = new File("/afs/cats.ucsc.edu/users/l/ayoung4/CS115/Channel/jsyn channel/Yamaha-SY-35-Clarinet-C5.wav");
    FloatSample clarinetSample = SampleLoader.loadFloatSample( sample );
    VariableRateMonoReader samplePlayer = new VariableRateMonoReader();
    samplePlayer.dataQueue.queueLoop( clarinetSample, 0, clarinetSample.getNumFrames() );
    synth.stop();

  }
// END
}