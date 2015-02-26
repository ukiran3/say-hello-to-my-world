package edu.calstatela.cs202.gala.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		
		//Create an object of TestConfig
		TestConfig tc = new TestConfig();
		
		//Read the config file
		try {
			tc.read("config.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		tc.printAllKeys();
//		System.out.println();
//		tc.printAllVals();
		
		TestBoard tb = new TestBoard();
		TestSheep sheep = new TestSheep();
		
		tb.setBoardDimensions(tc);
		tb.fillBoard();
		tb.setGameDifficulty(tc);
		tb.setLife(tc, sheep);
		
//		TestSheep s1 = new TestSheep();
//		TestSheep s2 = new TestSheep();
//		TestSheep s3 = new TestSheep();
//		
//		System.out.println("S1: " + s1.getID());
//		System.out.println("S2: " + s2.getID());
//		System.out.println("S3: " + s3.getID());
//		
//		for(TestSheep s : tb.getSheepArray())
//		{
//			System.out.println("This sheep's id is: " + s.getID());
//			System.out.println("This sheep's x-position is: " + s.getX());
//			System.out.println("This sheep's y-position is: " + s.getY());
//			System.out.println();
//		}
		
		tb.displayBoard();
		
		boolean done = false;
		boolean isNum = false;
		String toMove = null;
		String direction = null;
		int chosen = -1, x = -1, y = -1, newX = 1, newY = 1, zero = 0, rowLimt = tb.getRow() - 1, columnLimit = tb.getColumn() - 1;
		Scanner input = new Scanner(System.in);
		
		while(!done)
		{
			System.out.println();
			System.out.println("Welcome to the game, press 'Q' at any time to end the game.");
			System.out.println();
			
			System.out.println("You currently have these sheep: ");
			for(TestSheep s : tb.getSheepArray())
			{
				System.out.println("Sheep: " + s.getID());
			}
			
			System.out.print("Enter the number of the sheep you want to move: ");
			toMove = input.next();
			isNum = tc.isNumeric(toMove);
			System.out.println(isNum);
			
			while(!isNum){
				System.out.print("Enter the number of the sheep you want to move: ");
				toMove = input.next();
				isNum = tc.isNumeric(toMove);
			}
			
			if(isNum)
			{
				chosen = tc.parseToInt(toMove);
			}
			
			System.out.println("Which direction do you want the sheep to move? ");
			System.out.print("Enter either N, S, E, W, X [Stay]: ");
			direction = tc.getDirection();
			
			if(direction.equalsIgnoreCase("N"))
			{
				for(TestSheep s : tb.getSheepArray())
				{
					if(s.getID() == chosen)
					{
						x = s.getX();
						y = s.getY();
						if(y == zero)
						{
							System.out.println("Sheep can't go over  the fence!");
							return;
						}
						System.out.println("Y is: " + y);
						newY = s.moveNorth(x, y);
						System.out.println("New Y is: " + newY);
						s.setY(newY);
					}
				}
			}
			tb.updateBoard();
			tb.displayBoard();
			done = true;
		}
		
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