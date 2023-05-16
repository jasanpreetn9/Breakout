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

    // constructor
    public Ball(Breakout out, int d, Color c) {
        breakout = out; // this allows for communication/access to the Breakout object
        diameter = d;
        color = c;
        xPos = 99;
        yPos = 16;
        xVelocity = 4;
        yVelocity = 4;
    }
    // methods
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xPos, yPos, diameter, diameter);
    }

    public void move(){
        if (xPos + xVelocity > breakout.getWidth() - diameter) {
            xVelocity = -4;
        }
        if (xPos - xVelocity < 0) {
            xVelocity = 4;
        }
        if (yPos > breakout.getHeight() - diameter) {
            yVelocity = -4;
        }
        if (yPos < 0) {
            yVelocity = 4;
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
