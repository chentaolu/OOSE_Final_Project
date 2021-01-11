package ChineseChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;

public class ChineseElephantMove implements MoveStrategy {

  @Override
  public boolean CanMove(AbstractChess chess, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    if(XDisplacement != 0 && YDisplacement != 0) {
      if(Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) == Math.sqrt(8)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
    
  }

}
