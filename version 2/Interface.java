import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

class Interface{
  static int numChannels = 1;
  public static void main(String[] args) {
  JFrame frame = new JFrame("Drum Synthesizer");
  Container pane = frame.getContentPane();
  
  buildGUI(pane);
  
  frame.addWindowListener(new Exiter());
  frame.pack();
  frame.setVisible(true);
  }
  
  
  static void buildGUI(Container pane){
    MyPanel p = new MyPanel("chanel1");
   //p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    
    MyPanel p2 = new MyPanel("chanel2");
    p.add(p2);
    pane.add(p);
    
  }
  
  
}