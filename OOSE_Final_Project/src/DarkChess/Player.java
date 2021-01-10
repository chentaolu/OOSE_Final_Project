package DarkChess;

import java.util.ArrayList;
import java.util.List;

import Framework.AbstractChess;

public class Player {
    private boolean color;
    public List<Integer> selectLocation = new ArrayList<Integer>();

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }
    
    public boolean selectChess(AbstractChess chess) {
        if (chess.status == color) {
            return true;
        } else {
            return false;
        }
    }
}
