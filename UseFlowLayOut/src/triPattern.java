import javax.swing.*;
import java.awt.*;

public class triPattern extends JFrame
{
		public triPattern()
		{	
			JPanel jf = new JPanel(new GridLayout(1, 0));
			jf.add(new TriPattern1());
			add(jf);
		}
		
	public static void main(String args[])
	{
			triPattern frame = new triPattern();		
			frame.setTitle("Tri pattern...");
			frame.setSize(240, 240);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
}

class TriPattern1 extends JPanel
{
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int k = 1;
		StringBuffer str = new StringBuffer();
		for(int j = 0; j <= k && k < getWidth(); j++)
		{
				str.append(" " + (1+j));
				g.drawString(str+"", 1, (j + 1) * 10);
				k++;
		}
	}
}