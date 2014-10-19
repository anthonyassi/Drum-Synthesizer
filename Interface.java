import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;


class Interface{
  public static void main(String[] args) {
  JFrame frame = new JFrame("Drum Synthesizer");
  Container pane = frame.getContentPane();
  
  
  frame.addWindowListener(new Exiter());
  frame.pack();
  frame.setVisible(true);
  }
  
  
  static void buildGUI(Container pane){
    
  }
}