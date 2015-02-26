package edu.calstatela.cs202.gala.project;

import java.awt.Color;
import java.awt.Graphics;

public class TestSheep extends TestMammal{
	
	private int previousX;
	private int previousY;
	private boolean alive;
	private boolean hasEaten;
	private static Color c = new Color(250, 250, 250);
	
	public TestSheep()
	{
		super("S", 0, 0, c);
		previousX = -1;
		previousY = -1;
		alive = true;
		hasEaten = false;
	}

	public void kill()
	{
		alive = false;
	}
	
	public boolean checkLife()
	{
		return alive;
	}
	
	public void setHasEaten()
	{
		hasEaten = true;
	}
	
	public void resetHasEaten()
	{
		hasEaten = false;
	}
	
	public boolean getHasEaten()
	{
		return hasEaten;
	}

	@Override
	void paint(Graphics pen) {
		// TODO Auto-generated method stub
		
	}
}
