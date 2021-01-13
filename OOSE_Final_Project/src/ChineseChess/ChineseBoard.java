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
  private String BoardPath = "..\\OOSE_Final_Project\\src\\image\\ChineseBoard.png";
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
  
  public boolean checkIsEmpty(int x, int y) {
    for (int i = 0; i < chesses.size(); i++) {
      if (chesses.get(i).getX() == x && chesses.get(i).getY() == y) {
        return false;
      }
    }
    return true;
  }
  
  public boolean selectToEmpty(int x, int y) {
    if (getChessByLocation(x, y) == null) {
      return true;
    } else {
      return false;
    }
  }
  
  public List<AbstractChess> getChessList(AbstractChess initiative, AbstractChess passive) {
    List<AbstractChess> aboveChesses = new ArrayList<AbstractChess>();
    int startY;
    int endY;
    int startX;
    int endX;
    if (initiative.getX() == passive.getX()) {
        startY = initiative.getY();
        endY = passive.getY();
        if (startY > endY) {
            for (int turn = startY - 1 ; turn >= endY; turn--) {
                System.out.println(turn);
                if (this.selectToEmpty(initiative.getX(), turn)) {
                    continue;
                } else {
                    aboveChesses.add(getChessByLocation(initiative.getX(), turn));
                }
            }        
        } else if(startY < endY) {
            for (int turn = startY + 1 ; turn <= endY; turn++) {
                if (this.selectToEmpty(initiative.getX(), turn)) {
                    continue;
                } else {
                    aboveChesses.add(getChessByLocation(initiative.getX(), turn));
                }
            }
        }
    } else if (initiative.getY() == passive.getY()) {
        startX = initiative.getX();
        endX = passive.getX();
        if(startX > endX) {
            for (int turn = startX - 1 ; turn >= endX; turn--) {
                if (this.selectToEmpty(turn, initiative.getY())) {
                    continue;
                } else {
                   aboveChesses.add(getChessByLocation(turn, initiative.getY())); 
                }
                
            }
        } else if (startX < endX) {
            for (int turn = startX + 1 ; turn <= endX; turn++) {
                if (this.selectToEmpty(turn, initiative.getY())) {
                    continue;
                } else {
                   aboveChesses.add(getChessByLocation(turn, initiative.getY())); 
                }
            }
        }
    }
    return aboveChesses; 
}
  
  public String moveOrEat(int x1, int y1, int x2, int y2) {
    AbstractChess initiative = this.getChessByLocation(x1, y1);
    if (this.selectToEmpty(x2, y2)) {
      if (this.chineseRules.chessMovement(initiative, x1 - x2, y1 - y2)
          && this.chineseRules.specialRules(chesses, initiative, x2, y2)) {
        initiative.move(initiative, x2 - x1, y2 - y1);
        return "Success";
      } else {
        return "WrongMove";
      }
    } else {
      AbstractChess passive = this.getChessByLocation(x2, y2);
      if (passive.isGroup() == initiative.isGroup()) {
        return "SameGroup";
      }
      if (this.chineseRules.eatChessRules(initiative, getChessList(initiative, passive), x1 - x2, y1 - y2)
          && this.chineseRules.specialRules(chesses, initiative, x2, y2)) {
        initiative.eat(initiative, passive, x1 - x2, y1 - y2);
        return "Success";
      } else {
        return "WrongEat";
      }
    }
  }
  
  public String getGameStatus() {
    return chineseRules.endRule(this.getChesses());
  }
  
  public String getBoardPath() {
    return this.BoardPath;
  }
  
}