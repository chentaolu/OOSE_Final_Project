package Framework;

/**
 * 
 */
public abstract class AbstractChess {

    /**
     * Default constructor
     */
    public AbstractChess(int x, int y, int priority, boolean Group, boolean status) {
        this.setX(x);
        this.setY(y);
        this.setPriority(priority);
        this.setGroup(Group);
        this.status = status; 
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
    
    public boolean status;


    /**
     * 
     */
    public abstract void move(AbstractChess chess, int XDisplacement, int YDisplacement);
    
    public abstract void eat(AbstractChess initiative, AbstractChess passive, int XDisplacement, int YDisplacement);


    public int getX() {
        return x;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        this.y = y;
    }


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    public boolean isGroup() {
        return Group;
    }


    public void setGroup(boolean group) {
        Group = group;
    }
    
    public abstract MoveStrategy getMoveStrategy();
    public abstract void setMoveStrategy(MoveStrategy moveStrategy);
    public abstract EatStrategy getEatStrategy();
    public abstract void setEatStrategy(EatStrategy eatStrategy);
}