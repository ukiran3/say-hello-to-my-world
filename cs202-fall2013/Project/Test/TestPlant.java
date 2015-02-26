package edu.calstatela.cs202.gala.Test;

public abstract class TestPlant {

	private String symbol;
	private int x;
	private int y;
	
	public TestPlant()
	{
		symbol = "None given";
		x = -1;
		y = -1;
	}
	
	public TestPlant(String symbol, int x, int y)
	{
		this.symbol = symbol;
		this.x = x;
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
