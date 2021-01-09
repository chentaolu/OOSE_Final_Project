package Framework;

import java.util.List;

public interface EatStrategy {
    
    public boolean CanEat(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement);

}
