package DarkChess;

import Framework.AbstractChess;
import Framework.AbstractChessFactory;

public class DarkChessFactory implements AbstractChessFactory {

    @Override
    public AbstractChess createGeneral(int x, int y,  boolean Group) {
        // TODO Auto-generated method stub
        return new DarkGeneralChess(x, y , 7, Group, new DarkGeneralMove(), new DarkGeneralEat());
    }

    @Override
    public AbstractChess createGuard(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkGuardChess(x, y, 6, Group, new DarkGuardMove(), new DarkGuardEat());
    }

    @Override
    public AbstractChess createElephant(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkElephantChess(x, y, 5, Group, new DarkElephantMove(), new DarkElephantEat());
    }

    @Override
    public AbstractChess createChariot(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkChariotChess(x, y, 4, Group, new DarkChariotMove(), new DarkChariotEat());
    }

    @Override
    public AbstractChess createHorse(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkHorseChess(x, y, 3, Group, new DarkHorseMove(), new DarkHorseEat());
    }

    @Override
    public AbstractChess createCannon(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkCannonChess(x, y, 2, Group, new DarkCannonMove(), new DarkCannonEat());
    }

    @Override
    public AbstractChess createSoldier(int x, int y, boolean Group) {
        // TODO Auto-generated method stub
        return new DarkSoldierChess(x, y, 1, Group, new DarkSoldierMove(), new DarkSoldierEat());
    }

}
