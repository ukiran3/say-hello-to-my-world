import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MouseKey extends JFrame
{
	public MouseKey()
	{
		KeyBoard kb = new KeyBoard();
		kb.setFocusable(true);
		add(kb);
	}
	public static void main(String args[])
	{
		MouseKey frame = new MouseKey();
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("KeyBoard and Mouse");
		frame.setVisible(true);
	}
}
class KeyBoard extends JPanel
{
	int x;
	int y;
	char c = 'A';
	public KeyBoard()
	{
		addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				c = e.getKeyChar();
				repaint();
	
			}
			public void keyReleased(KeyEvent e)
			{
				c = e.getKeyChar();
				repaint();
	
			}
			public void keyTyped(KeyEvent e)
			{
				c = e.getKeyChar();
	
				repaint();
			}
		});
		addMouseMotionListener(new MouseMotionListener()
		{
			
			public void mouseDragged(MouseEvent e)
			{
				x = e.getX();
				y = e.getY();
				repaint();
	
			}
			public void mouseMoved(MouseEvent e)
			{
				x = e.getX();
				y = e.getY();
				repaint();
				
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString(String.valueOf(c), x, y);
		repaint();
	}
}