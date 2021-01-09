package DarkChess;

import javax.swing.*;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        DarkBoard darkBoard = new DarkBoard();
        
        ImageIcon board = new ImageIcon(darkBoard.getBoardPath());
        JLabel label1=new JLabel(board);

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
