# Breakout Day 1

## Game.java

```java
    public class Game {
        public static void main(String[] args) {
            Window win = new Window();
        }
    }
```

What is needed is order to run a java program? The java compiler (javac) looks first for the main method to be executed. Only one main method is needed for a single java program.

The file in which the main method is in, should have the least amount of code.

Inside the main method, create an instance of the Window class. To do this you need the following the five items.

    1. Window is the class name (data types) for this declaration statement.
    2. Give a name to the object that is being made from the Window class
    3. Use the (=) to store an instance of the Window class in the object name (reference variable)
    4. use the keyword new to instantiate (make a copy of the Window class) the Window class
    5. Use the class constructor tou to make (create) the object.
    6. (;) to close the statement

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
            setVisible(true); // this should be the last line of code so that everything above it is loaded before it set to visible
        }
        
        
        // methods
    }
```

The following imports statements is needed in order use JFrame:
```java
    import java.swing.JFrame;
```

Class header:
```java
    public class Window extends JFrame 
```
This class header defines the window class. This class uses the keyword extends to make a relation ship with the JFrame class. The relationship between the two is known as "is-a" relationship. Let is, Window is a JFrame. this means i can use anything that is public in JFrame in the Window class.

Window Constructor:
```java
    public Window() {
                setSize(800, 600);
                setTitle("Breakout - Nagra");
                setLocationRelativeTo(null);
                setLayout(null);
                setResizable(false);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
    }
```
1. This is called a default constructor because there are no parameters.
2. Sets the size of the window using the setSize method which excepts two parameter(int:height and int:width).
3. Sets the title of the window using setTitle method which one excepts(str).
4. Centers the window on the screen using setLocationRelativeTo method.
5. Disables any layouts for this window and accepts one parameter with is an object.
6. Disables window resizing using setResizable with accepts one bool parameter.
7. Sets the default close operation to quit the program when the window is closed.
8. Makes the window visible using setVisible method which accepts a bool.