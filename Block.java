import java.awt.Color;
import java.awt.Graphics;

public class Block {
    // instance variables
    private int width, height;
    private int xPos, yPos;
    private Color color;
    private int pointValue;

    // constructor
    public Block(int x, int y, Color c, int pv) {
        width = 50;
        height = 30;
        xPos = x;
        yPos = y;
        color = c;
        pointValue = pv;
    }

    // methods
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }

}
