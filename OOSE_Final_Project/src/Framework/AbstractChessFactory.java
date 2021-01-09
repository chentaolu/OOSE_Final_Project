package Framework;

/**
 * 
 */
public interface AbstractChessFactory {

    /**
     * 
     */
    public abstract AbstractChess createGeneral(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createGuard(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createElephant(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createChariot(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createHorse(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createCannon(int x, int y,  boolean Group);

    /**
     * 
     */
    public abstract AbstractChess createSoldier(int x, int y,  boolean Group);

}