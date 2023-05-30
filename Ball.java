import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {
    // instance variables
    private int diameter;
    private int xPos;
    private int yPos;
    private Color color;
    private int xVelocity, yVelocity;

    private Breakout breakout;
    private Window window;

    // constructor
    public Ball(Breakout out, Window win,  int d, Color c) {
        window = win;
        breakout = out; // this allows for communication/access to the Breakout object
        diameter = d;
        color = c;
        xPos = 0;
        yPos = 0;
        xVelocity = 15;
        yVelocity = -15;
    }
    // methods
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos, yPos, diameter, diameter);
    }

    public void move(){
        if (xPos + xVelocity > breakout.getWidth() - diameter) {
            xVelocity = -15;
        }
        if (xPos - xVelocity < 0) {
            xVelocity = 15;
        }
        if (yPos > breakout.getHeight() - diameter) {
            yVelocity = 0;
            xVelocity = 0;
            window.setEndScreen(false);
        }
        if (yPos < 0) {
            yVelocity = 15;
        }
        xPos += xVelocity;
        yPos += yVelocity;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, diameter, diameter);
    }

    // setter method (mutator method(AP))
    public void setYVelocity(int yVel) {
        yVelocity = yVel;
    }
}
