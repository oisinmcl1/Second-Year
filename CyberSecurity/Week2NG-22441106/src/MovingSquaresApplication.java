import javax.swing.*;
import java.awt.*;

/*
TODO
• -extends JFrame
• -Implements Runnable
• -has main() method
• -Member data includes an array of GameObject instances
• -Constructor method does similar setup as last week’s code, and in addition instantiates the GameObjects in the array, and creates+starts a Thread
• -Uses a Thread to perform animation of the GameObjects by calling their move() methods
• -Paint() method draws the GameObjects by calling their paint(Graphics g) methods
 */

public class MovingSquaresApplication extends JFrame implements Runnable {
    public GameObject[] gameObjects;
    private static final Dimension WindowSize = new Dimension(600,600);
    public static final int NumGameObjects = 30;

    public MovingSquaresApplication() {
        //Initialising the game objects array  with the number of game objects
        //Originally I had some bother with this so had to move it to top of class to refrain from getting errors
        gameObjects = new GameObject[NumGameObjects];
        for (int i = 0; i < NumGameObjects; i++) {
            gameObjects[i] = new GameObject();
        }

        //Creating window
        this.setTitle("Week 2 Assignment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);

        //Creating and starting thread
        Thread t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public void run() {
        //Infinitely running loop
        while (true) {
            //Loops through each game object and calls each of their move methods
            for (GameObject gameObject : gameObjects) {
                gameObject.move();
            }
            //Im not sure why but I need to call this to allow squares to move on their own
            repaint();

            //Got this from lecture notes
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException e) {
                e.printStackTrace();;
            }
        }
    }
    public void paint(Graphics g) {
        //This is used to keep painting a white background again everytime the square moves
        //This stops the trails left by squares
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        g.setColor(new Color(255, 255, 255));
        //To handle resizing window
        g.fillRect(0, 0, screensize.width, screensize.height);

        for (GameObject gameObject : gameObjects) {
            gameObject.paint(g);
        }
    }
    public static void main(String args[]) {
        new MovingSquaresApplication();
    }
}
