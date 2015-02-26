package edu.calstatela.cs202.gala.project;

import java.util.ArrayList;

public class TestBoard {
	
	String rowKey;
	String columnKey;
	String difficultyKey;
	String diagonalKey;
	String sheepKey;
	String wolfKey;
	String treeKey;
	String delayKey;
	int delay;
	int row;
	int column;
	int numberOfSheep;
	int numberOfWolves;
	int numberOfTrees;
	String difficulty;
	boolean diagonalMove;
	String[][] board;
	ArrayList<TestSheep> sheep;
	ArrayList<TestWolf> wolves;
	ArrayList<testGrass> grass;
	ArrayList<testTree> tree;
	
	public TestBoard()
	{
		rowKey = "R";
		columnKey = "C";
		difficultyKey = "Mode";
		diagonalKey = "DiagonalMove";
		sheepKey = "S";
		wolfKey = "W";
		treeKey = "T";
		delayKey = "Delay";
		delay = 0;
		row = 0;
		column = 0;
		numberOfSheep = 0;
		numberOfWolves = 0;
		numberOfTrees = 0;
		difficulty = null;
		diagonalMove = false;
		board = new String[row][column];
		sheep = new ArrayList<TestSheep>();
		wolves = new ArrayList<TestWolf>();
		grass = new ArrayList<testGrass>();
		tree = new ArrayList<testTree>();
	}
	
	/**
	 * sets the dimensions of the game board
	 * @param tc has access to the methods of the configuration files
	 */
	public void setBoardDimensions(TestConfig tc)
	{
		this.row = tc.getValue(rowKey);
//		System.out.println("R= " + row);
		this.column = tc.getValue(columnKey);
//		System.out.println("C= " + column);
		this.board = new String[row][column];
		
		setAutomaticBoard();
		setBoardFence();
		
	}

