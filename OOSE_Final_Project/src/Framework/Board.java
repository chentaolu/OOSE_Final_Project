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