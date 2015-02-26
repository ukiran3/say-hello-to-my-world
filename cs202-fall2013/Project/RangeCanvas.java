

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JPanel;

class RangeCanvas extends JPanel implements BoardSettings {
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<Entity> animals = new ArrayList<Entity>();
	
	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);

		int ystep = B_HEIGHT/20;
		int xstep = B_WIDTH/20;

		for (int i = 0; i < 11; i++) {
			pen.drawLine(0, i*ystep, B_WIDTH, i*ystep);
		}
		
		for (int i = 0; i < 11; i++) {
			pen.drawLine(i*xstep, 0, i*xstep, B_HEIGHT);
		}
		
		// -- begin example --
		// you should remove these when your code is working
		animals.add( new Sheep(5, 5, new Color(255,255,255)) );
		animals.add( new Wolf(5, 6, Color.red) );
		animals.add( new Wolf(5, 4, Color.red) );
		animals.add( new Wolf(4, 5, Color.black) );
		animals.add( new Wolf(6, 5, Color.black) );
		animals.add( new Wolf(6, 7, Color.blue) );
		// -- end example --
		
		for (Entity animal : animals) {
			animal.paint(pen);
		}
	}

	public void CreateAnimalsWithRandomLocations(int NS, int NW) {
		// 1. create NS number of sheep and assign them random locations
		// 2. create NW number of wolves and assign them random locations
		// 3. add the entities above to the animals ArrayList

		// -- begin update code --
		
		// -- end update code --
	}
	
	public void ReadFromFile(File file) {
		// read data from files into the animals ArrayList
		// -- begin update code --
		
		// -- end update code --
	}
}
