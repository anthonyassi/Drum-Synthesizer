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

class Sequencer extends JPanel{
  int[] sequence = new int[16];
  
  public Sequencer(){
    setLayout( new GridLayout( 2, 8 ) );
  }
  
  public void add(){
    for( int i = 0; i < 16; i++ ){
      add( new JButton( "" + ( i + 1 ) ) );
      sequence[i] = 0;
    } 
  }
}