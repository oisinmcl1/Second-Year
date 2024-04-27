public class Node {
    private int g, h, f, x, y;
    private Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getG() {
        return g;
    }

    public void setF() {
        f = g + h;
    }

    public int getF() {
        return f;
    }
}
