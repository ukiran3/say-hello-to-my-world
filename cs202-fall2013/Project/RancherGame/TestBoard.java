package edu.calstatela.cs202.gala.RancherGame;



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
	
	public void setLife(TestConfig tc)
	{
		this.numberOfSheep = tc.getValue(sheepKey);
		this.numberOfWolves = tc.getValue(wolfKey);
		this.numberOfTrees = tc.getValue(treeKey);
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
				board[row][column] = "[   X   ]";
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
}
