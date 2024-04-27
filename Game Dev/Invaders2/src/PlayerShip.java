import java.awt.*;

public class PlayerShip extends Sprite2D {
    // member data
    private double x, y;
    private double xSpeed = 0;
    private Image myImage;

    // constructor
    public PlayerShip(Image i) {
        super(i);
        x = Math.random() * 600;
        y = Math.random() * 600;
        myImage = i;
    }

    // public interface
//    public void moveEnemy() {
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
//    }

    public void setPosition(double xx, double yy) {
        x = xx;
        y = yy;
    }

    public void movePlayer() {
        x += xSpeed;
    }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void paint(Graphics g) {
        g.drawImage(myImage, (int)x, (int)y, null);
    }
}
