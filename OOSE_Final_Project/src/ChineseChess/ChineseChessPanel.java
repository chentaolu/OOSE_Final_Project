package ChineseChess;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Framework.AbstractChess;

public class ChineseChessPanel extends JPanel implements ActionListener {
  
    final static int rows = 10;
    final static int cols = 9;
    static boolean select = false;
    static boolean round = false;
    AbstractChess selectChess;
    
    int orgX = 100, orgY = 50, side = 75;
    ChineseBoard cBoard = new ChineseBoard();
    JButton[][] buttons = new JButton[10][9];
    JTextField turnBar = new JTextField();
    
    public ChineseChessPanel() {
      
      setLayout(null);
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 9; j++) {
          buttons[i][j] = new JButton();
          buttons[i][j].putClientProperty("LOCATION", new int[] { i, j });
          if(cBoard.getChessByLocation(i, j) != null) {
            buttons[i][j].setIcon(new ImageIcon(cBoard.getChessByLocation(i, j).getChessPNGPath()));
          }
          buttons[i][j].setBounds(70 + 75*(j), 20 + 75*(i), 60, 60);
          buttons[i][j].addActionListener(this);
          buttons[i][j].setContentAreaFilled(false);                
          buttons[i][j].setBorderPainted(false);
          add(buttons[i][j]);
        }
      }
      turnBar = new JTextField("Red's turn");
      turnBar.setBounds(0, 750, 800, 30);
      add(turnBar);
    }
    
    @Override
    public void paintComponent(Graphics g) {
      drawGrid(g);
    }
    
    private void drawGrid(Graphics g) {    
      for (int i = 0; i < cols; i++) {
        g.drawLine(orgX + i * side, orgY,
                   orgX + i * side, orgY + 4 * side);
        g.drawLine(orgX + i * side, orgY + 5 * side,
                   orgX + i * side, orgY + 9 * side);
      }
      for (int i = 0; i < rows; i++) {
        g.drawLine(orgX,            orgY + i * side,
                   orgX + 8 * side, orgY + i * side);
      }
      for (int i = 0; i < 2; i++) {
        g.drawLine(orgX + 3 * side, orgY + i * 7 * side,
                   orgX + 5 * side, orgY + (2 + i * 7) * side);
        g.drawLine(orgX + 5 * side, orgY + i * 7 * side,
                   orgX + 3 * side, orgY + (2 + i * 7) * side);
        g.drawLine(orgX + 8 * i * side, orgY + 4 * side,
                   orgX + 8 * i * side, orgY + 5 * side);
      }
      for (int i = 0; i < 2; i++) {
          drawStarAt(g, 1 + i * 6, 2);
          drawStarAt(g, 1 + i * 6, 7);
          drawHalfStarAt(g, 0, 3, false);
          drawHalfStarAt(g, 0, 6, false);
          drawHalfStarAt(g, 8, 3, true);
          drawHalfStarAt(g, 8, 6, true);
        }
        for (int i = 0; i < 3; i++) {
          drawStarAt(g, 2 + i * 2, 3);
          drawStarAt(g, 2 + i * 2, 6);
        }
        int margin = side/15;
        g.drawRect(orgX - margin, orgY - margin, (cols - 1)* side + 2 * margin, (rows - 1)* side + 2 * margin);
    }
    
    private void drawHalfStarAt(Graphics g, int col, int row, 
                          boolean left) {
      int gap = side / 9;
      int bar = side / 4;
      int hSign = left ? -1 : 1;
      int tipX = orgX + col * side + hSign * gap;
      for (int i = 0; i < 2; i++) {
        int vSign = -1 + i * 2;
        int tipY = orgY + row * side + vSign * gap;  
        g.drawLine(tipX, tipY, tipX + hSign * bar , tipY);
        g.drawLine(tipX, tipY, tipX, tipY + vSign * bar);
      }
    }
    
    private void drawStarAt(Graphics g, int col, int row) {
      drawHalfStarAt(g, col, row, true);
      drawHalfStarAt(g, col, row, false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      JButton b = (JButton) e.getSource();
      if (select == false) {
        int[] selectLoc = (int[])b.getClientProperty("LOCATION");
        if (cBoard.getChessByLocation(selectLoc[0], selectLoc[1]) != null
            && cBoard.getChessByLocation(selectLoc[0], selectLoc[1]).isGroup() == round) {
          this.selectChess = cBoard.getChessByLocation(selectLoc[0], selectLoc[1]);
          select = true;
        }
      } else {
        int[] targetLoc = (int[])b.getClientProperty("LOCATION");
        int[] beforeMove = {this.selectChess.getX(), this.selectChess.getY()};
        String result = cBoard.moveOrEat(this.selectChess.getX(), this.selectChess.getY(), targetLoc[0], targetLoc[1]);
        System.out.printf("%d %d | %d %d", beforeMove[0], beforeMove[1], targetLoc[0], targetLoc[1]);
        System.out.println(result);
        if (result.equals("Success")) {
          buttons[beforeMove[0]][beforeMove[1]].setIcon(null);
          buttons[targetLoc[0]][targetLoc[1]].setIcon(
              new ImageIcon(this.selectChess.getChessPNGPath()));
          if (beforeMove[0] != targetLoc[0] || beforeMove[1] != targetLoc[1]) {
            if(cBoard.getGameStatus().equals("Continue")) {
              round = !round;
              if (round == true) {
                this.turnBar.setText("Black's turn");
              } else {
                this.turnBar.setText("Red's turn");
              }
            } else if(cBoard.getGameStatus().equals("KingsConflict")) {
              if (round == true) {
                End end = new End("Red is winner!");
              } else {
                End end = new End("Black is winner!");
              }
            } else {
              End end = new End(cBoard.getGameStatus());
            }
          }
        }
        select = false;
      }
    }
  
}
