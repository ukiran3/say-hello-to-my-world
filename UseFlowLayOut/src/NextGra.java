import javax.swing.*;
import java.awt.*;

public class NextGra extends JFrame
{

		public NextGra()
		{	
			JPanel jf = new JPanel();
			jf.setLayout(new GridLayout(8, 8));
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if((i + j) % 2 == 0)
					{	
						jf.add(new BlackChecker());
					}
					else
					{
						jf.add(new WhiteChecker());
					}
				}
			}
			add(jf);
		}
		
	public static void main(String args[])
	{
			NextGra frame = new NextGra();		
			frame.setTitle("Next one.");
			frame.setSize(360, 360);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
}

class WhiteChecker extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}

class BlackChecker extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawString("1", getWidth() / 2, getHeight()/ 2);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}