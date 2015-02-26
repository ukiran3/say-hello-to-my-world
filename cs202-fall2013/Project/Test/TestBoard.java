package edu.calstatela.cs202.gala.Test;

import java.util.ArrayList;

public class TestBoard {
	
	String rowKey;
	String columnKey;
	String difficultyKey;
	String diagonalKey;
	String sheepKey;
	String wolfKey;
	String treeKey;
	int row;
	int column;
	int numberOfSheep;
	int numberOfWolves;
	int numberOfTrees;
	String difficulty;
	boolean diagonalMove;
	String[][] board;
	ArrayList<TestSheep> sheep;
	
	public TestBoard()
	{
		rowKey = "R";
		columnKey = "C";
		difficultyKey = "Mode";
		diagonalKey = "DiagonalMove";
		sheepKey = "S";
		wolfKey = "W";
		treeKey = "T";
		row = 0;
		column = 0;
		numberOfSheep = 0;
		numberOfWolves = 0;
		numberOfTrees = 0;
		difficulty = null;
		diagonalMove = false;
		board = new String[row][column];
		sheep = new ArrayList<TestSheep>();
	}
	
	public void setBoardDimensions(TestConfig tc)
	{
		this.row = tc.getValue(rowKey);
//		System.out.println("R= " + row);
		this.column = tc.getValue(columnKey);
//		System.out.println("C= " + column);
		this.board = new String[row][column];
	}
	
	public void setGameDifficulty(TestConfig tc)
	{
		this.difficulty = tc.getRule(difficultyKey);
		String halfway = tc.getRule(diagonalKey);
		this.diagonalMove = Boolean.parseBoolean(halfway);
	}
	
	public String getGameDifficulty()
	{
		return difficulty;
	}
	
	public void setLife(TestConfig tc, TestSheep sheep)
	{
		//Set the numbers allowed for life
		this.numberOfSheep = tc.getValue(sheepKey);
		this.numberOfWolves = tc.getValue(wolfKey);
		this.numberOfTrees = tc.getValue(treeKey);
		
		//Set the amount of life to appear on board
		for(int amount = 0; amount < getNumberOfSheep(); amount++)
		{
			setSheepArray(sheep);
		}
		
		//Set locations on board
		int rowLimit = getRow();
		int columnLimit = getColumn();
		
		int x = -1, y = -1;
		
		//Give sheep locations
		for(TestSheep s : getSheepArray())
		{
			do
			{
				x = setLocation(0, columnLimit);
				y = setLocation(0, rowLimit);
				
				s.setX(x);
				s.setY(y);
				
				System.out.println("X is: " + x + "; Y is: " + y);
			} while(board[x][y].equals("S")); //While a sheep is there, later add watching for wolves and trees
		}
		//Set locations on board
		
		int count = 0;
		for(TestSheep s : getSheepArray())
		{
		
				x = s.getX();
				y = s.getY();
				
				board[x][y] = "[   S   ]"; 
				
				System.out.println("Array size: " + getSheepArraySize());
				
				System.out.println("X is: " + x + "; Y is: " + y);
				count++;
			
		}

		
	}
	
	public TestSheep getSheepObject(int index)
	{
		return sheep.get(index);
	}
	
	public int getSheepArraySize()
	{
		return sheep.size();
	}
	
	public int setLocation(int min, int max)
	{
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}
	
	public void setSheepArray(TestSheep sheep)
	{
		this.sheep.add(new TestSheep());
	}
	
	public ArrayList<TestSheep> getSheepArray()
	{
		return this.sheep;
	}
	
	public int getNumberOfSheep()
	{
		return numberOfSheep;
	}
	
	public int getNumberOfWolves()
	{
		return numberOfWolves;
	}
	
	public int getNumberOfTrees()
	{
		return numberOfTrees;
	}
	
	public int getRow()
	{
		return this.row;
	}
	
	public int getColumn()
	{
		return this.column;
	}
	
	public void fillBoard()
	{
		for(int row = 0; row < getRow(); row++)
		{
			for(int column = 0; column < getColumn(); column++)
			{
				board[row][column] = "[   G   ]";
			}
		}
	}
	
	public void displayBoard()
	{
		for(int row = 0; row < getRow(); row++)
		{
			System.out.println();
			
			for(int column = 0; column < getColumn(); column++)
			{
				System.out.print(board[row][column]);
			}
		}
	}
	
	public void updateBoard()
	{
		for(TestSheep s : getSheepArray())
		{
			int x = s.getX();
			int y = s.getY();
			board[x][y] = "[   S   ]";
		}

	}
	
	public String getCurrentStatus(int x, int y)
	{
		String status = board[x][y];
		return status;
	}
}
