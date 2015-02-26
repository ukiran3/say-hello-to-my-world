

import java.awt.Color;
import java.awt.Graphics;

public class Sheep extends Entity {

	public Sheep(int x, int y, Color c) {
		super(x, y, c);
	}

	void paint(Graphics pen) {
		// System.out.println("sheep [x=" + x + " y=" + y + " color=" + c + "]");
		pen.setColor(c);
		pen.fillOval(xstep * x + 4, ystep * y + 2, 20, 16);
	}
}
