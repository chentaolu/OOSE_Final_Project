package DarkChess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import Framework.AbstractChess;

public class Main {
    static boolean firstClick = true;
    static int round = 0;

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Player p1 = new Player(); // 0
        Player p2 = new Player(); // 1
        String emptyPath = "..\\OOSE_Final_Project\\src\\image\\background.png";
        
        
        int[] xbound = {187,267,347,427,507,587,667,748};
        int[] ybound = {70,150,230,310};
        JButton btn[][];
        btn = new JButton[8][4];
        JLabel falemove = new JLabel();
        JLabel whoFirst = new JLabel();
        JLabel nowPlay = new JLabel();



        DarkBoard darkBoard = new DarkBoard();
        JFrame frame=new JFrame();
        
        ImageIcon board = new ImageIcon(darkBoard.getBoardPath());
        JLabel label1=new JLabel(board);
        JPanel panel =(JPanel) frame.getContentPane();
        panel.setOpaque(false);
        //panel.setBackground(new Color(185,122,86));
        panel.setLayout(null);

        

        for(int i = 0; i < 32; i++){
            int x = darkBoard.getChesses().get(i).getX()-1;
            int y = darkBoard.getChesses().get(i).getY()-1;
            btn[x][y] = new JButton();
            btn[x][y].setIcon(new ImageIcon("..\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\a.png")); 
            //..\\OOSE_Final_Project\\OOSE_Final_Project\\src\\image\\a.png
            btn[x][y].setBounds(xbound[x],ybound[y], 60, 60);
            btn[x][y].setBorderPainted(false);
            btn[x][y].setContentAreaFilled(false);
            btn[x][y].addActionListener(new ActionListener() {

            
                

                public void actionPerformed(ActionEvent e) {
                    String Action = null;

                    
                    if(round %2 == 1){
                        nowPlay.setText("NOW P1");
                        nowPlay.setBounds(20, 20, 200, 40);
                        panel.add(nowPlay);
                    } else if (round %2 == 0){
                        nowPlay.setText("NOW P2");
                        nowPlay.setBounds(20, 20, 200, 40);
                        panel.add(nowPlay);
                    }

                    // TODO Auto-generated method stub      
                    if (firstClick == true) {
                        p1.setColor(darkBoard.getChessGroup(x + 1, y + 1));
                        p2.setColor(!darkBoard.getChessGroup(x + 1, y + 1));
                        btn[x][y].setIcon(new ImageIcon(darkBoard.getChessPNGByLocation(x + 1, y + 1)));
                        darkBoard.setChessStatusTrue(x + 1, y + 1);
                        firstClick = false;
                        round++;
                        if(p1.isColor() == true) {
                            whoFirst.setText("P1:黑棋 P2:紅棋");
                        } else {
                            whoFirst.setText("P1:紅棋 P2:黑棋");
                        }                
                        whoFirst.setBounds(20, 60, 200, 40);
                        panel.add(whoFirst);                        
                    } else {
                        if (!darkBoard.selectToEmpty(x + 1, y + 1) && !darkBoard.isChessOpen(x + 1, y + 1)) {
                                btn[x][y].setIcon(new ImageIcon(darkBoard.getChessPNGByLocation(x + 1, y + 1)));
                                darkBoard.setChessStatusTrue(x + 1, y + 1);
                                round++;
                                falemove.setText("");
                                falemove.setBounds(20, 80, 200, 40);
                                panel.add(falemove);
                        } else if (darkBoard.selectToEmpty(x + 1, y + 1) || darkBoard.isChessOpen(x + 1, y + 1)) {
                            if (round % 2 == 0) {  //p1                                
                                if (p1.selectLocation.size() == 0) {
                                    try{
                                        if (darkBoard.getChessGroup(x + 1, y + 1) == p1.isColor()) {
                                            p1.selectLocation.add(x + 1);
                                            p1.selectLocation.add(y + 1);
                                            falemove.setText("");
                                            falemove.setBounds(20, 80, 200, 40);
                                            panel.add(falemove);
                                        } else if (darkBoard.getChessGroup(x + 1, y + 1) != p1.isColor()) {
                                            //點選的旗子顏色與玩家陣營不符
                                            falemove.setText("點選旗子陣營錯誤");
                                            falemove.setBounds(20, 80, 200, 40);
                                            panel.add(falemove);
                                            p1.selectLocation.clear();
                                        }
                                    } catch (Exception e1){
                                        falemove.setText("不要點地版");
                                        falemove.setBounds(20, 80, 200, 40);
                                        panel.add(falemove);
                                    }
                                } else if (p1.selectLocation.size() > 0) {
                                    p1.selectLocation.add(x + 1);
                                    p1.selectLocation.add(y + 1);
                                    Action = darkBoard.moveOrEat(p1.selectLocation.get(0),
                                            p1.selectLocation.get(1), p1.selectLocation.get(2), p1.selectLocation.get(3));
                                    if (Action.equals("Success")) {
                                        btn[p1.selectLocation.get(0) - 1][p1.selectLocation.get(1) - 1].setIcon(new ImageIcon(emptyPath));
                                        btn[p1.selectLocation.get(2) - 1][p1.selectLocation.get(3) - 1].setIcon(
                                                new ImageIcon(darkBoard.getChessPNGByLocation(p1.selectLocation.get(2), p1.selectLocation.get(3))));
                                        p1.selectLocation.clear();
                                        round++;
                                    } else {
                                        p1.selectLocation.clear();
                                    }
                                }
                                
                                
                            } else if (round % 2 == 1) {    //p2                                
                                if (p2.selectLocation.size() == 0) {
                                    try {
                                        if (darkBoard.getChessGroup(x + 1, y + 1) == p2.isColor()) {                                            
                                            p2.selectLocation.add(x + 1);
                                            p2.selectLocation.add(y + 1);
                                            falemove.setText("");
                                            falemove.setBounds(20, 40, 200, 40);
                                            panel.add(falemove);
                                        } else if (darkBoard.getChessGroup(x + 1, y + 1) == p2.isColor()){
                                            falemove.setText("點選旗子陣營錯誤");
                                            falemove.setBounds(20, 80, 200, 40);
                                            panel.add(falemove);
                                            p2.selectLocation.clear();
                                        }
                                    } catch (Exception e1) {
                                        falemove.setText("不要點地版");
                                        falemove.setBounds(20, 80, 200, 40);
                                        panel.add(falemove);
                                    }
                                } else if (p2.selectLocation.size() > 0) {
                                    System.out.println("in");
                                    p2.selectLocation.add(x + 1);
                                    p2.selectLocation.add(y + 1);
                                    Action = darkBoard.moveOrEat(p2.selectLocation.get(0),
                                            p2.selectLocation.get(1), p2.selectLocation.get(2), p2.selectLocation.get(3));
                                    if (Action.equals("Success")) {
                                        btn[p2.selectLocation.get(0) - 1][p2.selectLocation.get(1) - 1].setIcon(new ImageIcon(emptyPath));
                                        btn[p2.selectLocation.get(2) - 1][p2.selectLocation.get(3) - 1].setIcon(
                                                new ImageIcon(darkBoard.getChessPNGByLocation(p2.selectLocation.get(2), p2.selectLocation.get(3))));
                                        p2.selectLocation.clear();
                                        round++;
                                    } else {
                                        p2.selectLocation.clear();
                                    }
                                }
                            }
                        }
                    }
                }
                
            });
            
            panel.add(btn[x][y]);

            
        }
        
        label1.setBounds(0,0,board.getIconWidth(),board.getIconHeight());
        

        frame.getLayeredPane().add(label1,new Integer(Integer.MIN_VALUE));


        JPanel panelTop=new JPanel();
        panelTop=(JPanel)frame.getContentPane();

        panelTop.setOpaque(false);
        
        frame.setSize(darkBoard.getWidth(), darkBoard.getLength());
        frame.setVisible(true);
    
    }

}
