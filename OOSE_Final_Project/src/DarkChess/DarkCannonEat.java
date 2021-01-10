package DarkChess;

import java.util.List;

import Framework.AbstractChess;
import Framework.EatStrategy;

public class DarkCannonEat implements EatStrategy {

    @Override
    public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
        // TODO Auto-generated method stub
        int count = passive.size();
        System.out.println("count = " + count);
        if (count < 2 || count > 2) {
            return false;
        }
        if (XDisplacement != 0 && YDisplacement != 0) {
            return false;
        } else {
            return true;
        }
    }
}
