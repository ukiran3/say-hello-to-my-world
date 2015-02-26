import javax.swing.*;
import java.awt.*;
import java.util.Random;
public class CircleWithDist extends JFrame
{
	public CircleWithDist()
	{
		JPanel jf = new JPanel(new GridLayout(1, 0));
		jf.add(new Circlesd());
		add(jf);
	}
	public static void main(String[] args)
	{
		CircleWithDist frame = new CircleWithDist();
		frame.setTitle("Circles with Distance...");
		frame.setSize(240, 240);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class Circlesd extends JPanel
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
	
		g.fillOval(x1, y1, 15, 15);
		g.fillOval(x2, y2, 15, 15);
		double dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		g.drawString(""+(int)dist, (x1 + x2) / 2, (y1 + y2) / 2);
		g.setColor(Color.RED);
		g.drawLine(x1 + 7, y1 + 7, x2 + 7, y2 + 7);
	}
}
