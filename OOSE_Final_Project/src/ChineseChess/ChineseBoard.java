package ChineseChess;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Framework.AbstractChess;
import Framework.Board;

public class ChineseBoard extends Board {
  
  private ChineseChessFactory chineseChessFactory = new ChineseChessFactory();
  private List<AbstractChess> chesses = new ArrayList<AbstractChess>();
  private AbstractChess[][] board = new AbstractChess[10][9];
  private ChineseRules chineseRules = new ChineseRules();
  private int[][] initial = {{ 4, 3, 5, 6, 7, 6, 5, 3, 4 },
                             { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                             { 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                             { 2, 0, 2, 0, 2, 0, 2, 0, 2 },
                             { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                             { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                             { 2, 0, 2, 0, 2, 0, 2, 0, 2 },
                             { 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                             { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                             { 4, 3, 5, 6, 7, 6, 5, 3, 4 }};

  public ChineseBoard() {
    super(800, 800, 9, 10);
    // TODO Auto-generated constructor stub
    boolean Group;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 9; j++) {
        if (i < 5) {
          Group = true;
        } else {
          Group = false;
        }
        if (initial[i][j] == 1) {
          chesses.add(chineseChessFactory.createCannon(i, j, Group));
        } else if (initial[i][j] == 2) {
          chesses.add(chineseChessFactory.createSoldier(i, j, Group));
        } else if (initial[i][j] == 3) {
          chesses.add(chineseChessFactory.createHorse(i, j, Group));
        } else if (initial[i][j] == 4) {
          chesses.add(chineseChessFactory.createChariot(i, j, Group));
        } else if (initial[i][j] == 5) {
          chesses.add(chineseChessFactory.createElephant(i, j, Group));
        } else if (initial[i][j] == 6) {
          chesses.add(chineseChessFactory.createGuard(i, j, Group));
        } else if (initial[i][j] == 7) {
          chesses.add(chineseChessFactory.createGeneral(i, j, Group));
        }
        /*switch (initial[i][j]) {
          case 1:
            chesses.add(chineseChessFactory.createCannon(i, j, Group));
            break;
          case 2:
            chesses.add(chineseChessFactory.createSoldier(i, j, Group));
            break;
          case 3:
            chesses.add(chineseChessFactory.createHorse(i, j, Group));
            break;
          case 4:
            chesses.add(chineseChessFactory.createChariot(i, j, Group));
            break;
          case 5:
            chesses.add(chineseChessFactory.createElephant(i, j, Group));
            break;
          case 6:
            chesses.add(chineseChessFactory.createGuard(i, j, Group));
            break;
          case 7:
            chesses.add(chineseChessFactory.createGeneral(i, j, Group));
            break;
          default:
            break;
        }*/
      }
    }
  }
  
  public AbstractChess getChessByLocation(int x, int y) {
    for (int i = 0; i < chesses.size(); i++) {
        if (chesses.get(i).getX() == x && chesses.get(i).getY() == y) {
            return chesses.get(i);
        }
    }
    return null;
  }
  
  public List<AbstractChess> getChesses() {
    return this.chesses;
  }
  
}
 
/*public class ChineseBoard extends JFrame {
  
    final static int rows = 10;
    final static int cols = 9;
    
    JButton[][] buttons = new JButton[9][10];
    
    public ChineseBoard() {
        
      setTitle("Chinese Chess");
      setSize(800, 800);
      setLocation(50, 50);
      CChessPanel cchessPanel = new CChessPanel();
      add(cchessPanel);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
    }
    
    public static void main(String[] args) {
      
      ChineseBoard chineseBoard = new ChineseBoard();
      
    }
    
    class CChessPanel extends JPanel implements ActionListener {
      
      int orgX = 83, orgY = 83, side = 70;
      
      public CChessPanel() {
        
        setLayout(new GridLayout(9, 10));
        for (int j = 0; j < 10; j++) {
          for (int i = 0; i < 9; i++) {
            buttons[i][j] = new JButton();
            buttons[i][j].putClientProperty("INDEX", new int[] { i, j });
            buttons[i][j].putClientProperty("GROUP", null);
            buttons[i][j].addActionListener(this);
            buttons[i][j].setFocusPainted(false);
            buttons[i][j].setContentAreaFilled(false);                
            buttons[i][j].setBorderPainted(false);
            buttons[i][j].setIcon(new ImageIcon("../OOSE_Final_Project/src/image/11.png"));
            buttons[i][j].setSize(10, 10);
            add(buttons[i][j]);
          }
        }
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
        
      }
      
    }
  
}*/