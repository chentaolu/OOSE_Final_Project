package Framework;
import java.util.*;

/**
 * 
 */
public class Rules {

    /**
     * 
     */
    public boolean chessMovement(AbstractChess chess, int XDisplacement, int YDisplacement) {
        return false;
    };

    /**
     * 
     */
    public boolean eatChessRules(AbstractChess initiative, List<AbstractChess> passive, int XDisplacement, int YDisplacement) {
        return false;
        
    };
    
    
    public boolean endRule() {
        return false;
    }

}