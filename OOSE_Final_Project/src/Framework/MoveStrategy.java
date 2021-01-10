package Framework;

/**
 * 
 */
public interface MoveStrategy {

    /**
     * 
     */
    public boolean CanMove(AbstractChess chess, int XDisplacement, int YDisplacement);
    
    /*public boolean movePiece(int fromCol, int fromRow, int toCol, int toRow) {
        Piece movingP = pieceAt(fromCol, fromRow);
        Piece targetP = pieceAt(toCol, toRow);
        pieces.remove(movingP);
        pieces.remove(targetP);
        pieces.add(new Piece(toCol, toRow, movingP.isRed, movingP.rank));
    }

    private boolean isStraight(int fromCol, int fromRow, int toCol, int toRow) {
        return fromCol == toCol || fromRow == toRow;
    }

    private int numPiecesBetween(int fromCol, int fromRow, 
                     int toCol, int toRow) {
  if (!isStraight(fromCol, fromRow, toCol, toRow) 
   || steps(fromCol, fromRow, toCol, toRow) < 2) {
    return 0;
  }
  int cnt = 0, head, tail;
  if (fromCol == toCol) { // vertical
    head = Math.min(fromRow, toRow);
    tail = Math.max(fromRow, toRow);
    for (int row = head + 1; row < tail; row++) {
      cnt += (pieceAt(fromCol, row) == null) ? 0 : 1;
    }
  } else {
    head = Math.min(fromCol, toCol);
    tail = Math.max(fromCol, toCol);
    for (int col = head + 1; col < tail; col++) {
      cnt += (pieceAt(col, fromRow) == null) ? 0 : 1;
    }
  }
  return cnt;
  
  private boolean isValidGuardMove(int fromCol, int fromRow, 
                         int toCol,   int toRow, boolean isRed) {
  if (outOfPalace(toCol, toRow, isRed)) { 
    return false; 
  }
  return isDiagonal(fromCol, fromRow, toCol, toRow) && 
         steps(fromCol, fromRow, toCol, toRow) == 1;
}

private boolean isValidGeneralMove(int fromCol, int fromRow, 
                        int toCol, int toRow, boolean isRed) {
  if (outOfPalace(toCol, toRow, isRed)) { 
    return false; 
  }
  return isStraight(fromCol, fromRow, toCol, toRow) && 
         steps(fromCol, fromRow, toCol, toRow) == 1;
}

private boolean isValidHorseMove(int fromCol, int fromRow, 
                          int toCol,   int toRow) {
  if (Math.abs(fromCol - toCol) == 1 && Math.abs(fromRow - toRow) == 2) {
    return pieceAt(fromCol, (fromRow + toRow)/2) == null;
  } else if (Math.abs(fromCol - toCol) == 2 && Math.abs(fromRow - toRow) == 1) {
    return pieceAt((fromCol + toCol)/2, fromRow) == null;
  }
  return false;
}

private boolean isValidElephantMove(int fromCol, int fromRow, 
                          int toCol,   int toRow, boolean isRed) {
  return selfSide(toRow, isRed) 
      && pieceAt((fromCol + toCol)/2, (fromRow + toRow)/2) == null
      && isDiagonal(fromCol, fromRow, toCol, toRow)
      && steps(fromCol, fromRow, toCol, toRow) == 2;
}

private boolean isValidChariotMove(int fromCol, int fromRow, 
                        int toCol,   int toRow) {
  return isStraight(fromCol, fromRow, toCol, toRow)
      && numPiecesBetween(fromCol, fromRow, toCol, toRow) == 0;
}

private boolean isValidCannonMove(int fromCol, int fromRow, 
                          int toCol,   int toRow) {
  if (pieceAt(toCol, toRow) == null) {
    return isValidRookMove(fromCol, fromRow, toCol, toRow);
  }
  return numPiecesBetween(fromCol, fromRow, toCol, toRow) == 1;
}

private boolean isValidSoldierMove(int fromCol, int fromRow, 
                        int toCol,   int toRow, boolean isRed) {
  if (steps(fromCol, fromRow, toCol, toRow) != 1) {
    return false;
  }
  return isRed && toRow > fromRow || !isRed && toRow < fromRow || !selfSide(fromRow, isRed);
}
  */

    
}