package edu.calstatela.cs202.gala.RancherGame;
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
		
		tc.printAllKeys();
		System.out.println();
		tc.printAllVals();
		
		TestBoard tb = new TestBoard();
		tb.setBoardDimensions(tc);
		tb.fillBoard();
		tb.setGameDifficulty(tc);
		tb.setLife(tc);
		tb.displayBoard();
		
		System.out.println("Amount of sheep is: " +  tb.numberOfSheep);
		System.out.println("Amount of wolves is: " +  tb.numberOfWolves);
		System.out.println("Amount of trees is: " +  tb.numberOfTrees);
		System.out.println("The diagonalMove is: " +  tb.diagonalMove);
		System.out.println("The difficulty is: " +  tb.difficulty);
		System.out.println("The row of the board is: " + tb.row);
		System.out.println("The column of the board is: " + tb.column);
	}
}