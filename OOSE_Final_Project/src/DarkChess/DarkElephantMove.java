package DarkChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;

public class DarkElephantMove implements MoveStrategy {

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
