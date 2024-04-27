//package week4;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {
	
	// member data
	private static String workingDirectory;
	private static boolean isInitialised = false;
	private static final Dimension WindowSize = new Dimension(800,600);
	private BufferStrategy strategy;
	private Graphics offscreenGraphics;
	private static final int NUMALIENS = 30;
	private Alien[] AliensArray = new Alien[NUMALIENS];
	private Spaceship PlayerShip;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private Image bulletImage;
//	private Bullet Bullet;
	private boolean inProg;
	private int score;

	// constructor
	public InvadersApplication() {
        //Display the window, centred on the screen
        Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width/2 - WindowSize.width/2;
        int y = screensize.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
    	this.setTitle("Space Invaders");
        
        // load image from disk
        ImageIcon icon = new ImageIcon(workingDirectory + "/alien_ship_1.png");
        Image alienImage1 = icon.getImage();
		icon = new ImageIcon(workingDirectory + "/alien_ship_2.png");
		Image alienImage2 = icon.getImage();
        
        // create and initialise some aliens, passing them each the image we have loaded
        for (int i=0; i< NUMALIENS; i++) {
        	AliensArray[i] = new Alien(alienImage1, alienImage2);
        	double xx = (i%5)*80 + 70;
        	double yy = (i/5)*40 + 50; // integer division!
        	AliensArray[i].setPosition(xx, yy);
        }
        Alien.setFleetXSpeed(2);
        
        // create and initialise the player's spaceship
        icon = new ImageIcon(workingDirectory + "/player_ship.png");
        Image shipImage = icon.getImage();
        PlayerShip = new Spaceship(shipImage);
        PlayerShip.setPosition(300,530);

		icon = new ImageIcon(workingDirectory + "/bullet.png");
		bulletImage = icon.getImage();

        // tell all sprites the window width
        Sprite2D.setWinWidth(WindowSize.width);
        
        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();
        
        // send keyboard events arriving into this JFrame back to its own event handlers
        addKeyListener(this);
        
        // initialise double-buffering
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offscreenGraphics = strategy.getDrawGraphics();

        isInitialised = true;
		inProg = false;
		score = 0;
	}
	
	// thread's entry point
	public void run() {
		while (true) {
			// 1: sleep for 1/50 sec
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) { }
			
			// 2: animate game objects
			boolean alienDirectionReversalNeeded = false;
			for (int i=0;i<NUMALIENS; i++) {
				if (AliensArray[i].move())
					alienDirectionReversalNeeded=true;
			}
			if (alienDirectionReversalNeeded) {
				Alien.reverseDirection();
				for (int i=0;i<NUMALIENS; i++)
					AliensArray[i].jumpDownwards();
			}
			
			PlayerShip.move();

			//Running from last bullet first and iterating backwards as bullets added to end of array
			for (int i = bullets.size() - 1; i >= 0; i--) {
				Bullet bullet = bullets.get(i);
				bullet.move();

				//Logic for collisions
				Rectangle bullRect = bullet.getBounds();

				for (int j = 0; j < AliensArray.length; j++) {
					Alien alien = AliensArray[j];

					if (alien.getAlive()) {
						Rectangle alienRect = alien.getBounds();

						if (collisions(bullRect, alienRect)) {
							alien.setAlive(false);
							bullets.remove(i);
							score += 10;

							break;
						}
					}
				}
			}

			for (Alien alien : AliensArray) {
				if (alien.getAlive()) { //Check only for alive aliens
					Rectangle spaceshipRect = PlayerShip.getBounds();
					Rectangle alienRect = alien.getBounds();

					if (collisions(spaceshipRect, alienRect)) {
						//Collision detected, game over
						inProg = false; //Stop the game, show menu
						reset(false); //Reset the game to its initial state
						break;
					}
				}
			}

			if (inProg && allAliensDead()) {
				reset(true); //true to indicate creating a new wave with increased speed
			}
			// 3: force an application repaint
			this.repaint();
		}
	}
	
	// Three Keyboard Event-Handler functions
    public void keyPressed(KeyEvent e) {
		if(!inProg) {
			inProg = true;
			reset(false);
			repaint();
			return;
		}

    	if (e.getKeyCode()==KeyEvent.VK_LEFT)
    		PlayerShip.setXSpeed(-4);
    	else if (e.getKeyCode()==KeyEvent.VK_RIGHT)
    		PlayerShip.setXSpeed(4);

		else if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			Bullet activeBullet = new Bullet(bulletImage);
			activeBullet.setPosition(PlayerShip.x + 24, PlayerShip.y + -15);
			bullets.add(activeBullet);
		}
    }
    
    public void keyReleased(KeyEvent e) {	
    	if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_RIGHT) 
    		PlayerShip.setXSpeed(0);
    }
    
    public void keyTyped(KeyEvent e) {
    }
    //

	// application's paint method
	public void paint(Graphics g) {
		//Game menu if game isn't in progress
		if (!inProg) {
			g.setColor(Color.black);
			g.fillRect(0, 0, WindowSize.width, WindowSize.height);

			Font font = new Font("Arial", Font.BOLD, 50);
			g.setFont(font);
			g.setColor(Color.white);

			g.drawString("Space Invaders", 210, 300);
			g.drawString("Press Any Key To Start", 145, 360);
		}
		else {

			if (!isInitialised)
				return;

			g = offscreenGraphics;

			// clear the canvas with a big black rectangle
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, WindowSize.width, WindowSize.height);

			// redraw all game objects
			for (int i = 0; i < NUMALIENS; i++)
				AliensArray[i].paint(g);

			PlayerShip.paint(g);

			for (Bullet bullet : bullets) {
				bullet.paint(g);
			}

			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.setColor(Color.WHITE);
			g.drawString("Score: " + score, 10, 50); // Draws the score at the top left

			// flip the buffers offscreen<-->onscreen
			strategy.show();
		}
	}

	//Found on slides
	public boolean collisions(Rectangle r1, Rectangle r2) {
		int x1 = r1.x;
		int y1 = r1.y;
		int w1 = r1.width;
		int h1 = r1.height;

		int x2 = r2.x;
		int y2 = r2.y;
		int w2 = r2.width;
		int h2 = r2.height;

		return ((x1 < x2 && x1 + w1 > x2) || (x2 < x1 && x2 + w2 > x1)) && ((y1 < y2 && y1 + h1 > y2) || (y2 < y1 && y2 + h2 > y1));
	}

	public void reset(boolean newWave) {
		//Reset method, resets speed position, score if the game is over, other wise used for increasing level
		if(newWave) {
			//Increase the speed for the new wave
			double currentSpeed = Alien.getFleetXSpeed();
			Alien.setFleetXSpeed(currentSpeed * 1.2);
		} else {
			//Reset game over or initial start
			Alien.setFleetXSpeed(2); //Reset to initial speed
			score = 0;
		}


		PlayerShip.setPosition(300, 530);

		for (int i = 0; i < NUMALIENS; i++) {
			double xx = (i%5)*80 + 70;
			double yy = (i/5)*40 + 50; // integer division!
			AliensArray[i].resetAlien(xx, yy);
		}
	}

	private boolean allAliensDead() {
		for (Alien alien : AliensArray) {
			if (alien.getAlive()) {
				return false; //At least one alien is still alive
			}
		}
		return true; //All aliens are dead
	}

	// application entry point
	public static void main(String[] args) {
		workingDirectory = System.getProperty("user.dir");
		System.out.println("Working Directory = " + workingDirectory);
		InvadersApplication w = new InvadersApplication();
	}
}

