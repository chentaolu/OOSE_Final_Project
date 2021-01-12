package ChineseChess;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class End extends JFrame implements ActionListener{
  
  private JLabel showLabel = new JLabel();
  private JButton ok = new JButton("ok");
  
  public End(String show) {
    this.setLayout(null);
    // Setting the width and height of frame
    this.setSize(350, 180);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setTitle("遊戲結束");
    showLabel.setText(show);
    
    ok.addActionListener(this);
    
    add(showLabel);
    add(ok);
    
    showLabel.setBounds(120, 40, 160, 25);
    ok.setBounds(130,80,80,25);
    
    this.setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand() == "ok") {
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      System.exit(0);
    }
  }

}