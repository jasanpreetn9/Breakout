import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
    // instance variables (declared)
    JLabel label;

    // constructor(s) - where the instance variables are initialized
    public Window() {
        // this is called once when the object is made, it will initialize any instance
        // variables or build the visible object with the use of methods rom other class

        setSize(800, 600);
        setTitle("Breakout - Nagra");
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("img/icon.png");
        setIconImage(img.getImage());

        Breakout out = new Breakout(this, 692, 500);
        add(out);

        label = new JLabel("Score: 0");
        add(label);
        label.setBounds(0, 0, 100, 30);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setForeground(Color.red);

        setVisible(true); // this should be the last line of code so that everything above it is loaded
                          // before it set to visible

        // game loop

        while (true) {
            out.repaint();
            out.move();

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void changeScore(int points) {
        System.out.println(points);
        label.setText("Score: " + points);
    }

    // methods
}
