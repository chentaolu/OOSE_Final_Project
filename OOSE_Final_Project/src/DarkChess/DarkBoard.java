package DarkChess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Framework.AbstractChess;
import Framework.Board;

public class DarkBoard extends Board {
    
    private DarkChessFactory darkChessFactory = new DarkChessFactory();
    private List<AbstractChess> chesses = new ArrayList<AbstractChess>();
    private int random[] = new int[32];
    private String boardPath = "..\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\board3.png";
    private DarkRules darkRules = new DarkRules();
    
    public DarkBoard() {
        super(900, 461, 4, 8);
        // TODO Auto-generated constructor stub
        random = Ran(32);
        int count = 0;
        boolean Group; //true -> black false -> red
   
        for (int randomNumber : random) {
            if (count < 16) {
                Group = true;
            } else {
                Group = false;
            }
            int x = randomNumber % 8 + 1;
            int y = randomNumber / 8 + 1;
            if (count == 0 || count == 16) {
                chesses.add(darkChessFactory.createGeneral(x, y, Group));
            } else if (count == 1 || count ==2 || count == 17 || count == 18) {
                chesses.add(darkChessFactory.createGuard(x, y, Group));
            } else if (count == 3 || count == 4 || count == 19 || count == 20) {
                chesses.add(darkChessFactory.createElephant(x, y, Group));
            } else if (count == 5 || count == 6 || count == 21 || count == 22) {
                chesses.add(darkChessFactory.createHorse(x, y, Group));
            } else if (count == 7 || count == 8 || count == 23 || count == 24) {
                chesses.add(darkChessFactory.createChariot(x, y, Group));
            } else if (count == 9 || count == 10 || count == 25 || count == 26) {
                chesses.add(darkChessFactory.createCannon(x, y, Group));
            } else {
                chesses.add(darkChessFactory.createSoldier(x, y, Group));
            }
            count++;
        }
    }

    public List<AbstractChess> getChesses(){
        return this.chesses;
    }
    
    public String getBoardPath() {
        return this.boardPath;
    }
    
    public int getWidth() {
        return super.getWidth();
    }
    
    public int getLength() {
        return super.getLength();
    }
    
    public static int[] Ran(int range)  
    {  
        int rdm[] = new int[range];  
        Random rand = new Random();  
        HashSet <Integer> set = new HashSet<Integer>(); 
        for(int i=0; i < range; i++) {  
            int pv = -1;  
            do  
            {
                pv = rand.nextInt(range);  
            }while(!set.add(pv));  
            rdm[i] = pv;  
        }  
        return rdm;  
    }  
    
    public AbstractChess getChessByLocation(int x, int y) {
        
        for (int count = 0; count < 32; count++) {
            if (chesses.get(count).getX() == x && chesses.get(count).getY() == y) {
                return chesses.get(count);
            }
        }
        return null;
    }
    
    public List<AbstractChess> getChessList(AbstractChess initiative, AbstractChess passive) {
        List<AbstractChess> aboveChesses = new ArrayList<AbstractChess>();
        int startY;
        int endY;
        int startX;
        int endX;
        if (initiative.getX() == passive.getX()) {
            startY = initiative.getY();
            endY = passive.getY();
            if (startY > endY) {
                for (int turn = startY - 1 ; turn >= endY; turn--) {
                    System.out.println(turn);
                    aboveChesses.add(getChessByLocation(initiative.getX(), turn));
                }        
            } else if(startY < endY) {
                for (int turn = startY + 1 ; turn <= endY; turn++) {
                    aboveChesses.add(getChessByLocation(initiative.getX(), turn));
                }
            }
        } else if (initiative.getY() == passive.getY()) {
            startX = initiative.getX();
            endX = passive.getX();
            if(startX > endX) {
                for (int turn = startX - 1 ; turn >= endX; turn--) {
                    aboveChesses.add(getChessByLocation(turn, initiative.getY()));
                }
            } else if (startX < endX) {
                for (int turn = startX + 1 ; turn <= endX; turn++) {
                    aboveChesses.add(getChessByLocation(turn, initiative.getY()));
                }
            }
        }
        return aboveChesses; 
    }
    
    public boolean selectToEmpty(int x, int y) {
        for (int count = 0; count < 32; count++) {
            if (chesses.get(count).getX() == x && chesses.get(count).getY() == y) {
                return false;
            }
        }
        return true;
    }
    /*
    public boolean chessOpen(int x, int y) {
        getChessByLocation(x, y).status;
        this.darkRules.hasOpen(chess)
    }*/
    
    public String moveOrEat(int x1, int y1, int x2, int y2) {
        AbstractChess initiative = this.getChessByLocation(x1, y1);
        if (this.selectToEmpty(x2, y2)) {
            if (this.darkRules.chessMovement(initiative, x1 - x2, y1 - y2)) {
                initiative.move(initiative, x2 - x1, y2 - y1);
                return "Success";
            } else {
                return "WrongMove";
            }
        } else {
            AbstractChess passive = this.getChessByLocation(x2, y2);
            if (passive.isGroup() == initiative.isGroup()) {
                return "SameGroup";
            }
            if (this.darkRules.eatChessRules(initiative, getChessList(initiative, passive), x1 - x2, y1 - y2)) {
                initiative.eat(initiative, passive, x1 - x2, y1 - y2);
                return "Success";
            } else {
                return "WrongEat";
            }
        }
    }
    
    public void setChessStatusTrue(int x, int y) {
        getChessByLocation(x, y).status = true;
    }
    
    public boolean getChessGroup(int x, int y) {
        return getChessByLocation(x, y).isGroup();
    }
    
    public boolean isChessOpen(int x, int y) {
        return getChessByLocation(x, y).status;
    }
    
    public String getChessPNGByLocation(int x, int y) {
        return getChessByLocation(x, y).getChessPNGPath();
    } 
    
    public String getEndGame( ) {
        return this.darkRules.endRule(chesses);
    }
    
}
