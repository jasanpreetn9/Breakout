import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Breakout extends JPanel {
    // instance variables
    private int width, height;
    private Ball ball;
    private Paddle paddle;
    private int points;
    private Window window;
    // private Block block, block2;

    private ArrayList<Block> blocks;

    // constructor
    public Breakout(Window win, int w, int h) {
        width = w;
        height = h;
        window = win;
        setSize(width, height);
        setLocation(50, 50);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));

        ball = new Ball(this, window, 70, Color.blue); // this is like self in python
        paddle = new Paddle(this);
        // block = new Block(0,0,Color.GREEN,10);
        // block2 = new Block(100,0,Color.GREEN,10);

        blocks = new ArrayList<Block>();
        makeGrid();

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { // explain

            }

            @Override
            public void keyPressed(KeyEvent e) { // explain
                paddle.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) { // explain
                paddle.keyReleased(e);
            }

        });

        setFocusable(true); // when the programs runs, puts the cursor in on the JPanel
    }

    // methods
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.paint(g);
        paddle.paint(g);
        // if ( points == 300) {
        //     window.setEndScreen(true);
        // }
        for (int x = 0; x < blocks.size(); x++) {
            blocks.get(x).paint(g);
            if (blocks.get(x).collision()) {
                points += 10;
                blocks.remove(x);
                ball.setYVelocity(2);
                x--;
                window.setScore(points);
            }
        }
        if (paddle.collision()) {
            // System.out.println("Paddle Hit");
            ball.setYVelocity(-4);
        }
    }

    public void move() {
        ball.move();
        paddle.move();
    }

    public void makeGrid() {
        int xOffset = 3;
        int yOffset = 3;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 10; col++) {
                int red = (int)(Math.random()  * 226);
                int green = (int)(Math.random()  * 226);
                int blue = (int)(Math.random()  * 226);
                blocks.add(new Block(this,xOffset, yOffset, new Color(red, green, blue), 10));
                xOffset += 53;
            }
            yOffset += 33;
            xOffset = 3;
        }

    }

    // getter methods (accessors methods (AP))
    public Ball getBall() {
        return ball;
    }
    public Paddle getPaddle() {
        return paddle;
    }
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

}
