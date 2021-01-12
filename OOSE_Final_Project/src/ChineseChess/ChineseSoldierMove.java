package ChineseChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;

public class ChineseSoldierMove implements MoveStrategy {

  @Override
  public boolean CanMove(AbstractChess chess, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) == 1) {
      if (chess.isGroup() == true && chess.getX() < 5) {
        if (YDisplacement != 0 || XDisplacement > 0) {
          return false;
        } else {
          return true;
        }
      } else if (chess.isGroup() == false && chess.getX() >= 5) {
        if (YDisplacement != 0 || XDisplacement < 0) {
          return false;
        } else {
          return true;
        }
      } else {
        return true;
      }
    } else {
      return false;
    }
    
  }

}
