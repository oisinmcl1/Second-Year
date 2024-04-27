import java.awt.*;

public class Sprite2D {
    // member data
    private double x, y;
    private double xSpeed = 0;
    private Image myImage;

    // constructor
    public Sprite2D(Image i) {
        myImage = i;
    }

    // public interface
    public void moveEnemy() {
        int xRandom = (int) (Math.random() * 2);
        int yRandom = (int) (Math.random() * 2);

        if (xRandom == 0) {
            x += 5;
        }
        else {
            x -= 5;
        }
        if (yRandom == 0) {
            y += 5;
        }
        else {
            y -= 5;
        }
    }

    public void setPosition(double xx, double yy) {
//        x = (int) (Math.random() * 600);
//        y = (int) (Math.random() * 600);

        x = xx;
        y = yy;
    }

    public void movePlayer() {
        x += xSpeed;
    }

    public void setXSpeed(double dx) {
        xSpeed = dx;
    }

    public void paint(Graphics g) {
        g.drawImage(myImage, (int)x, (int)y, null);
    }
}
