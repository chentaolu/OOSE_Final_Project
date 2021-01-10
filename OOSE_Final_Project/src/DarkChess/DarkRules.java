package DarkChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.Rules;

public class DarkRules extends Rules {

    @Override
    public boolean chessMovement(AbstractChess chess, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        return chess.getMoveStrategy().CanMove(chess, XDisplacement, YDisplacement);
    }

    @Override
    public boolean eatChessRules(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        return initiative.getEatStrategy().CanEat(initiative, passive, XDisplacement, YDisplacement);
    }

    public boolean hasOpen(AbstractChess chess) {
        if (chess.status == false) {
            return false;
        } else {
            return true;
        }
    }
    
    public String endRule(List<AbstractChess> chesses) {
        int blackDieChess = 0;
        int redDieChess = 0;
        
        for(AbstractChess chess : chesses) {
            if (chess.isGroup() == true && chess.getX() == -1 && chess.getY() == -1) {
                blackDieChess = blackDieChess + 1;
            }
            if (chess.isGroup() == false && chess.getX() == -1 && chess.getY() == -1) {
                redDieChess = redDieChess + 1;
            }
        }
        
        if (blackDieChess == 16) {
            return "red win";
        } else if (redDieChess == 16) {
            return "black win";
        } else {
            return "continue";
        }
        
    }
    
}
