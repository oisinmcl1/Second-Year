//package week4;

import java.awt.*;

public class Sprite2D {

	// member data
	protected double x,y;
	protected Image myImage;
	
	// static member data
	protected static int winWidth;
	
	// constructor
	public Sprite2D(Image i) {
		myImage = i;
	}
		
	public void setPosition(double xx, double yy) {
		x=xx;
		y=yy;
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, (int)x, (int)y, null);
	}
	
	public static void setWinWidth(int w) {
		winWidth = w;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, myImage.getWidth(null), myImage.getHeight(null));
	}
}
