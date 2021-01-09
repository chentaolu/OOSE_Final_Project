package DarkChess;

import Framework.MoveStrategy;
import Framework.AbstractChess;


public class DarkGeneralMove implements MoveStrategy {

    @Override
    public boolean CanMove(AbstractChess chess, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) == 1) {
            return true;
        } else {
            return false;
        }
    }

}
