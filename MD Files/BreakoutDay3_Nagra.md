# Breakout Day 3

## Ball.java
```java
    import java.awt.Color;
    import java.awt.Graphics;

    public class Ball {
        // instance variables
        private int diameter;
        private int xPos;
        private int yPos;
        private Color color;
        private int xVelocity;

        // constructor
        public Ball(int d, Color c) {
            diameter = d;
            color = c;
            xPos = 99;
            yPos = 16;
            xVelocity = 2;
        }
        // methods
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(xPos, yPos, diameter, diameter);
        }

        public void move(){
            xPos += xVelocity;
        }
    }

```

```java
    private int xPos;
    private int yPos;
```
These are instance variables the contain the x and y position of the ball.

```java
    xPos = 99;
    yPos = 16;
    xVelocity = 2;
```
This the initialization statement which sets the initial position of ball and the x velocity of the ball.

```java
    public void move(){
        xPos += xVelocity;
    }
```
This method called move moves the ball by adding the x velocity of the ball to the x position of the ball.

## Breakout.java
```java
    import java.awt.Color;
    import java.awt.Graphics;

    import javax.swing.BorderFactory;
    import javax.swing.JPanel;

    public class Breakout extends JPanel {
        // instance variables
        private int width, height;
        private Ball ball;
        private Paddle paddle;
        private Block block;

        // constructor
        public Breakout(int w, int h) {
            width = w;
            height = h;

            setSize(width, height);
            setLocation(30, 30);
            setBackground(Color.darkGray);
            setBorder(BorderFactory.createLineBorder(Color.black, 3));

            ball = new Ball(55, Color.blue);
            paddle = new Paddle();
            block = new Block(0,0,Color.GREEN,10);
        }

        // methods
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            ball.paint(g);
            paddle.paint(g);
            block.paint(g);

        }

        public void move() {
            ball.move();
            paddle.move();
        }
    }

```
## Window.java
```java
    import javax.swing.JFrame;

    public class Window extends JFrame {
        // instance variables (declared)

        // constructor(s) - where the instance variables are initialized
        public Window() {
            // this is called once when the object is made, it will initialize any instance variables or build the visible object with the use of methods rom other class

            setSize(800, 600);
            setTitle("Breakout - Nagra");
            setLocationRelativeTo(null);
            setLayout(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            Breakout out = new Breakout(410,510);
            add(out);
            
            setVisible(true); // this should be the last line of code so that everything above it is loaded before it set to visible
        
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
        
        
        // methods
    }

```
## Paddle.java
```java
    import java.awt.Color;
    import java.awt.Graphics;

    public class Paddle {
        // instance variables
        private int width, height;
        private int xPos, yPos;
        private Color color;
        private int xVelocity;

        // constructor
        public Paddle() {
            width = 100;
            height = 20;
            xPos = 200;
            yPos = 300;
            color = Color.RED;
            xVelocity = 2;
        }

        // methods
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillRect(xPos, yPos, width, height);
        }

        public void move(){
            xPos += xVelocity;
        }
    }

```
## Block.java

```java
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
```
