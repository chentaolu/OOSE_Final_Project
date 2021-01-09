package DarkChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;
import Framework.EatStrategy;


public class DarkSoldierChess extends AbstractChess {

    
    private EatStrategy eatStrategy;
    private MoveStrategy moveStrategy;
    
    public DarkSoldierChess(int x, int y, int priority, boolean Group, MoveStrategy moveStrategy, EatStrategy eatStrategy) {
        super(x, y, priority, Group);
        setMoveStrategy(moveStrategy);
        setEatStrategy(eatStrategy);
        
    }
    
    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public EatStrategy getEatStrategy() {
        return eatStrategy;
    }

    public void setEatStrategy(EatStrategy eatStrategy) {
        this.eatStrategy = eatStrategy;
    }

    @Override
    public void move(AbstractChess chess, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        if (Math.sqrt(XDisplacement * XDisplacement + YDisplacement * YDisplacement) > 1) {
            
        } else {
            chess.setX(chess.getX() + XDisplacement);
            chess.setY(chess.getY() + YDisplacement);
        }
    }

    @Override
    public void eat(AbstractChess initiative, AbstractChess passive, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        if (XDisplacement != 0 && YDisplacement != 0) {
        } else {
            initiative.setX(initiative.getX());
            initiative.setY(initiative.getY());
            passive.setX(-1);
            passive.setY(-1);
        }
    }
}
