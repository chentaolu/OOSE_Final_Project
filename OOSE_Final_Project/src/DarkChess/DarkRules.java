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

    @Override
    public void isSameRow() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void isSameColumn() {
        // TODO Auto-generated method stub
        
    }

}
