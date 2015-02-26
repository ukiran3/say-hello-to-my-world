import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Grid3x3 extends JFrame
{

		public Grid3x3()
		{			
			//setLayout(new GridLayout(5,5));
			add(new NewPanel());
			
		}
		
	public static void main(String args[])
	{
			Grid3x3 frame = new Grid3x3();			
			frame.setTitle("Red and Blue lines");
			frame.setSize(210, 120);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
}

class NewPanel extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawLine(0, getHeight()/3, getWidth(), getHeight()/3);
		g.drawLine(0, 2 * getHeight()/3, getWidth(), 2 * getHeight()/3);
		g.setColor(Color.BLUE);
		g.drawLine(getWidth() / 3, 0, getWidth() / 3, getHeight());
		g.drawLine(2 * getWidth() / 3, 0, 2 * getWidth() / 3, getHeight());
	}
}