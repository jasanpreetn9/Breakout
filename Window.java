import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
    // instance variables (declared)
    JLabel label;
    JLabel winLose;
    int pointsCount;
    boolean loop = true;
    Breakout out;
    // constructor(s) - where the instance variables are initialized
    public Window() {
        // this is called once when the object is made, it will initialize any instance
        // variables or build the visible object with the use of methods rom other class

        setSize(635, 600);
        setTitle("Breakout - Nagra");
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        out = new Breakout(this, 535, 500);
        add(out);

        label = new JLabel("Score: 0");
        add(label);
        label.setBounds(50, 25, 100, 30);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.red);
        
        winLose = new JLabel();
        add(winLose);
        winLose.setBounds(50, 50, 400, 30);
        winLose.setFont(new Font("Serif", Font.PLAIN, 20));
        winLose.setForeground(Color.red);


        setVisible(true); // this should be the last line of code so that everything above it is loaded
                          // before it set to visible

        // game loop

        while (loop) {
            out.repaint();
            out.move();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setEndScreen(true);

    }

    // methods
    public void setScore(int points) {
        System.out.println(points);
        label.setText("Score: " + points);
        pointsCount = points;
        
        if (points == 500) {
            loop = false;
        }
    }
    public void setEndScreen(Boolean win) {
        
        remove(out);
       repaint();
        System.out.println("end");
        label.setVisible(false);
        
        if (win) {
            winLose.setText("You won with a score of " + pointsCount);
        }
        else {
            winLose.setText("You lost with a score of " + pointsCount);  
        }
        repaint();
        try {
            Thread.sleep(3000);
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);

    }

}
