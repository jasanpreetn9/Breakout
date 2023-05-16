# Breakout Day 4

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
        private int xVelocity, yVelocity;

        private Breakout breakout;

        // constructor
        public Ball(Breakout out, int d, Color c) {
            breakout = out; // this allows for communication/access to the Breakout object
            diameter = d;
            color = c;
            xPos = 99;
            yPos = 16;
            xVelocity = 2;
            yVelocity = 2;
        }
        // methods
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(xPos, yPos, diameter, diameter);
        }

        public void move(){
            if (xPos + xVelocity > breakout.getWidth() - diameter) {
                xVelocity = -2;
            }
            if (xPos - xVelocity < 0) {
                xVelocity = 2;
            }
            if (yPos > breakout.getHeight() - diameter) {
                yVelocity = -2;
            }
            if (yPos < 0) {
                yVelocity = 2;
            }
            xPos += xVelocity;
            yPos += yVelocity;
        }
    }

```

```java
    private Breakout breakout;
    public Ball(Breakout out, int d, Color c) {
            breakout = out; // this allows for communication/access to the Breakout object
    }
```
This code will create a two way connection between the breakout and the ball class.

```java
    if (xPos + xVelocity > breakout.getWidth() - diameter) {
        xVelocity = -2;
    }
    if (xPos - xVelocity < 0) {
        xVelocity = 2;
    }
    if (yPos > breakout.getHeight() - diameter) {
        yVelocity = -2;
    }
    if (yPos < 0) {
        yVelocity = 2;
    }
```
This code segments make sure the ball does not leave the panel by using if statements we check if the ball is going the outside the frame and change the velocity

---
## Breakout.java
```java 
    import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;

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
            setLocation(50, 50);
            setBackground(Color.darkGray);
            setBorder(BorderFactory.createLineBorder(Color.black, 3));

            ball = new Ball(this, 55, Color.blue); // this is like self in python
            paddle = new Paddle(this);
            block = new Block(0,0,Color.GREEN,10);
        
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
            block.paint(g);

        }

        public void move() {
            ball.move();
            paddle.move();
        }
    }
```

```java
    ball = new Ball(this, 55, Color.blue); // this is like self in python
    paddle = new Paddle(this);
```
"this" represents connecting the breakout class to the paddle and the ball class.

---
## Paddle.java

```java
    import java.awt.Color;
    import java.awt.Graphics;
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
            yPos = 300;
            color = Color.RED;
            xVelocity = 0;
        }

        // methods
        public void keyPressed(KeyEvent e) { // explain
            if (e.getKeyCode() == 37) {
                xVelocity = -5;
            }
            if (e.getKeyCode() == 39) {
                xVelocity = 5;
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
    }
```

```java
    private Breakout breakout;

        // constructor
    public Paddle(Breakout out) {
            breakout = out; // this allows for communication/access to the Breakout object

    }
```
This code will create a two way connection between the breakout and the ball class.
