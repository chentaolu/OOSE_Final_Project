package ChineseChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.EatStrategy;

public class ChineseSoldierEat implements EatStrategy {

  @Override
  public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) == 1) {
      if (initiative.isGroup() == true && initiative.getX() < 5) {
        if (YDisplacement != 0 || XDisplacement > 0) {
          return false;
        } else {
          return true;
        }
      } else if (initiative.isGroup() == false && initiative.getX() >= 5) {
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
