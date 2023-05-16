import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block {
    // instance variables
    private int width, height;
    private int xPos, yPos;
    private Color color;
    private int pointValue;
    private Breakout breakout;

    // constructor
    public Block(Breakout out,int x, int y, Color c, int pv) {
        width = 50;
        height = 30;
        xPos = x;
        yPos = y;
        color = c;
        pointValue = pv;
        breakout = out;
    }

    // methods
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }
    
    public boolean collision() {
        return this.getBounds().intersects(breakout.getBall().getBounds());
        // is the paddle being intersected with the ball
    }
}
