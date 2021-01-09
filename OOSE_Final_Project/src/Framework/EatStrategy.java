package Framework;

public interface EatStrategy {
    
    public boolean CanEat(AbstractChess initiative, AbstractChess passive, int XDisplacement, int YDisplacement);

}
