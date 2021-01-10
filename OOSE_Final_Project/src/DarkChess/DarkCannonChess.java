package DarkChess;

import Framework.AbstractCannon;
import Framework.AbstractChess;
import Framework.EatStrategy;
import Framework.MoveStrategy;

public class DarkCannonChess extends AbstractCannon {

    private MoveStrategy moveStrategy;
    private EatStrategy eatStrategy;
    private String chessPath = "..\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\";
    private String redChessPath = "27.png";
    private String blackChessPath = "10.png";
    
    public DarkCannonChess(int x, int y, int priority, boolean Group, MoveStrategy moveStrategy, EatStrategy eatStrategy) {
        super(x, y, priority, Group, false);
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
        chess.setX(chess.getX() + XDisplacement);
        chess.setY(chess.getY() + YDisplacement);
    }

    @Override
    public void eat(AbstractChess initiative, AbstractChess passive, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
    
        initiative.setX(passive.getX());
        initiative.setY(passive.getY());
        passive.setX(-1);
        passive.setY(-1);
    }
    
    public String getChessPNGPath() {
        if (super.isGroup()) {
            return this.chessPath + this.blackChessPath;
        } else {
            return this.chessPath + this.redChessPath;
        }
    }

}
