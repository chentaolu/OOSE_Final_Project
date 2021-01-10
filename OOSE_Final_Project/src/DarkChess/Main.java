package DarkChess;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Framework.AbstractChess;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JButton btn[][];
        btn = new JButton[8][4];

        DarkBoard darkBoard = new DarkBoard();
        
        ImageIcon board = new ImageIcon(darkBoard.getBoardPath());
        JLabel label1=new JLabel(board);

        for(int i = 0; i < 32; i++){
            int x = darkBoard.getChesses().get(i).getX()-1;
            int y = darkBoard.getChesses().get(i).getY()-1;
            btn[x][y] = new JButton();
            btn[x][y].setIcon(new ImageIcon("..\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\a.png"));
        }
        
        

        label1.setBounds(0,0,board.getIconWidth(),board.getIconHeight());
        JFrame frame=new JFrame();

        frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));


        JPanel panelTop=new JPanel();
        panelTop=(JPanel)frame.getContentPane();

        panelTop.setOpaque(false);
        
        frame.setSize(darkBoard.getWidth(), darkBoard.getLength());
        frame.setVisible(true);
    
    }

}
