import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
    // member data
    private static final Dimension WindowSize = new Dimension(600,600);
    private static final int NUMALIENS = 30;
    private Sprite2D[] AliensArray = new Sprite2D[NUMALIENS];
    private Sprite2D PlayerShip;
    Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    Image alienImage;
    Image playerImage;

    // constructor
    public InvadersApplication() {
        //Create and set up the window.
        this.setTitle("Invader Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        //Alien image
        ImageIcon aIcon = new ImageIcon("/Users/oisinmcl/Java Code/InvaderApplication/alien_ship_1.png");
        alienImage = aIcon.getImage();

        //Random position for aliens and image
        Random random = new Random();
        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i] = new Sprite2D(alienImage);
            AliensArray[i].setPosition(random.nextDouble(10, 600), random.nextDouble(10, 600));
        }

        //Player ship image
        ImageIcon pIcon = new ImageIcon("/Users/oisinmcl/Java Code/InvaderApplication/player_ship.png");
        playerImage = pIcon.getImage();
        PlayerShip = new Sprite2D(playerImage);

        //Set position of player
        PlayerShip.setPosition(300, 550);

        //Creating thread
        Thread t = new Thread(this);
        t.start();
    }

    // thread's entry point
    public void run() {
        while (true) {
            //Moving the aliens
            for (Sprite2D alien : AliensArray) {
                alien.moveEnemy();
            }

            //Move player
            PlayerShip.movePlayer();

            // Request to repaint the window
            this.repaint();

            // Sleep to control frame rate
            try {
                Thread.sleep(20); // This equates to 50 FPS (1000ms/20ms per frame)
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //The player doesn't move and I don't know why
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            PlayerShip.setXSpeed(-5);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(5);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            PlayerShip.setXSpeed(0);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    // application's paint method
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, screensize.width, screensize.height);
//        g.drawImage(alienImage, 150, 150, null);
//        g.drawImage(playerImage, 300, 550, null);

        for (int i = 0; i < NUMALIENS; i++) {
            AliensArray[i].paint(g);
        }
        PlayerShip.paint(g);
    }

    // application entry point
    public static void main(String[] args) {
        new InvadersApplication();
    }
}
