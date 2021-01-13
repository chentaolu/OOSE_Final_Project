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

  public String endRule(List<AbstractChess> chesses) {
    // TODO Auto-generated method stub
    List<AbstractChess> checkGeneral = new ArrayList<AbstractChess>();
    for (AbstractChess chess: chesses) {
      if (chess instanceof ChineseGeneralChess) {
        if (chess.getX() == -1 && chess.getY() == -1) {
          if (chess.isGroup() == true) {
            return new String("Red is winner!");
          } else {
            return new String("Black is winner!");
          }
        }
        checkGeneral.add(chess);
      }
    }
    if(checkGeneral.get(0).getY() == checkGeneral.get(1).getY()) {
      for (AbstractChess chess: chesses) {
        if(chess instanceof ChineseGeneralChess) {
          continue;
        } else {
          if(chess.getY() == checkGeneral.get(0).getY()) {
            if(chess.getX() > checkGeneral.get(0).getX() && chess.getX() < checkGeneral.get(1).getX())
              return new String("Continue");
          }
        }
      }
      return new String("KingsConflict");
    }
    return new String("Continue");
  }
  
  public boolean specialRules(List<AbstractChess> chesses, AbstractChess chess, int x, int y) {
    int[] chessLoc = { chess.getX(), chess.getY() };
    int XDisplacement = x - chessLoc[0];
    int YDisplacement = y - chessLoc[1];
    if (chess instanceof ChineseHorseChess) {
      if (Math.abs(XDisplacement) > Math.abs(YDisplacement)) {
        int checkLocX = chessLoc[0] + (XDisplacement/Math.abs(XDisplacement));
        int checkLocY = chessLoc[1];
        for (AbstractChess item: chesses) {
          if (item.getX() == checkLocX && item.getY() == checkLocY) {
            return false;
          }
        }
        return true;
      } else {
        int checkLocX = chessLoc[0];
        int checkLocY = chessLoc[1] + (YDisplacement/Math.abs(YDisplacement));
        for (AbstractChess item: chesses) {
          if (item.getX() == checkLocX && item.getY() == checkLocY) {
            return false;
          }
        }
        return true;
      }
    } else if (chess instanceof ChineseElephantChess) {
      if (chess.isGroup() == true && x > 4) {
        return false;
      } else if (chess.isGroup() == false && x < 5){
        return false;
      }
      int checkLocX = chessLoc[0] + (XDisplacement/Math.abs(XDisplacement));
      int checkLocY = chessLoc[1] + (YDisplacement/Math.abs(YDisplacement));
      for (AbstractChess item: chesses) {
        if (item.getX() == checkLocX && item.getY() == checkLocY) {
          return false;
        }
      }
      return true;
    } else if (chess instanceof ChineseGuardChess) {
      if (chess.isGroup() == true) {
        if (x > 2 || y < 3 || y > 5) {
          return false;
        }
      } else {
        if (x < 7 || y < 3 || y > 5) {
          return false;
        }
      }
      return true;
    } else if (chess instanceof ChineseGeneralChess) {
      if (chess.isGroup() == true) {
        if (x > 2 || y < 3 || y > 5) {
          return false;
        }
      } else {
        if (x < 7 || y < 3 || y > 5) {
          return false;
        }
      }
      return true;
    }
    return true;
  }

}
