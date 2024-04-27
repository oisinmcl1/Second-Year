import java.awt.*;

/*
TODO
• -Member data includes x,y,color
• -Constructor method randomises the object’s position and color
• -Public move() method is used to randomly alter x,y members
• -Public paint(Graphics g) method draws the object as a square using g.fillRect()
 */

public class GameObject {
    private double x, y;
    private int red, gre, blu;
    private final int sqSize;

    public GameObject() {
        x = (int) (Math.random() * 600);
        y = (int) (Math.random() * 600);

        red = (int) (Math.random() * 256);
        gre = (int) (Math.random() * 256);
        blu = (int) (Math.random() * 256);

        sqSize = 50;
    }

    public void move() {
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
    public void paint(Graphics g) {
        g.setColor(new Color(red, gre, blu));
        g.fillRect((int) x, (int) y, sqSize, sqSize);
    }
}
