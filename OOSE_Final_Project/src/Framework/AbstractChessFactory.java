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
    public abstract AbstractChess createGuard();

    /**
     * 
     */
    public abstract AbstractChess createElephant();

    /**
     * 
     */
    public abstract AbstractChess createChariot();

    /**
     * 
     */
    public abstract AbstractChess createHorse();

    /**
     * 
     */
    public abstract AbstractChess createCannon();

    /**
     * 
     */
    public abstract AbstractChess createSoldier();

}