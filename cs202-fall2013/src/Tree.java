import java.awt.Color;
import java.awt.Graphics;

public class Tree extends Entity 
{
	public Tree(int x, int y, Color c) {
		super(x, y, c);
	}

	void paint(Graphics pen) {
		// System.out.println("sheep [x=" + x + " y=" + y + " color=" + c + "]");
		pen.setColor(c);
		pen.fillOval(xstep * x + 4, ystep * y + 2, (xstep*20) / 30 + 10, (ystep*20)/25 + 10);
	}

}
