import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

class Interface{
  
  static Channel[] channels = new Channel[8];
  static int numChannels = 0;
  static JFrame frame = new JFrame( "Drum Synthesizer" );
  static Container pane = frame.getContentPane();
  static JPanel insidePanel = new JPanel();
  static JPanel buttonPanel = new JPanel();
  static JButton addChannel = new JButton( "Add Channel" );;
  static JButton playSeq = new JButton( "Play" );
  static JPopupMenu channelMenu = new JPopupMenu();
  static JMenuItem newSamp = new JMenuItem( "Sampler" );
  static JMenuItem newSynth = new JMenuItem( "Synthesizer" ); 
  static InterfaceActions interfaceActions;
  static Border border;
  
  public static void main( String[] args ){
    pane.setLayout( new BorderLayout() );
    border = BorderFactory.createEtchedBorder();
    insidePanel.setLayout( new GridLayout( 8, 1 ) );
    insidePanel.setBorder( border );
    insidePanel.setBackground( Color.darkGray );
    buttonPanel.setLayout( new FlowLayout( FlowLayout.LEADING, 20, 10 ) );
    buttonPanel.setBorder( border );
    buttonPanel.setBackground( Color.gray );
    pane.add( insidePanel, BorderLayout.CENTER );
    pane.add( buttonPanel, BorderLayout.NORTH );
    frame.addWindowListener( new Exiter() );
    frame.setSize( 1280, 724 );
    frame.setVisible( true );
    frame.revalidate();
    frame.repaint();
    addButtons();
  }
  
  private static void addButtons(){
    interfaceActions = new InterfaceActions();
    playSeq.setPreferredSize( new Dimension( 150, 20 ) );
    addChannel.setPreferredSize( new Dimension( 150, 20 ) );
    buttonPanel.add( playSeq );
    buttonPanel.add( addChannel );
    addChannel.addActionListener( interfaceActions );
    playSeq.addActionListener( interfaceActions );
    newSamp.addActionListener( interfaceActions );
    newSynth.addActionListener( interfaceActions );
    channelMenu.add( Interface.newSamp );
    channelMenu.add( Interface.newSynth );
    addChannel.addMouseListener( 
      new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          channelMenu.show( e.getComponent(), e.getX(), e.getY() );
        }
      }
    );
  }
  
  public static void addSampler(){
    if( numChannels == 8 ) return;
    Sampler newSampler = new Sampler();
    channels[numChannels] = newSampler;
    numChannels++;
    drawPanels( newSampler.panel );
    newSampler.panel.setBackground( Color.lightGray );
  }
  
  public static void addSynthesizer(){
    if( numChannels == 8 ) return;
    DrumSynth newSynth = new DrumSynth();
    channels[numChannels] = newSynth;
    numChannels++;
    drawPanels( newSynth.panel );
    newSynth.panel.setBackground( Color.gray );
  }

  private static void drawPanels( JPanel panel ){    
    insidePanel.add( panel );
    insidePanel.revalidate();
    insidePanel.repaint();
  }

}