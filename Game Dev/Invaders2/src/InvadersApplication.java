//I started doing week 5 instead of week 4 and thats why bullet is done lol
//but now ive less than an hour to do week 4 thats why it may not be finished or commented

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    // member data
    private static String workingDirectory;
    private static boolean isGraphicsInitialised = false;
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int NUMALIENS = 30;
    private Sprite2D[] AliensArray = new Sprite2D[NUMALIENS];
    private PlayerShip PlayerShip;
    private Bullet Bullet;
    private BufferStrategy strategy;
    private int row;
    private int col;

    // constructor
    public InvadersApplication() {
        // Display the window, centered on the screen
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - WindowSize.width / 2;
        int y = screensize.height / 2 - WindowSize.height / 2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        this.setTitle("Space Invaders");
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        row = 5;
        col = NUMALIENS / row;

        // load image from disk. Make sure the path is right! For Mac use / rather than \\
        ImageIcon icon1 = new ImageIcon(workingDirectory + "/alien_ship_1.png");
        ImageIcon icon2 = new ImageIcon(workingDirectory + "/alien_ship_2.png");
        Image alienImage1 = icon1.getImage();
        Image alienImage2 = icon2.getImage();

        // create and initialise some aliens, passing them each the image we have loaded
        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i] = new Alien(alienImage1, alienImage2);
        }

        ImageIcon pIcon = new ImageIcon(workingDirectory + "/player_ship.png");
        Image shipImage = pIcon.getImage();
        PlayerShip = new PlayerShip(shipImage);
        PlayerShip.setPosition(300, 530);

        ImageIcon bIcon = new ImageIcon(workingDirectory + "/bullet.png");
        Image bImg = bIcon.getImage();
        double initShipX = PlayerShip.getX();
        double initShipY = PlayerShip.getY();
        Bullet = new Bullet(bImg, initShipX, initShipY);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int xPosition = j * 80 + 50; // Adjust spacing and start position as needed
                int yPosition = i * 80 + 50; // Adjust spacing and start position as needed
                int index = i * col + j;
                AliensArray[index] = new Alien(alienImage1, alienImage1); // Using the same image for now
                AliensArray[index].setPosition(xPosition, yPosition);
            }
        }

        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();

        // send keyboard events arriving into this JFrame back to its own event handlers
        addKeyListener(this);

        isGraphicsInitialised = true; // it’s now safe to paint the images
    }

    // thread's entry point
    public void run() {
        while (true) { // the game loop
            try {
                Thread.sleep(20); // sleep for 1/50 sec
            } catch (InterruptedException e) {
            }

            // animate game objects
            for (int i = 0; i < NUMALIENS; i++)
                AliensArray[i].moveEnemy();

            PlayerShip.movePlayer();

            this.repaint(); // force an application repaint
        }
    }

    // Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            PlayerShip.setXSpeed(-4);
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            PlayerShip.setXSpeed(4);
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Bullet.moveBullet();
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
            PlayerShip.setXSpeed(0);
    }

    public void keyTyped(KeyEvent e) {
    }

    // application's paint method
    public void paint(Graphics g) {
        g = strategy.getDrawGraphics();
        if (isGraphicsInitialised) { // don’t try to draw uninitialized objects!
            // clear the canvas with a big black rectangle
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WindowSize.width, WindowSize.height);

            // redraw all game objects
            for (int i = 0; i < NUMALIENS; i++)
                AliensArray[i].paint(g);

            PlayerShip.paint(g);

            Bullet.paint(g);

//            for (Bullet bullet : Bullets)
//                bullet.paint(g);
        }
        // Trigger a repaint to ensure updates are shown
        repaint();
        strategy.show();
    }

    // application entry point
    public static void main(String[] args) {
        workingDirectory = "/Users/oisinmcl/Java Code/InvaderApplication";
        new InvadersApplication();
    }
}