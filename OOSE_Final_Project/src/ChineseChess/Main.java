package ChineseChess;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    JFrame frame = new JFrame();
    
    frame.setTitle("Chinese Chess");
    frame.setSize(800, 800);
    frame.setLocation(50, 50);
    ChineseChessPanel chineseChessPanel = new ChineseChessPanel();
    frame.add(chineseChessPanel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }

}
