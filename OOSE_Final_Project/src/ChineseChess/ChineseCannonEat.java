package ChineseChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.EatStrategy;

public class ChineseCannonEat implements EatStrategy {

  @Override
  public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    int count = passive.size();
    if(count < 2 || count > 2) {
      return false;
    }
    if(XDisplacement != 0 && YDisplacement != 0) {
      return false;
    }
    return true;
  }

}