	/**
	 * Give the board an default look filled with '?'
	 */
	public void setAutomaticBoard()
	{
		//Fill in board
		for(int i = 0 ; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
					this.board[i][j] = "         ";
			}
		}
	}
	
	/**
	 * Gives the board a fence on the outer edges of the array
	 */
	public void setBoardFence()
	{
		//Put in fence
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < column; j++)
			{
				if(i == 0)
					{
						this.board[i][j] = "[-------]";
					}
				if(i == row - 1)
					{
						this.board[i][j] = "[-------]";
					}
				if(j == 0)
				{
					this.board[i][j] = "[|]";
				}
				if(j == column - 1) 
				{
					this.board[i][j] = "[|]";
				}
			}
		}
	}
	
	/**
	 * Sets the difficulty setting of the game based on the level contained in the config file
	 * @param tc
	 */
	public void setGameDifficulty(TestConfig tc)
	{
		this.difficulty = tc.getRule(difficultyKey);
		String halfway = tc.getRule(diagonalKey);
		this.diagonalMove = Boolean.parseBoolean(halfway);
		this.delay = tc.getValue(delayKey);
	}
	
	/**
	 * Gets the level of hardness
	 * @return the level of hardness (easy or auto)
	 */
	public String getGameDifficulty()
	{
		return difficulty;
	}
	
	public void setNumberOfSheep(TestConfig tc)
	{
		this.numberOfSheep = tc.getValue(sheepKey);
	}
	
	public void setNumberOfWolves(TestConfig tc)
	{
		this.numberOfWolves = tc.getValue(wolfKey);
	}
	
	public void setNumberOfTrees(TestConfig tc)
	{
		this.numberOfTrees = tc.getValue(treeKey);
	}
	
	/**
	 * Sets up all life on board
	 * @param tc has methods of the config class
	 * @param sheep has methods of the sheep class
	 * @param tree has methods of the tree class
	 * @param wolf has methods of the wolf class
	 * @param grass has methods of the grass class
	 */
	//May be best to simplify if possible
	public void setLife(TestConfig tc, TestSheep sheep, testTree tree, TestWolf wolf, testGrass grass)
	{
		//Set the numbers allowed for life
		setNumberOfSheep(tc);
		setNumberOfWolves(tc);
		setNumberOfTrees(tc);
		
		int x = 0, y = 0, columnLimit = getColumn() - 2, rowLimit = getRow() - 2;
		
		//For Sheep
		//Set the amount of life to appear on board
		for(int amount = 0; amount < getNumberOfSheep(); amount++)
		{
			setSheepArray();
		}
		
		for(TestSheep s : getSheepArray())
		{
			x = setLocation(1, columnLimit);
			y = setLocation(1, rowLimit);
			while(board[x][y].contains("S"))
			{
				x = setLocation(1, columnLimit);
				y = setLocation(1, rowLimit);
			}
			s.setX(x);
			s.setY(y);
		}
	
		for(TestSheep s : getSheepArray())
		{
			x = s.getX();
			y = s.getY();
			this.board[x][y] = "   " + s.getSymbol() +"    ";
		}
		
		//For Wolves
		for(int amount = 0; amount < getNumberOfWolves(); amount++)
		{
			setWolfArray();
		}
		
		for(TestWolf w : getWolfArray())
		{
			x = setLocation(1, columnLimit);
			y = setLocation(1, rowLimit);
			while(board[x][y].contains("S") || board[x][y].contains("W"))
			{
				x = setLocation(1, columnLimit);
				y = setLocation(1, rowLimit);
			}
			w.setX(x);
			w.setY(y);
		}
		
		for(TestWolf w : getWolfArray())
		{
			x = w.getX();
			y = w.getY();
			this.board[x][y] = "   " + w.getSymbol() + "   ";
		}
		
		//For Trees
		for(int amount = 0; amount < getNumberOfTrees(); amount++)
		{
			setTreeArray();
		}
		
		for(testTree t : getTreeArray())
		{
			x = setLocation(1, columnLimit);
			y = setLocation(1, rowLimit);
			while(board[x][y].contains("S") || board[x][y].contains("W") || board[x][y].contains("T"))
			{
				x = setLocation(1, columnLimit);
				y = setLocation(1, rowLimit);
			}
			t.setX(x);
			t.setY(y);
		}
		
		for(testTree t : getTreeArray())
		{
			x = t.getX();
			y = t.getY();
			this.board[x][y] = "    "+ t.getSymbol()  +"    ";
		}
		
		//For Grass
		for(int i = 0; i < getRow(); i++)
		{
			for(int j = 0; j < getColumn(); j++)
			{
				if(!(board[i][j]).contains("T") && !(board[i][j]).contains("[]"))
				{
					setGrassArray();
				}
			}
		}
		
		int grassLevel = 0;
//		grassLevel = grass.randomizeGrassLevel(0, 4);
//		board[i][j] = "    " + grass.setGrassLevel(grassLevel) + "    ";
		
		for(testGrass g : getGrassArray())
		{
			x = setLocation(1, columnLimit);
			y = setLocation(1, rowLimit);
			while(board[x][y].contains("T"))
			{
				x = setLocation(1, columnLimit);
				y = setLocation(1, rowLimit);
			}
			g.setX(x);
			g.setY(y);
		}
		
		for(testGrass g : getGrassArray())
		{
			x = g.getX();
			y = g.getY();
			grassLevel = grass.randomizeGrassLevel(0, 4);
			g.setGrassLevel(grassLevel);
			if(!(board[x][y].contains("S")) && !(board[x][y].contains("W")) && !(board[x][y].contains("T")))
			{
				board[x][y] = "    " + g.getGrassLevel() + "    ";
			}
		}
	}
	
	/**
	 * Gets the sheep located a specific index in the arraylist
	 * @param index the index of the sheep
	 * @return the sheep object
	 */
	public TestSheep getSheepObject(int index)
	{
		return sheep.get(index);
	}
	
	/**
	 * Gets the size or amount of sheep objects in the arraylist
	 * @return amount of sheep in the list
	 */
	public int getSheepArraySize()
	{
		return sheep.size();
	}
	
	public int setLocation(int min, int max)
	{
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}
	
	/**
	 * Add a new wolf object
	 * @param wolf
	 */
	public void setWolfArray()
	{
		this.wolves.add(new TestWolf());
	}
	
	/**
	 * Add a new tree object
	 * @param tree
	 */
	public void setTreeArray()
	{
		this.tree.add(new testTree());
	}
	
	/**
	 * Add new grass object
	 * @param grass
	 */
	public void setGrassArray()
	{
		this.grass.add(new testGrass());
	}
	
	/**
	 * Add new sheep object
	 * @param sheep
	 */
	public void setSheepArray()
	{
		this.sheep.add(new TestSheep());
	}
	
	/**
	 * returns sheep arraylist
	 * @return
	 */
	public ArrayList<TestSheep> getSheepArray()
	{
		return this.sheep;
	}
	
	/**
	 * Returns wolf arraylist
	 * @return
	 */
	public ArrayList<TestWolf> getWolfArray()
	{
		return this.wolves;
	}
	
	/**
	 * Returns tree arraylist
	 * @return
	 */
	public ArrayList<testTree> getTreeArray()
	{
		return this.tree;
	}
	
	public ArrayList<testGrass> getGrassArray()
	{
		return  this.grass;
	}
	
	/**
	 * Get the number of sheep specified in the config file
	 * @return
	 */
	public int getNumberOfSheep()
	{
		return numberOfSheep;
	}
	
	/**
	 * Get the number of wolves specified in the config file
	 * @return
	 */
	public int getNumberOfWolves()
	{
		return numberOfWolves;
	}
	
	/**
	 * Get number of trees specified in the config file
	 * @return
	 */
	public int getNumberOfTrees()
	{
		return numberOfTrees;
	}
	
	/**
	 * Get amount of rows of the board
	 * @return
	 */
	public int getRow()
	{
		return this.row;
	}
	
	/**
	 * Get amount of columns in the board
	 * @return
	 */
	public int getColumn()
	{
		return this.column;
	}
	
	
