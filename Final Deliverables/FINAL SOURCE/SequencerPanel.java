import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import static java.awt.BorderLayout.*;
import javax.swing.JLabel;

import com.jsyn.*;
import com.jsyn.data.SequentialData;
import com.jsyn.unitgen.*;
import com.jsyn.util.*;
import com.jsyn.data.*;
import java.io.*;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

class SequencerPanel extends JPanel{
  
  int[] sequence = new int[16];
  JButton[] buttons = new JButton[16];
  
  public SequencerPanel(){
    setLayout( new MigLayout("wrap 8"));
    addComponents();
  }
  
  public void addComponents(){
    for( int i = 0; i < 16; i++ ){
      buttons[i] = new JButton();
      buttons[i].setBackground( Color.white );
      buttons[i].setForeground( Color.white );
      add( buttons[i] , "w 30!, h 15!" );
      sequence[i] = 0;
    } 
  }
  
  
}