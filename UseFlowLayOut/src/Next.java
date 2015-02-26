import javax.swing.*;
import java.awt.*;


public class Next extends JFrame
{

		public Next()
		{	
			JPanel jf = new JPanel();
			jf.setLayout(new GridLayout(8, 8));
			for(int i = 1; i < 9; i++)
			{
				for(int j = 1; j < 9; j++)
				{
					if((i + j) % 2 == 0)
					{	
						JButton jb = new JButton(i+ "," +j);
						jb.setBackground(Color.BLACK);
						jb.setForeground(Color.BLACK);
						jf.add(jb);
						System.out.println(i+ "" +j);
					}
					else
					{
						JButton jb = new JButton(i+ ", " +j);
						jb.setBackground(Color.WHITE);
						jb.setForeground(Color.WHITE);
						jf.add(jb);
						System.out.println(i+ "" +j);
					}
				}
			}
			add(jf);
		}
		
	public static void main(String args[])
	{
			Next frame = new Next();		
			frame.setTitle("Next one.");
			frame.setSize(360, 360);
			frame.setLocationRelativeTo(null); 
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
	}
}