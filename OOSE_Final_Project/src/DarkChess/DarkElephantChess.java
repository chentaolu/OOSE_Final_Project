package DarkChess;

import Framework.AbstractChess;
import Framework.MoveStrategy;

public class DarkElephantChess extends AbstractChess {

    private MoveStrategy moveStrategy;
    
    public DarkElephantChess(int x, int y, int priority, boolean Group, MoveStrategy moveStrategy) {
        super(x, y, priority, Group);
        this.moveStrategy = moveStrategy;
        
    }
    
    @Override
    public boolean move(int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        return this.moveStrategy.move(this, XDisplacement, YDisplacement);
    }

}
