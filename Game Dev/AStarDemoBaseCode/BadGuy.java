//idk how to get it to work
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.Stack;

public class BadGuy {
	
	Image myImage;
	int x=0,y=0;
	boolean hasPath=false;
	Stack<Node> directions = new Stack<>();

	public BadGuy( Image i ) {
		myImage=i;
		x = 30;
		y = 10;
	}

	private int heuristic(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}


	public void reCalcPath(boolean map[][],int targx, int targy) {
		// TO DO: calculate A* path to targx,targy, taking account of walls defined in map[][]
		LinkedList<Node> openL = new LinkedList();
		LinkedList<Node> closedL = new LinkedList();

		directions = new Stack<>();
		Node[][] nMap = new Node[40][40];
		hasPath = false;

		Node currentN = null;
		Node nextN = null;

		for (int mpX = 0; mpX < 40; mpX++) {
			for (int mpY = 0; mpY < 40; mpY++) {
				nMap[mpX][mpY] = new Node(mpY, mpY);
			}
		}

		Node startNode = nMap[x][y];
		startNode.setG(0);
		startNode.setH((Math.abs(x - startNode.getX())) + (Math.abs(y - startNode.getY())));
		startNode.setF();
		startNode.setParent(null);
		openL.add(startNode);
	}

	public void move(boolean map[][],int targx, int targy) {
		reCalcPath(map, targx, targy);
		if (hasPath) {
			if (!directions.isEmpty()) {
				Node n = directions.pop();
				x = n.getX();
				y = n.getY();
			}
			
		}
		else {
			// no path known, so just do a dumb 'run towards' behaviour
			int newx=x, newy=y;
			if (targx<x)
				newx--;
			else if (targx>x)
				newx++;
			if (targy<y)
				newy--;
			else if (targy>y)
				newy++;
			if (!map[newx][newy]) {
				x=newx;
				y=newy;
			}
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(myImage, x*20, y*20, null);
	}
	
}

