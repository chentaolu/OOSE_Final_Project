package ChineseChess;

import Framework.AbstractChess;
import Framework.AbstractElephant;
import Framework.EatStrategy;
import Framework.MoveStrategy;

public class ChineseElephantChess extends AbstractElephant {
  
  private MoveStrategy moveStrategy;
  private EatStrategy eatStrategy;
  private String chessPath = "../OOSE_Final_Project/src/image/";
  private String redChessPath = "20.png";
  private String blackChessPath = "4.png";

  public ChineseElephantChess(int x, int y, int priority, boolean Group, boolean status, MoveStrategy moveStrategy, EatStrategy eatStrategy) {
    super(x, y, priority, Group, status);
    // TODO Auto-generated constructor stub
    setMoveStrategy(moveStrategy);
    setEatStrategy(eatStrategy);
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
    return this.moveStrategy;
  }

  @Override
  public void setMoveStrategy(MoveStrategy moveStrategy) {
    // TODO Auto-generated method stub
    this.moveStrategy = moveStrategy;
  }

  @Override
  public EatStrategy getEatStrategy() {
    // TODO Auto-generated method stub
    return this.eatStrategy;
  }

  @Override
  public void setEatStrategy(EatStrategy eatStrategy) {
    // TODO Auto-generated method stub
    this.eatStrategy = eatStrategy;
  }
  
  public String getChessPNGPath() {
    if (super.isGroup()) {
        return this.chessPath + this.blackChessPath;
    } else {
        return this.chessPath + this.redChessPath;
    }
  }

}
