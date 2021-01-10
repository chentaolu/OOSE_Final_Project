package DarkChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.EatStrategy;

public class DarkSoldierEat implements EatStrategy {

    @Override
    public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        int count = passive.size();
        if (count > 1) {
            return false;
        }
        if (XDisplacement != 0 && YDisplacement != 0) {
            return false;
        }
        if (initiative.getPriority() >= passive.get(passive.size() - 1).getPriority() || passive.get(passive.size() - 1).getPriority() == 7) {
            return true;
        }
        return false;
    }

}
