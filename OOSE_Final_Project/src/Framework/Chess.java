package Framework;
import java.util.*;

/**
 * 
 */
public abstract class Chess {

    /**
     * Default constructor
     */
    public Chess() {
    }

    /**
     * 
     */
    public int x;

    /**
     * 
     */
    public int y;

    /**
     * 
     */
    public int priority;

    /**
     * 
     */
    public boolean Group;


    /**
     * 
     */
    public abstract void move();

}