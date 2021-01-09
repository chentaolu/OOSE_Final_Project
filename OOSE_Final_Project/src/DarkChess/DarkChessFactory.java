package DarkChess;

import Framework.AbstractChess;
import Framework.AbstractChessFactory;

public class DarkChessFactory implements AbstractChessFactory {

    @Override
    public AbstractChess createGeneral(int x, int y,  boolean Group) {
        // TODO Auto-generated method stub
        return new DarkGeneralChess(x, y , 7, Group, new DarkGeneralMove());
    }

    @Override
    public AbstractChess createGuard(int x, int y,  boolean Group) {
        // TODO Auto-generated method stub
        return new DarkGuardChess(x, y, 6, Group, new DarkGuardMove());

    }

    @Override
    public AbstractChess createElephant() {
        // TODO Auto-generated method stub
        return new DarkElephantChess(x, y, 5, new DarkElephantMove());
    }

    @Override
    public AbstractChess createChariot() {
        // TODO Auto-generated method stub

    }

    @Override
    public AbstractChess createHorse() {
        // TODO Auto-generated method stub

    }

    @Override
    public AbstractChess createCannon() {
        // TODO Auto-generated method stub

    }

    @Override
    public AbstractChess createSoldier() {
        // TODO Auto-generated method stub

    }

}
