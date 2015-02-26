import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Entity
{
	public Grass(int x, int y, Color c) {
		super(x, y, c);
	}

	void paint(Graphics pen) {
		// System.out.println("sheep [x=" + x + " y=" + y + " color=" + c + "]");
		pen.setColor(c);
		pen.fillRect(xstep * x, ystep * y, (xstep*20) / 21, (ystep*20)/2);
	}

}
