package ChineseChess;

import Framework.Rules;
import Framework.AbstractChess;

import java.util.*;

public class ChineseRules extends Rules {
  
  @Override
  public boolean chessMovement(AbstractChess chess, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub
    return chess.getMoveStrategy().CanMove(chess, XDisplacement, YDisplacement);
  }

  @Override
  public boolean eatChessRules(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement,
      int YDisplacement) {
    // TODO Auto-generated method stub
    return initiative.getEatStrategy().CanEat(initiative, passive, XDisplacement, YDisplacement);
  }

  @Override
  public boolean endRule() {
    // TODO Auto-generated method stub
    return super.endRule();
  }

}
