package Framework;
import java.util.*;

/**
 * 
 */
public abstract class AbstractChessGroupFactory {

    /**
     * Default constructor
     */
    public AbstractChessGroupFactory() {
    }

    /**
     * 
     */
    public abstract void createGeneral();

    /**
     * 
     */
    public abstract void createGuard();

    /**
     * 
     */
    public abstract void createElephant();

    /**
     * 
     */
    public abstract void createChariot();

    /**
     * 
     */
    public abstract void createHorse();

    /**
     * 
     */
    public abstract void createCannon();

    /**
     * 
     */
    public abstract void createSoldier();

}