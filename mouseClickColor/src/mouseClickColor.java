import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class mouseClickColor extends JFrame
{
	
	public mouseClickColor()
	{
		fillBlack jp = new fillBlack();
		
		add(jp, BorderLayout.CENTER);
	}
	
	
	
	public static void main(String[] args)
	{
		mouseClickColor frame = new mouseClickColor();
		frame.setSize(200,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Mouse clicks...!!!");
		frame.setVisible(true);
	}
}
class fillBlack extends JPanel
{
	Color c1 = Color.BLACK;
	public fillBlack()
	{
		addMouseListener(new MouseListener(){
			public void mousePressed(MouseEvent e)
			{
				c1 = Color.BLACK;
				repaint();
			}
			public void mouseReleased(MouseEvent e)
			{
				c1 = Color.white;
				repaint();
			}
			public void mouseEntered(MouseEvent e)
			{
				
			}
			public void mouseExited(MouseEvent e)
			{
				
			}
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(c1);
		//System.out.println("0");
		g.fillRect(0, 0, getWidth(), getHeight());
		repaint();
	}
}