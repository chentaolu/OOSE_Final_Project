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
    
    
    public DarkBoard() {
        super(900, 461, 4, 8);
        // TODO Auto-generated constructor stub
        random = Ran(32);
        int count = 0;
        boolean Group; //true -> black false -> red
        for (count = 0; count < 32; count++) {
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
            }
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
    
}
