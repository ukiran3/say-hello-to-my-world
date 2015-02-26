package edu.calstatela.cs202.gala.Test;

public abstract class TestMammal implements Moveable{

	private String symbol; //Symbol of the animal on a console, none-GUI board
	public static int ID = -1;
	private int x; //X-position of the animal
	private int y; //Y-position of the animal
	private int id;
	
	
	public TestMammal()
	{
		//ID++;
		symbol = "None given";
		x = -1; 
		y = -1;	
		id = ID;
		
	}
	
	public TestMammal(String symbol, int x, int y)
	{
		ID++;
		this.symbol = symbol + ID;
		this.x = x;
		this.y = y;
		this.id = ID;
		
	}
	
	public int getID()
	{
		return id;
	}
	
	public String getSymbol()
	{
		return symbol;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
}
