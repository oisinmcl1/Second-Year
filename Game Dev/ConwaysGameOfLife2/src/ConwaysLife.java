import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.*;

public class ConwaysLife extends JFrame implements Runnable, MouseListener, MouseMotionListener {
    // member data
    private BufferStrategy strategy;
    private Graphics offscreenBuffer;
    private boolean[][][] gameState = new boolean[40][40][2];
    private int currentBuffer = 0;
    private boolean playing = false;
    private Rectangle startBut = new Rectangle(50,700, 100, 50);
    private Rectangle randtBut = new Rectangle(200,700, 100, 50);
    private Rectangle saveBut = new Rectangle(300, 700, 100, 50);
    private Rectangle loadBut = new Rectangle(400, 700, 100, 50);

    // constructor
    public ConwaysLife() {
        // Display the window, centered on the screen
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = ss.width / 2 - 400;
        int y = ss.height / 2 - 400;
        setBounds(x, y, 800, 800);
        setVisible(true);
        this.setTitle("Conway's game of life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialise double-buffering
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offscreenBuffer = strategy.getDrawGraphics();

        // register the JFrame itself to receive mouse events
        addMouseListener(this);
        addMouseMotionListener(this);

        // initialise the game state
        for (int xx = 0; xx < 40; xx++) {
            for (int yy = 0; yy < 40; yy++) {
                gameState[xx][yy][currentBuffer] = false;
            }
        }

        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();
    }

    // thread's entry point
    public void run() {
        while (true) {
            // 1: sleep for 1/5 sec
            try {
                if (playing) {
                    updateGameState();
                    // 2: animate game objects [nothing yet!]
                    // 3: force an application repaint
                    this.repaint();
                }
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // mouse events which must be implemented for MouseListener
    public void mousePressed(MouseEvent e) {
        // determine which cell of the gameState array was clicked on
        int mouseX = e.getX() / 20;
        int mouseY = e.getY() / 20;

        if (startBut.contains(e.getX(), e.getY())) {
            start();
        }
        else if (randtBut.contains(e.getX(), e.getY())) {
            randomize();
        }
        else if (playing) {
            // Only toggle the state of the cell if we didn't click on a button


            if (mouseX >= 0 && mouseX < 40 && mouseY >= 0 && mouseY < 40) { // make sure the click is within the bounds
                gameState[mouseX][mouseY][currentBuffer] = !gameState[mouseX][mouseY][currentBuffer];
                System.out.printf("Toggled cell at (%d, %d)\n", mouseX, mouseY);
            }
        }
        // request an extra repaint, to get immediate visual feedback
        repaint();
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }

    public void mouseMoved(MouseEvent e) {};
    public void mouseDragged(MouseEvent e) {
        // determine which cell of the gameState array is under the mouse while dragging
        int mouseX = e.getX() / 20;
        int mouseY = e.getY() / 20;

//        if (startBut.contains(e.getX(), e.getY())) {
//            start();
//        }
//        else if (randtBut.contains(e.getX(), e.getY())) {
//            randomize();
//        }
//
//        else if (playing) {

        // change the state of the cell only if we are within bounds and not playing
        if (mouseX >= 0 && mouseX < 40 && mouseY >= 0 && mouseY < 40 && !playing) {
            gameState[mouseX][mouseY][currentBuffer] = true; // Set the cell to alive as we drag over it
            repaint(); // Request repaint for immediate visual feedback
        }
    }

    public void start() {
        playing = true;
    }
    public void stop() {
        playing = false;
    }

    public void randomize() {
        Random rand = new Random();
        for (int x = 0; x < gameState.length; x++) {
            for (int y = 0; y < gameState[x].length; y++) {
                gameState[x][y][currentBuffer] = rand.nextBoolean();
            }
        }
        System.out.printf("Randomized game state\n");
    }

    // application's paint method
    public void paint(Graphics g) {
        g = offscreenBuffer; // draw to offscreen buffer

        // clear the canvas with a black rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);


        // redraw all game objects
        g.setColor(Color.WHITE);
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y < 40; y++) {
                if (gameState[x][y][currentBuffer]) {
                    g.fillRect(x * 20, y * 20, 20, 20);
                }
            }
        }

        // Draw the buttons when not playing
        if (!playing) {
            g.setColor(Color.GREEN);
            g.fillRect(startBut.x, startBut.y, startBut.width, startBut.height);
            g.setColor(Color.RED);
            g.fillRect(randtBut.x, randtBut.y, randtBut.width, randtBut.height);

            // Optionally, draw text on the buttons
            g.setColor(Color.WHITE);
            g.drawString("Start", startBut.x + 20, startBut.y + 30);
            g.drawString("Random", randtBut.x + 10, randtBut.y + 30);

            g.setColor(Color.BLUE);
            g.fillRect(saveBut.x, saveBut.y, saveBut.width, saveBut.height);
            g.setColor(Color.ORANGE);
            g.fillRect(loadBut.x, loadBut.y, loadBut.width, loadBut.height);

            g.setColor(Color.WHITE);
            g.drawString("Save", saveBut.x + 20, saveBut.y + 30);
            g.drawString("Load", loadBut.x + 20, loadBut.y + 30);
        }

        // flip the buffers
        strategy.show();
    }

    // Method to count neighbors considering wrap-around
    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue; // Skip the cell itself
                int nx = (x + dx + 40) % 40; // Wrap around the grid horizontally
                int ny = (y + dy + 40) % 40; // Wrap around the grid vertically
                if (gameState[nx][ny][currentBuffer]) count++;
            }
        }
        return count;
    }
    // Method to update the game state
    private void updateGameState() {
        int nextBuffer = (currentBuffer + 1) % 2; // Determine the index for the next buffer
        for (int x = 0; x < 40; x++) {
            for (int y = 0; y < 40; y++) {
                int liveNeighbors = countLiveNeighbors(x, y);
                boolean currentState = gameState[x][y][currentBuffer];
                // Apply the rules of the Game of Life
                if (currentState && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    gameState[x][y][nextBuffer] = false; // Cell dies
                } else if (!currentState && liveNeighbors == 3) {
                    gameState[x][y][nextBuffer] = true; // Cell becomes alive
                } else {
                    gameState[x][y][nextBuffer] = currentState; // Cell stays in its current state
                }
            }
        }
        currentBuffer = nextBuffer; // Swap the buffers
    }

    private void saveGame() {
        String line = null;
        String fileName = "/Users/oisinmcl/Java Code/ConwaysGameOfLife2/gamestate.txt";

        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            do {
                try {
                    line = reader.readLine();
                } catch { (IOException e)} {}
            }
            while (line != null);

            reader.close();
        } catch { (IOException e)} {};
         */
    }
    private void loadGame() {
        String line = null;
        String fileName = "/Users/oisinmcl/Java Code/ConwaysGameOfLife2/gamestate.txt";

        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            do {
                try {
                    line = reader.readLine();
                } catch { (IOException e)} {}
            }
            while (line != null);

            reader.close();
        } catch { (IOException e)} {};
         */
    }

    // application entry point
    public static void main(String[] args) {
        ConwaysLife w = new ConwaysLife();
    }
}