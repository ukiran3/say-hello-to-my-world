package edu.calstatela.cs202.gala.project;

import java.awt.Color;
import java.awt.Graphics;

public abstract class TestPlant {

	private String symbol;
	private int x;
	private int y;
	private Color c;
	
	public TestPlant()
	{
		symbol = "None given";
		x = -1;
		y = -1;
		c = new Color(0);
	}
	
	public TestPlant(String symbol, int x, int y)
	{
		this.symbol = symbol;
		this.x = x;
		this.y = y;
	}
	
	abstract void paint(Graphics pen);
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
}
