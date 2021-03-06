//VERSION 12
//FEEL FREE TO ADD, REPLACE, FIX CODE, JUST SAVE IT 
//AS A NEW VERSION.


import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;


class Interface{
  static int numPanels;
  static Sampler[] samplers = new Sampler[8];
  static Synthesizer[] synthesizers = new Synthesizer[8]; 
  static JButton addChannel = new JButton("+New...");
  static JButton playSeq = new JButton(">");
  static JPopupMenu channelMenu = new JPopupMenu();
  static JMenuItem newSamp = new JMenuItem("Sampler");
  static JMenuItem newSynth = new JMenuItem("Synth"); 
  static Actions doAction;
  static Reset doReset;
  static JButton reset = new JButton("New Project");
  
  
  public static void main(String[] args){
    JFrame frame = new JFrame("Drum Synthesizer");
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());
  
    buildGUI(pane);
    
    JPanel insidePanel = new JPanel();                 
    insidePanel.setLayout(new BorderLayout());  
    pane.add(insidePanel, BorderLayout.SOUTH);
  
    frame.addWindowListener(new Exiter());
  
    frame.setSize(1000,1075);
    frame.setVisible(true);
    frame.setResizable(false);  //prevent resizing
    
    doReset = new Reset(Reset.interf,pane,0);
       reset.addActionListener(doReset);
  }
  
  
  static void buildGUI(Container pane){
    numPanels++;
    //Create Initial sampler
    samplers[0] = new Sampler();
    //Create action listen and give it to addChannel button
    doAction = new Actions(samplers,pane,0);
    //listen for add button
    addChannel.addActionListener(doAction);
    newSamp.addActionListener(doAction);
    newSynth.addActionListener(doAction);
    playSeq.addActionListener(new SeqActions(samplers[0].sequencer,pane,0));
    
    samplers[0].openButton.addActionListener(doAction);
    samplers[0].play.addActionListener(doAction);
    samplers[0].volumeSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'v'));
    samplers[0].pitchSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'p'));
    samplers[0].lowCutoffSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'l'));
    samplers[0].highCutoffSlider.addChangeListener(new SliderListener(samplers, pane, 0, 'h'));
    for(int j=0;j<16;j++){
        samplers[0].sequencer.buttons[j].addActionListener(new SeqActions(samplers[0].sequencer,pane,j));
      }
    buildSampler(pane);
  }
  
  static void buildSampler(Container pane){
    
   //if buildSampler is called from Actions class then creat new channel
    if(numPanels>1){
      int i = numPanels-1;
      samplers[i]  = new Sampler();
      samplers[i].openButton.addActionListener(new Actions(samplers,pane,i));
      samplers[i].play.addActionListener(new Actions(samplers,pane,i));
      samplers[i].volumeSlider.addChangeListener(new SliderListener(samplers, pane, i,'v'));
      samplers[i].pitchSlider.addChangeListener(new SliderListener(samplers, pane, i,'p'));
      samplers[i].lowCutoffSlider.addChangeListener(new SliderListener(samplers, pane, i,'l'));
      samplers[i].highCutoffSlider.addChangeListener(new SliderListener(samplers, pane, i,'h'));
      for(int j=0;j<16;j++){
        samplers[i].sequencer.buttons[j].addActionListener(new SeqActions(samplers[i].sequencer,pane,j));
      }
      samplers[0].add(samplers[i].samplerLabel, "wrap");
      samplers[0].add(samplers[i].openButton, "split 7");
      samplers[0].add(samplers[i].play);
      samplers[0].add(samplers[i].volumeSlider, "gapleft 60, h 74!");
      samplers[0].add(samplers[i].pitchSlider,"gapleft 20, h 74!");
      samplers[0].add(samplers[i].lowCutoffSlider, "gapleft 20, h 74!");
      samplers[0].add(samplers[i].highCutoffSlider, "gapleft 20, h 74!");
      samplers[0].add(samplers[i].sequencer, "gapleft 147, wrap");
      samplers[0].add(samplers[i].voluLabel, "split 5, gapleft 227");
      samplers[0].add(samplers[i].pitchLabel, "gapleft 31");
      samplers[0].add(samplers[i].lowLabel, "gapleft 26");
      samplers[0].add(samplers[i].highLabel, "gapleft 22, wrap");
      samplers[0].add(new JButton(""), " w 1000!, h 1!, wrap");
    }
  
    //Put addchannel button button under last channel
    samplers[0].add(playSeq,"split 3");
    samplers[0].add(Sampler.addChannel);
    samplers[0].add(reset, "wrap");
    samplers[0].revalidate();
    //add samplers to pane(window)
    pane.add(samplers[0], BorderLayout.CENTER);
  }
  
  static void buildSynthesizer(Container pane){
   //if buildSYNTH is called from Actions class then creat new channel
    if(numPanels>1){
      int i = numPanels-1;
      synthesizers[i]  = new Synthesizer();
      synthesizers[i].play.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].synthType.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].newSin.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].newNoise.addActionListener(new SynthActions(synthesizers,pane,i));
      synthesizers[i].volumeSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'v'));
      synthesizers[i].pitchSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'p'));
      synthesizers[i].lowCutoffSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'l'));
      synthesizers[i].highCutoffSlider.addChangeListener(new SynthListener(synthesizers, pane, i,'h'));
      for(int j=0;j<16;j++){
        synthesizers[i].sequencer.buttons[j].addActionListener(new SeqActions(synthesizers[i].sequencer,pane,j));
      }
      samplers[0].add(synthesizers[i].samplerLabel, "wrap");
      samplers[0].add(synthesizers[i].play, "split 10");
      samplers[0].add(synthesizers[i].synthType, "w 104!");
      samplers[0].add(synthesizers[i].volumeSlider, "gapleft 52, h 74!");
      samplers[0].add(synthesizers[i].pitchSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].lowCutoffSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].highCutoffSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].attackSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].sustainSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].releaseSlider, "gapleft 20, h 74!");
      samplers[0].add(synthesizers[i].sequencer, "gapleft 40, wrap");
      samplers[0].add(synthesizers[i].voluLabel, "split 7, gapleft 227");
      samplers[0].add(synthesizers[i].pitchLabel, "gapleft 31");
      samplers[0].add(synthesizers[i].lowLabel, "gapleft 24");
      samplers[0].add(synthesizers[i].highLabel, "gapleft 22");
      samplers[0].add(synthesizers[i].attLabel, "gapleft 22");
      samplers[0].add(synthesizers[i].susLabel, "gapleft 28");
      samplers[0].add(synthesizers[i].relLabel, "gapleft 30, wrap");
      samplers[0].add(new JButton(""), " w 1000!, h 1!, wrap");
    }
    
    //Put addchannel button button under last channel
    samplers[0].add(playSeq,"split 3");
    samplers[0].add(Sampler.addChannel);
    samplers[0].add(reset, "wrap");
    samplers[0].revalidate();
    
    //add samplers to pane(window)
    pane.add(samplers[0], BorderLayout.CENTER);
    
  }
//END
}