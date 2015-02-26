import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

class StartTimer extends JPanel implements BoardSettings {
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<Entity> animals = new ArrayList<Entity>();
	String sh[][];	
	private Timer timer = new Timer(100, new TimerListener());
	
	@Override
	protected void paintComponent(Graphics pen) 
	{
		super.paintComponent(pen);
		System.out.println(timer.getInitialDelay());

		int ystep = B_HEIGHT/20;
		int xstep = B_WIDTH/20;

		for (int i = 0; i < 11; i++) {
			pen.drawLine(0, i*ystep, B_WIDTH, i*ystep);
		}
		
		for (int i = 0; i < 11; i++) {
			pen.drawLine(i*xstep, 0, i*xstep, B_HEIGHT);
		}
		
		for (Entity animal : animals) {
			animal.paint(pen);
		}
		
	}

	public void startTimer(String sh[][], int NS, int NW) 
	{
		
		ArrayList<Entity> nanimals = new ArrayList<Entity>();
		for(int x = 0; x < 11; x++)
		{
			for(int y = 0; y < 11; y++)
			{
				nanimals.add(new Grass(x,y,Color.green));
			}
		}
		
		nanimals.add(new Tree(0,0,Color.GRAY));
		nanimals.add(new Tree(1,1,Color.GRAY));
		nanimals.add(new Tree(2,2,Color.GRAY));
		nanimals.add(new Tree(3,3,Color.GRAY));

		Random random = new Random();
			
		animals = nanimals;
		
		// -- end update code --
	}
	
	public StartTimer()
	{
		timer.start();
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
