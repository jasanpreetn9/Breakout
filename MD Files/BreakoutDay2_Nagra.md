# Breakout Day 1

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
        // constructor
        public Breakout(int w, int h) {
            width = w;
            height = h;

            setSize(width, height);
            setLocation(30, 30);
            setBackground(Color.darkGray);
            setBorder(BorderFactory.createLineBorder(Color.black, 3));

            ball = new Ball(55, Color.blue);
        }

        // methods
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            ball.paint(g);
        }
    }
```

``` java
    private int width, height;
    private Ball ball;
```
These are instance variables of the Breakout class. width and height are integers that represent the dimensions of the Breakout panel, and ball is an object of type Ball that will represent the ball in the game.

```java
    public Breakout(int w, int h) {
        width = w;
        height = h;

        setSize(width, height);
        setLocation(30, 30);
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.black, 3));

        ball = new Ball(55, Color.blue);
    }
```
This is the constructor method for the Breakout class. It takes two integer parameters, w and h, which are used to set the width and height instance variables, respectively.
The method then sets the size, location, background color, and border of the JPanel (which is the superclass of Breakout). The setSize method sets the size of the panel, the setLocation method sets the position of the panel, the setBackground method sets the background color of the panel, and the setBorder method sets a black border with a thickness of 3 pixels.
Finally, the constructor creates a new Ball object with a radius of 55 pixels and a blue color, and assigns it to the ball instance variable.

```java
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ball.paint(g);
    }
```
The @Override annotation is used to indicate that a method in a subclass is intended to override a method with the same name and signature in its superclass.
This is an override of the paint method of JPanel. The paint method is called whenever the panel needs to be redrawn (e.g., when the panel is resized or when something needs to be added or removed from the panel).
The super.paint(g) call first calls the paint method of the superclass (JPanel), which clears the panel and fills it with the background color.
The ball.paint(g) call then calls the paint method of the ball object, which draws the ball on the panel using the Graphics object g. The Graphics object is a canvas that provides methods for drawing shapes, text, and images on the panel.

---

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
            
            Breakout out = new Breakout(370,540);
            add(out);
            
            setVisible(true); // this should be the last line of code so that everything above it is loaded before it set to visible
        }
        
        
        // methods
    }
```
```java 
    Breakout out = new Breakout(370,540);
```
This line creates a new Breakout object with width and height

```java
    add(out);
```
This line add the out panel to the screen

---

## Ball.java

```java
    import java.awt.Color;
    import java.awt.Graphics;

    public class Ball {
        // instance variables
        private int diameter;
        private Color color;

        // constructor
        public Ball(int d, Color c) {
            diameter = d;
            color = c;
        }
        
        // methods
        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(12, 106, diameter, diameter);
        }
    }

```

```java
    private int diameter;
    private Color color;
```
These are instance variables of the Ball class. diameter is an integer that represents the diameter of the ball, and color is a Color object that represents the color of the ball.

```java
    public Ball(int d, Color c) {
        diameter = d;
        color = c;
    }
```
This is the constructor method for the Ball class. It takes two parameters: an integer d representing the diameter of the ball, and a Color object c representing the color of the ball. The constructor sets the diameter and color instance variables to the values passed in as parameters.

```java
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(12, 106, diameter, diameter);
    }
```
The method  named paint. It takes a Graphics object g as a parameter. The paint method is responsible for drawing the ball on the screen using the Graphics object g.
The method first sets the color of the Graphics object to the color of the ball using the setColor method.
It then uses the fillOval method to draw a filled circle with the given diameter at the position (12, 106). The first two parameters of fillOval specify the position of the upper-left corner of the bounding rectangle, and the last two parameters specify the width and height of the bounding rectangle (which are both equal to the diameter of the ball).