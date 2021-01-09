package Framework;
import java.util.*;

/**
 * 
 */
public class Board {
  
    /**
     * 寬
     */
    private int width;
  
    /**
     * 長
     */
    private int length;
  
    /**
     * row * column棋盤
     */
    private int row;
    private int column;
    
    /**
     * Default constructor
     */
    public Board(int width, int lengh, int row, int column) {
      this.setWidth(width);
      this.setLength(lengh);
      this.setRow(row);
      this.setColumn(column);
    }

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public int getLength() {
      return length;
    }

    public void setLength(int length) {
      this.length = length;
    }

    public int getRow() {
      return row;
    }

    public void setRow(int row) {
      this.row = row;
    }

    public int getColumn() {
      return column;
    }

    public void setColumn(int column) {
      this.column = column;
    }

}
/*import java.util.Set;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
class CChess {
	CChess() {
	    JFrame f = new JFrame("Chinese Chess");
	    f.setSize(800, 800);
	    f.setLocation(50, 50);
	    CChessPanel cchessPanel = new CChessPanel();
	    f.add(cchessPanel);
	    f.setVisible(true);
	  }
	
public static void main(String[] args) {
    CChessBoard brd = new CChessBoard();
    System.out.println(brd);
    new CChess();
  }
}
class CChessPanel extends JPanel {
	int orgX = 83, orgY = 83, side = 67;
	  @Override
	  public void paintComponent(Graphics g) {
	    drawGrid(g);
	  }
	  private void drawGrid(Graphics g) {    
	    for (int i = 0; i < CChessBoard.cols; i++) {
	      g.drawLine(orgX + i * side, orgY,
	                 orgX + i * side, orgY + 4 * side);
	      g.drawLine(orgX + i * side, orgY + 5 * side,
	                 orgX + i * side, orgY + 9 * side);
	    }
	    for (int i = 0; i < CChessBoard.rows; i++) {
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
	      g.drawRect(orgX - margin, orgY - margin, (CChessBoard.cols - 1)* side + 2 * margin, (CChessBoard.rows - 1)* side + 2 * margin);
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
	}


	class CChessBoard {
	  final static int rows = 10;
	  final static int cols = 9;
	  @Override
	  public String toString() {
	    String brdStr = "";
	    brdStr += " ";
	    for (int i = 0; i < cols; i++) {
	      brdStr += " " + i;
	    }
	    brdStr += "\n";
	    for (int row = 0; row < rows; row++) {
	      brdStr += row + "";
	      for (int col = 0; col < cols; col++) {
	        brdStr += " .";
	      }
	      brdStr += "\n";
	    }
	    return brdStr;
	  }
	}*/