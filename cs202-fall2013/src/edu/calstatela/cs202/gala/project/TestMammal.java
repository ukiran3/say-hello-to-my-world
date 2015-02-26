package edu.calstatela.cs202.gala.project;

import java.awt.Color;
import java.awt.Graphics;

public abstract class TestMammal implements Moveable{

	private String symbol; //Symbol of the animal on a console, none-GUI board
	public static int ID = -1;
	private int x; //X-position of the animal
	private int y; //Y-position of the animal
	private int id;
	Color c;
	
	public TestMammal()
	{
		//ID++;
		symbol = "None given" + ID;
		x = -1; 
		y = -1;	
		id = ID;
		c = new Color(0);
	}
	
	public TestMammal(String symbol, int x, int y, Color c)
	{
		ID++;
		this.symbol = symbol + ID;
		this.x = x;
		this.y = y;
		this.id = ID;
		
	}
	
	abstract void paint(Graphics pen); 
	
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
	
	public void setBoardPosition(TestBoard tb)
	{
		tb.board[this.x][this.y] = "   " + "S" + "   ";
	}
	
	public int moveNorth(int x) {
		//Move UP
		return --x;
	}

	@Override
	public int moveEast(int y) {
		//Move RIGHT
		return ++y;
	}

	@Override
	public int moveWest(int y) {
		//Move LEFT
		return --y;
	}

	@Override
	public int moveSouth(int x) {
		//Move DOWN
		return ++x;
	}

	@Override
	public int moveRandom(int coordinate) {
		TestBoard tb = new TestBoard();
		int min = 0;
		int max = 2;
		int chance = direction(min, max);
		if(chance == 0) //++
		{
			++coordinate;
		}else if(chance == 1) //--
		{
			--coordinate;
		}
		
		return coordinate;
	}
	
	public int direction(int min, int max)
	{
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}
}
