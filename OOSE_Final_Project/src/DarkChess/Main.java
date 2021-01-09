package DarkChess;

import javax.swing.*;

public class Main {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        DarkBoard darkBoard = new DarkBoard();
        
        ImageIcon board = new ImageIcon(darkBoard.getBoardPath());
        JLabel label1=new JLabel(board);
        //設定label的位置、大小，label大小為圖片的大小
        label1.setBounds(0,0,board.getIconWidth(),board.getIconHeight());
        JFrame frame=new JFrame();
        //在frame的底層容器新增label
        frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));

        //panelTop，頂層容器
        JPanel panelTop=new JPanel();
        panelTop=(JPanel)frame.getContentPane();

        panelTop.setOpaque(false);
        
        frame.setSize(darkBoard.getWidth(), darkBoard.getLength());
        frame.setVisible(true);
    
    }

}
