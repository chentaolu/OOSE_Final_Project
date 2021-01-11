package ChineseChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.EatStrategy;

public class ChineseElephantEat implements EatStrategy {

  @Override
  public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
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
