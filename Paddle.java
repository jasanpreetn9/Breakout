import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
    // instance variables
    private int width, height;
    private int xPos, yPos;
    private Color color;
    private int xVelocity;
    private Breakout breakout;

    // constructor
    public Paddle(Breakout out) {
        breakout = out; // this allows for communication/access to the Breakout object

        width = 100;
        height = 20;
        xPos = 200;
        yPos = 450;
        color = Color.RED;
        xVelocity = 0;
    }

    // methods
    public void keyPressed(KeyEvent e) { // explain
        if (e.getKeyCode() == 37) {
            xVelocity = -10;
        }
        if (e.getKeyCode() == 39) {
            xVelocity = 10;
        }
    }

    public void keyReleased(KeyEvent e) { // explain
        xVelocity = 0;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }

    public void move() {
        if (xPos + xVelocity > 0 && xPos + xVelocity < breakout.getWidth() - width) {
            xPos += xVelocity;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }

    public boolean collision() {
        return this.getBounds().intersects(breakout.getBall().getBounds());
        // is the paddle being intersected with the ball
    }
}
