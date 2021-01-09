package DarkChess;

import Framework.MoveStrategy;
import Framework.AbstractChess;


public class DarkGuardMove implements MoveStrategy {

    @Override
    public boolean move(AbstractChess chess, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        
        if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) > 1) {
            return false;
        } else {
            chess.setX(chess.getX() + XDisplacement);
            chess.setY(chess.getY() + YDisplacement);
            return true;
        }
    }

}
