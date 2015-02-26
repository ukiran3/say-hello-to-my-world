import javax.swing.*;

import java.awt.*;
import java.util.Random;
public class drawArrowLine extends JFrame
{
	public drawArrowLine()
	{
		JPanel jf = new JPanel(new GridLayout(1, 0));
		jf.add(new drawLineArrow());
		add(jf);
	}
	public static void main(String[] args)
	{
		drawArrowLine frame = new drawArrowLine();
		frame.setTitle("drawing Arrow Lines");
		frame.setSize(240, 240);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class drawLineArrow extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Random rn = new Random();
		int x1 = rn.nextInt(getWidth());
		int y1 = rn.nextInt(getHeight());
		int x2 = rn.nextInt(getWidth());
		int y2 = rn.nextInt(getHeight());
		drawArrowLine(x1, y1, x2, y2,g);
	}
	public static void drawArrowLine(int x1, int y1, int x2, int y2, Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, (int)(x1 + 10 - x2 * Math.cos(2 * Math.PI/3)), (int)(y1 +10 - y2 * Math.sin(2 * Math.PI/3)));
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.BLACK);
		g.drawLine(x1, y1, (int)(x1 + 10 - y2 * Math.cos(4 * Math.PI/3)), (int)(y1 +10 - y2 * Math.sin(4 * Math.PI/3)));
	}
}
