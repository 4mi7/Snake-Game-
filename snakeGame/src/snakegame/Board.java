package snakegame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener{
    private int dots;
    private Timer timer;
private final int ALL_DOTS = 900;
private final int DOT_SIZE = 10;
private final int RANDOM_POSITION = 34;
private final int x[]= new int[ALL_DOTS];
private final int y[]= new int[ALL_DOTS];
private int apple_x;
private int apple_y;
private Image apple;
private Image dot;
private Image head;
    Board(){
        setBackground(Color.BLACK);
        setFocusable(true);
        LoadImages();
        initGame();
    }
public void LoadImages(){
   ImageIcon i1 = new ImageIcon(getClass().getResource("/snakegame/Icons/apple.png"));
    apple = i1.getImage();
ImageIcon i2 = new ImageIcon(getClass().getResource("/snakegame/Icons/head.png"));
head = i2.getImage();
ImageIcon i3 = new ImageIcon(getClass().getResource("/snakegame/Icons/dot.png"));
dot = i3.getImage();
}
    public void initGame(){
        dots = 3;
for(int i= 0; i<dots; i++){
    y[i]= 50;
    x[i] = 50 - i*DOT_SIZE;
}
locateApple();

timer = new Timer(140, this);
timer.start();
}
    
    public void locateApple(){
       int r = (int)(Math.random()*RANDOM_POSITION);
       apple_x = r * DOT_SIZE;
       r = (int)(Math.random()*RANDOM_POSITION); 
       apple_y = r * DOT_SIZE;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.drawImage(apple, apple_x, apple_y , this);
        for(int i = 0; i<dots; i++){
            if(i==0){
                 g.drawImage(head, x[i], y[i], this);
            }else{
              g.drawImage(dot, x[i], y[i], this);   
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }
    public void actionPerformed(ActionEvent ae){
        
    }
    }

