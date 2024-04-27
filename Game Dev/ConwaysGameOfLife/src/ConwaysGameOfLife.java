import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public class ConwaysGameOfLife extends JFrame implements Runnable, MouseListener {
    private static final Dimension WindowSize = new Dimension(800, 800);
    private BufferStrategy strategy;
    private int size;
    private boolean[][] state;

    public ConwaysGameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - WindowSize.width / 2;
        int y = screensize.height / 2 - WindowSize.height / 2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);
        this.setTitle("Conway's Game Of Life");
        createBufferStrategy(2);
        strategy = getBufferStrategy();

        addMouseListener(this);

        size = 40;
        state = new boolean[size][size];

        //Every cell is dead to begin with
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                state[i][j] = false;
            }
        }

        new Thread(this).start();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = e.getY() / 20;
        int col = e.getX() / 20;

        if(state[row][col] == true) {
            state[row][col] = false;
        }
        else if(state[row][col] == false) {
            state[row][col] = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            repaint();

            try {
                Thread.sleep(20); // Sleep to control frame rate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WindowSize.width, WindowSize.height);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (state[i][j]) {
                    g.setColor(Color.WHITE); // Color for alive cells
                } else {
                    g.setColor(Color.BLACK); // Color for dead cells
                }
                g.fillRect(i * 20, j * 20, 20, 20); // Draw each cell as a 20x20 pixel square
            }
        }
    }

    public static void main(String[] args) {
        new ConwaysGameOfLife();
    }
}
