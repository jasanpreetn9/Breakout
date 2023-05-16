import javax.swing.ImageIcon;
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
        ImageIcon img = new ImageIcon("img/icon.png");
        setIconImage(img.getImage());
        
        Breakout out = new Breakout(692,500);
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
