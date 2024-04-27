//package week4;

import java.awt.*;

public class Alien extends Sprite2D {
	private static double xSpeed=0;
	private Image myImage;
	private Image myImage2;
	private int framesDrawn;
	private boolean alive;
	
	public Alien(Image i, Image j) {
		super(i); // invoke constructor on superclass Sprite2D
		myImage = i;
		myImage2 = j;
		framesDrawn = 0;
		alive = true;
	}
	
	// public interface
	public boolean move() {
		x+=xSpeed;
		
		// direction reversal needed?
		if (x<=0 || x>=winWidth-myImage.getWidth(null))
			return true;
		else
			return false;
	}
	
	public static void setFleetXSpeed(double dx) {
		xSpeed=dx;
	}
	public static double getFleetXSpeed() {
		return xSpeed;
	}
	
	public static void reverseDirection() {
		xSpeed=-xSpeed;
	}	
	
	public void jumpDownwards() {
		y+=20;
	}

	public void setAlive(boolean al) {
		alive = al;
	}
	public boolean getAlive() {
		return alive;
	}

	public void resetAlien(double xx, double yy) {
		this.x = xx;
		this.y = yy;
		this.alive = true;
	}

	public void paint(Graphics g) {
		if (alive) {
			framesDrawn++;
			if (framesDrawn % 100 < 50)
				g.drawImage(myImage, (int) x, (int) y, null);
			else
				g.drawImage(myImage2, (int) x, (int) y, null);
		}
	}
}

