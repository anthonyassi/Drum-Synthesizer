import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

class Reset implements ActionListener{
static Interface[] interf;
  Sampler[] samplers;
  Container pane;
  int numSampler;
   static Reset doReset;
  static JButton reset = new JButton("New Project");
  
  
  Reset(Interface[] interf,Container pane,int numSampler){
    this.interf = interf;
    this.pane = pane;
    this.numSampler = numSampler;
  }
  
  public void actionPerformed(ActionEvent e){
    
    String cmd = e.getActionCommand();
        if(cmd.contains("New Project")){
          
           JFrame frame = new JFrame("Drum Synthesizer");
    Container pane = frame.getContentPane();
    pane.setLayout(new BorderLayout());
  
  //  Interface.buildGUI(pane);
    
    JPanel insidePanel = new JPanel();                 
    insidePanel.setLayout(new BorderLayout());  
    pane.add(insidePanel, BorderLayout.SOUTH);
  
    frame.addWindowListener(new Exiter());
  
    frame.setSize(1000,1075);
    frame.setVisible(true);
    frame.setResizable(false);  //prevent resizing
    
    doReset = new Reset(interf,pane,0);
       reset.addActionListener(doReset);
        }
  }
}