//	public void fillBoard()
//	{
//		for(int row = 0; row < getRow(); row++)
//		{
//			for(int column = 0; column < getColumn(); column++)
//			{
//				board[row][column] = "[      ]";
//			}
//		}
//	}
	
	/**
	 * Displays the board
	 */
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
	
	public void updatedBoard()
	{
		setAutomaticBoard();
		setBoardFence();
		
		int x = 0, y = 0;
		int grassToGrow = 0;
		int min = 0;
		int max = 3;

		//Put sheep in board
		for(TestSheep s : getSheepArray())
		{
			if(s.checkLife() == false)
			{
				sheep.remove(s);
			} else
			{
				x = s.getX();
				y = s.getY();
				this.board[x][y] = "    " + s.getSymbol() + "    ";
			}
		}
		
		//Put wolves on board
		for(TestWolf w : getWolfArray())
		{
			x = w.getX();
			y = w.getY();
			this.board[x][y] = "    " + w.getSymbol() + "    ";
		}
		
		//Put trees on the board
		for(testTree t : getTreeArray())
		{
			x = t.getX();
			y = t.getY();
			this.board[x][y] = "    " + t.getSymbol() + "    ";
		}
		
		grassToGrow = (int)(Math.random() * (max - min) + min);
		//Alternate grass
		for(testGrass g : getGrassArray()){
			if(g.getGrassLevel() == grassToGrow)
			{
				g.increaseGrassLevel();
				x = g.getX();
				y = g.getY();
				if(!(this.board[x][y].contains("S")) && !(this.board[x][y].contains("W")) && !(this.board[x][y].contains("T")))
				{
					this.board[x][y] = "    " + g.getGrassLevel() + "    ";
				}
			}
		}
		
		for(testGrass g : getGrassArray())
		{
			x = g.getX();
			y = g.getY();
			if(!(this.board[x][y].contains("S")) && !(this.board[x][y].contains("W")) && !(this.board[x][y].contains("T")))
			{
				this.board[x][y] = "    " + g.getGrassLevel() + "    ";
			}
		}
	}
//	public void updateBoard()
//	{
//		for(TestSheep s : getSheepArray())
//		{
//			int x = s.getX();
//			int y = s.getY();
//			board[x][y] = "[   S   ]";
//		}
//
//	}
	
	public String getCurrentStatus(int x, int y)
	{
		String status = board[x][y];
		return status;
	}
}
