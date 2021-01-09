package DarkChess;

import Framework.Board;

public class DarkBoard extends Board {
    
    private String boardPath = "E:\\netWork\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\board3.png";
    
    public DarkBoard() {
        super(900, 461, 4, 8);
        // TODO Auto-generated constructor stub
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
    

}
