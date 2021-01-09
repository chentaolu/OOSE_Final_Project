package Framework;
import java.util.*;

/**
 * 
 */
public abstract class AbstractChess {

    /**
     * Default constructor
     */
    public AbstractChess() {
    }

    /**
     * 
     */
    private int x;

    /**
     * 
     */
    private int y;

    /**
     * 
     */
    private int priority;

    /**
     * 
     */
    private boolean Group;


    /**
     * 
     */
    public abstract void move();

}