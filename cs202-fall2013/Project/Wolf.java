

import java.awt.Color;
import java.awt.Graphics;

public class Wolf extends Entity {

	public Wolf(int x, int y, Color c) {
		super(x, y, c);
	}

	void paint(Graphics pen) {
		// System.out.println("wolf [x=" + x + " y=" + y + " color=" + c + "]");
		pen.setColor(c);
		pen.fillRect(xstep * x + 4, ystep * y + 2, 20, 16);
	}
}
