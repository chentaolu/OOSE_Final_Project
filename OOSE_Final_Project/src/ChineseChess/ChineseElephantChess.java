package ChineseChess;

import Framework.AbstractChess;
import Framework.AbstractElephant;
import Framework.EatStrategy;
import Framework.MoveStrategy;

public class ChineseElephantChess extends AbstractElephant {

  public ChineseElephantChess(int x, int y, int priority, boolean Group, boolean status) {
    super(x, y, priority, Group, status);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void move(AbstractChess chess, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub

  }

  @Override
  public void eat(AbstractChess initiative, AbstractChess passive, int XDisplacement, int YDisplacement) {
    // TODO Auto-generated method stub

  }

  @Override
  public MoveStrategy getMoveStrategy() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setMoveStrategy(MoveStrategy moveStrategy) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public EatStrategy getEatStrategy() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setEatStrategy(EatStrategy eatStrategy) {
    // TODO Auto-generated method stub
    
  }

}
