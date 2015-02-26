import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RacingCar extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RacingCar()
	{
		RCar rc = new RCar();
		add(rc);
	}
	public static void main(String[] args)
	{
		RacingCar frame = new RacingCar();
		frame.setTitle("Racing Car...====>>>");
		frame.setSize(500,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class RCar extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int x = 50;
	
	private Timer timer = new Timer(100, new TimerListener());
	public RCar()
	{
	      timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		int y = getHeight();
		if(x + 50 > getWidth())
			x = 0;
		else
			x = x + 50;
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.fillOval(x + 10, y - 10, 10, 10);
		g.fillOval(x + 30, y - 10, 10, 10);
		g.setColor(Color.BLUE);
		g.fillRect(x, y - 20, 50, 10);
		g.setColor(Color.GREEN);
		g.fillPolygon(new int[]{x + 10, x + 20, x + 30, x + 40}, new int[]{y - 20, y - 30, y - 30, y - 20}, 4);
	}
	class TimerListener implements ActionListener
	{
	    @Override 
	    public void actionPerformed(ActionEvent e)
	    {
	      repaint();
	    }
	}
}
