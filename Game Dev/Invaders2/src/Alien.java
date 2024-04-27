import java.awt.*;

public class Alien extends Sprite2D {
    // member data
    private double x, y;
    private double xSpeed = 0;
    private double ySpeed = 0;
    private Image myImage;
    private Image myImage2;
    private int framesDrawn;

    // constructor
    public Alien(Image i, Image j) {
        super(i);
        x = Math.random() * 600;
        y = Math.random() * 600;
        myImage = i;
        myImage2 = j;
        framesDrawn = 0;
    }

    // public interface
    public void moveEnemy() {
//        x += 10 * (Math.random() - Math.random());
//        y += 10 * (Math.random() - Math.random());
//        if (x < 0)
//            x = 0;
//        else if (x > 600)
//            x = 600;
//        if (y < 50)
//            y = 50;
//        else if (y > 400)
//            y = 400;

        x += 0.5;
    }

    public void setPosition(double xx, double yy) {
        x = xx;
        y = yy;
    }

//    public void movePlayer() {
//        x += xSpeed;
//    }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void setYSpeed(double dy) { ySpeed = dy; }
    public double getXSpeed() { return xSpeed; }
    public double getYSpeed() { return ySpeed; }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void paint(Graphics g) {
        framesDrawn++;
        if (framesDrawn % 100 < 50)
            g.drawImage(myImage, (int)x, (int)y, null);
        else
            g.drawImage(myImage2, (int)x, (int)y, null);
    }

}
