import java.awt.*;
import javax.swing.*;

public class MyApplication extends JFrame {
    //Code given in lecture slides
    private static final Dimension WindowSize = new Dimension(600,600);
    public MyApplication() {
        //Create and set up the window.
        this.setTitle("Week 1 Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new squares());

        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    }

    private class squares extends JPanel {
        @Override
        //Was told to use paintComponent by lab tudor
        public void paintComponent (Graphics g) {
            super.paintComponent(g);
            //Size of squares and spaces
            int sqSize = 50;
            int space = 15;

            //Outer loop that goes through each row and increments by sqSize + space
            for (int i = 0; i < getWidth(); i += sqSize + space) {
                //Nested loop that goes through each row and increments by sqSize + space
                for (int j = 0; j < getHeight(); j += sqSize + space) {
                    //Generates random values for red, green and blue
                    int red = (int) (Math.random() * 256);
                    int gre = (int) (Math.random() * 256);
                    int blu = (int) (Math.random() * 256);

                    /*
                    int x = j * (sqSize + space) + space;
                    int y = i * (sqSize + space) + space;
                    */

                    //Sets colour and fills rectangle with colour
                    g.setColor(new Color(red, gre, blu));
                    //x value is i + space, y is j + space. Size set to sqSize
                    g.fillRect(i + space, j + space, sqSize, sqSize);
                }
            }
        }
    }

    public static void main(String [] args) {
        new MyApplication();
    }
}