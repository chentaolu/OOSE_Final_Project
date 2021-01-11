package ChineseChess;

import Framework.AbstractChess;
import Framework.AbstractChessFactory;

public class ChineseChessFactory implements AbstractChessFactory {

  @Override
  public AbstractChess createGeneral(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseGeneralChess(x, y, 7, Group, new ChineseGeneralMove(), new ChineseGeneralEat());
  }

  @Override
  public AbstractChess createGuard(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseGuardChess(x, y, 6, Group, new ChineseGuardMove(), new ChineseGuardEat());
  }

  @Override
  public AbstractChess createElephant(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseElephantChess(x, y, 5, Group, new ChineseElephantMove(), new ChineseElephantEat());
  }

  @Override
  public AbstractChess createChariot(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseChariotChess(x, y, 4, Group, new ChineseChariotMove(), new ChineseChariotEat());
  }

  @Override
  public AbstractChess createHorse(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseHorseChess(x, y, 3, Group, new ChineseHorseMove(), new ChineseHorseEat());
  }

  @Override
  public AbstractChess createCannon(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseCannonChess(x, y, 1, Group, new ChineseCannonMove(), new ChineseCannonEat());
  }

  @Override
  public AbstractChess createSoldier(int x, int y, boolean Group) {
    // TODO Auto-generated method stub
    return new ChineseSoldierChess(x, y, 2, Group, new ChineseSoldierMove(), new ChineseSoldierEat());
  }

}
