package edu.calstatela.cs202.gala.project;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	
	public static boolean isValidInput(String input)
	{
		boolean isValid = false;
		if((input.equalsIgnoreCase("N")) || (input.equalsIgnoreCase("S")) || (input.equalsIgnoreCase("E")) || (input.equalsIgnoreCase("W")) || (input.equalsIgnoreCase("Q")) || (input.equalsIgnoreCase("T")))
		{
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean isNumberInput(String input)
	{
		boolean isValid = false;
		int number = 0;
		try
		{
			number = Integer.parseInt(input);
			isValid = true;
		} catch(NumberFormatException e)
		{
		}
		
		return isValid;
	}
	
	public static int parseToInteger(String input)
	{
		int number = 0;
		try
		{
			number = Integer.parseInt(input);
		} catch(NumberFormatException e)
		{
		}
		return number;
	}
	
	public static void main(String args[]) {
		
		//Create an object of TestConfig
		TestConfig tc = new TestConfig();
		
		//Read the config file
		try {
			tc.read("project.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
//		tc.printAllKeys();
//		System.out.println();
//		tc.printAllVals();
		
		TestBoard tb = new TestBoard();
		TestSheep sheep = new TestSheep();
		TestWolf wolf = new TestWolf();
		testGrass grass = new testGrass();
		testTree tree = new testTree();
		Scanner scan = new Scanner(System.in);
		String halfway = null;
		int chosenSheep = 0;
		TestSheep moveSheep = new TestSheep();
		testGrass checkGrass = new testGrass();
		int x = 0, newX = 0;
		int y = 0, newY = 0;
		int moveXOrY = -1;
		String userChoice = null;
		
		tb.setBoardDimensions(tc);
		
		tb.setGameDifficulty(tc);
		tb.setLife(tc, sheep, tree, wolf, grass);
		
		
		if(tb.getGameDifficulty().equalsIgnoreCase("easy"))
		{
			System.out.println("Hello, welcome to the game!");
			do{
				tb.displayBoard();
				System.out.println();
				
				System.out.println("Enter the number of the sheep you want to move, ex: if S1, enter 1: ");
				halfway = scan.nextLine();
				while(!isNumberInput(halfway))
				{
					System.out.print("Please enter a valid number: ");
					halfway = scan.nextLine();
				}
				chosenSheep = parseToInteger(halfway);
				for(TestSheep s : tb.getSheepArray())
				{
					if(s.getID() == chosenSheep)
					{
						moveSheep = s;
					}
				}
				
				x = moveSheep.getX();
				y = moveSheep.getY();
				
				for(testGrass g : tb.getGrassArray())
				{
					if((g.getX() == x) && (g.getY() == y))
					{
						checkGrass = g;
					}
				}
				System.out.println("Getting grass report of current sheep position...");
				System.out.println("Grass level at sheep " + chosenSheep + "'s position is: " + checkGrass.getGrassLevel());
				
				System.out.println();
				
				System.out.println("To move, press either n (north), e (east), s (south), w (west), t (stay), or q (quit)");
				halfway = scan.nextLine();
				while(!isValidInput(halfway))
				{
					System.out.print("Please enter a valid direction: ");
					halfway = scan.nextLine();
				}
				userChoice = halfway;
				
				if(userChoice.equalsIgnoreCase("N"))
				{
					newX = moveSheep.moveNorth(x);
					while(tb.board[newX][y].contains("[]") || tb.board[newX][y].contains("T"))
					{
						System.out.println("Can't move to there");
						break;
					}
					moveSheep.setX(newX);
					System.out.println("You moved north");
					
				} else if(userChoice.equalsIgnoreCase("E"))
				{
					newY = moveSheep.moveEast(y);
					while(tb.board[x][newY].contains("[]") || tb.board[newX][y].contains("T"))
					{
						System.out.println("Can't move to there");
						break;
					}
					moveSheep.setY(newY);
					System.out.println("You moved east");
					
				} else if(userChoice.equalsIgnoreCase("S"))
				{
					newX = moveSheep.moveSouth(x);
					while(tb.board[newX][y].contains("[]") || tb.board[newX][y].contains("T"))
					{
						System.out.println("Can't move to there");
						break;
					}
					moveSheep.setX(newX);
					System.out.println("You moved south");
					
				} else if(userChoice.equalsIgnoreCase("W"))
				{
					newY = moveSheep.moveWest(y);
					while(tb.board[x][newY].contains("[]") || tb.board[newX][y].contains("T"))
					{
						System.out.println("Can't move to there");
						break;
					}
					moveSheep.setY(newY);
					System.out.println("You moved west");
					
				} else if(userChoice.equalsIgnoreCase("T"))
				{
					System.out.println("You'll stay for this turn");
					
				}else if(userChoice.equalsIgnoreCase("Q"))
				{
					System.out.println("Quitting game...");
				}
				
				//Have wolves move
				for(TestWolf w : tb.getWolfArray())
				{
					x = w.getX();
					y = w.getY();
					
					moveXOrY = (int)(Math.random() * (2 - 0) + 0);
					if(moveXOrY == 0) //X
					{
						newX = w.moveRandom(x);
						while(tb.board[newX][y].contains("[ ]"))
						{
							newX = w.moveRandom(x);
						}
						w.setX(newX);
					}else if(moveXOrY == 1) //Y
					{
						newY = w.moveRandom(y);
						while(tb.board[x][newY].contains("[ ]"))
						{
							newY = w.moveRandom(y);
						}
						w.setY(newY);
					}
				}
				
				//Check who is sharing squares
				
				for(TestSheep s : tb.getSheepArray())
				{
					x = s.getX();
					y = s.getY();
					for(TestWolf w : tb.getWolfArray())
					{
						if(tb.board[x][y].contains(s.getSymbol()) && tb.board[x][y].contains(w.getSymbol()))
						{
							s.kill();
						}
					}
					
					for(testGrass g : tb.getGrassArray())
					{
						if(tb.board[x][y].contains(s.getSymbol()) && tb.board[x][y].contains(g.getSymbol()))
						{
							s.setHasEaten();
							g.decreaseGrassLevel();
						}
					}
				}
						
				
				tb.updatedBoard();
				sheep.resetHasEaten();
				
			} while(!userChoice.equalsIgnoreCase("Q"));
		} else if(tb.getGameDifficulty().equalsIgnoreCase("auto"))
		{
			GUI.main(args);
		}
		System.out.println("Quitting here too...");
//		
//		input.close();
//		System.out.println("Size of the sheep array " + tb.sheep.size());
//		System.out.println("Amount of sheep is: " +  tb.numberOfSheep);
//		System.out.println("Amount of wolves is: " +  tb.numberOfWolves);
//		System.out.println("Amount of trees is: " +  tb.numberOfTrees);
//		System.out.println("The diagonalMove is: " +  tb.diagonalMove);
//		System.out.println("The difficulty is: " +  tb.difficulty);
//		System.out.println("The row of the board is: " + tb.row);
//		System.out.println("The column of the board is: " + tb.column);
	}
}