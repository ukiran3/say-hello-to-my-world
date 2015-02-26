

import java.awt.Color;
import java.awt.Graphics;

public abstract class Entity implements BoardSettings {
	int x;
	int y;
	Color c;

	int ystep = B_HEIGHT/20;
	int xstep = B_WIDTH/20;

	public Entity(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
	
	abstract void paint(Graphics pen); 
}
