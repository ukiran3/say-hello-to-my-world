import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame
{

		public ChessBoard()
		{	
			JPanel jf = new JPanel();
			jf.setLayout(new GridLayout(8, 8));
			for(int i = 0; i < 8; i++)
			{
				for(int j = 0; j < 8; j++)
				{
					if((i + j) % 2 == 0)
					{	
						jf.add(new WhiteBox());
					}
					else
					{
						jf.add(new BlackBox());
					}
				}
			}
			add(jf);
		}
		
	public static void main(String args[])
	{
			ChessBoard frame = new ChessBoard();		
			frame.setTitle("Next one.");
			frame.setSize(360, 360);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
}

class WhiteBox extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}

class BlackBox extends JPanel
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