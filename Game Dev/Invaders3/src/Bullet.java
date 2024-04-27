import java.awt.*;

public class Bullet extends Sprite2D {
    private static double ySpeed;
    public Bullet(Image i) {
        super(i);
        ySpeed = -5;
    }

    public void move() {
        y += ySpeed;
    }
}
