import java.util.*;
import java.awt.*;
import javax.swing.*;

public class BouncingBallWindow extends JFrame {
    public BouncingBallWindow(){
        setTitle("Bouncing Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new BouncingBall());
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
            BouncingBallWindow bbw = new BouncingBallWindow();
            bbw.setVisible(true);
            }
        });
    }
      
}