# Breakout Day 5

## Breakout.java
```java
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
        // private Block block, block2;

        private ArrayList<Block> blocks;

        // constructor
        public Breakout(int w, int h) {
            width = w;
            height = h;

            setSize(width, height);
            setLocation(50, 50);
            setBackground(Color.darkGray);
            setBorder(BorderFactory.createLineBorder(Color.black, 3));

            ball = new Ball(this, 55, Color.blue); // this is like self in python
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

            setFocusable(true); // when the pgroams runs, puts the cursor in on the JPanel
        }

        // methods
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            ball.paint(g);
            paddle.paint(g);

            for (int x = 0; x < blocks.size(); x++) {
                blocks.get(x).paint(g);
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
                for (int col = 0; col < 13; col++) {
                    int red = (int)(Math.random()  * 226);
                    int green = (int)(Math.random()  * 226);
                    int blue = (int)(Math.random()  * 226);
                    blocks.add(new Block(xOffset, yOffset, new Color(red, green, blue), 10));
                    xOffset += 53;
                }
                yOffset += 33;
                xOffset = 3;
            }
        }
    }

```

```java
    private ArrayList<Block> blocks;
```
Ths line will a create a instance variable list of block, we first use the class ArrayList to create the list and then we use arrow brackets the specify the type items in the list and finally we the name the variable


```java
        public void makeGrid() {
            int xOffset = 3;
            int yOffset = 3;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 13; col++) {
                    int red = (int)(Math.random()  * 226);
                    int green = (int)(Math.random()  * 226);
                    int blue = (int)(Math.random()  * 226);
                    blocks.add(new Block(xOffset, yOffset, new Color(red, green, blue), 10));
                    xOffset += 53;
                }
                yOffset += 33;
                xOffset = 3;
            }
        }
```
This a method made to crete a grid of block. it consists of two loops one of the loops in used to create the rows and another is used to create the columns. Each time the row loop is run the column loop runs 10 times in total the column loop runs for 50 times. We used Math.Random() to generate a random number and multiply it by 256 so it has a max value of 255. When the block is added to the grid the color is changed from the RGB values.

```java
    for (int x = 0; x < blocks.size(); x++) {
        blocks.get(x).paint(g);
    }
```
This is a for loop that runs for the block list size and the method used the get the blocks size is blocks.size() which returns the length of the list