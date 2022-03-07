import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BouncingBall extends JPanel{
    private final Dimension SIZE = new Dimension(800,600);
    private final int UPDATE_RATE = 30;
    private Ball[] balls;
    private Thread ballThread;

    public BouncingBall(){
        int index = 0;
        setPreferredSize(SIZE);
        balls= new Ball[10];
        while (index<balls.length){
                balls[index]=new Ball(SIZE);
                index++;
        }
        ballThread= new Thread(){
                public void run(){
                    while (true){
                        int index = 0;
                        while (index < balls.length){
                            balls[index].move();
                            index++;
                        }
                        repaint();
                        try{
                        Thread.sleep(1000/UPDATE_RATE);
                    }   catch(InterruptedException ex){}
                }
            }
        };
        ballThread.start();
    }
    
    public void paintComponent (Graphics g ) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,getWidth(),getHeight());
        int index = 0;
        while (index < balls.length){
            balls[index].paint(g2d);
            index++;
       
        }
    }
}

       