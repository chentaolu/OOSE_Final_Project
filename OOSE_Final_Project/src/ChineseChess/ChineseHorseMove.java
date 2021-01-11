package ChineseChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;

public class ChineseHorseMove implements MoveStrategy {

  @Override
  public boolean CanMove(AbstractChess chess, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) == Math.sqrt(5)) {
      return true;
    } else {
      return false;
    }
    
  }

}
