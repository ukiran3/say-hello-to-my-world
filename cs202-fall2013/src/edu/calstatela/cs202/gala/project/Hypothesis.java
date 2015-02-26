package edu.calstatela.cs202.gala.project;

import java.util.Scanner;

public class Hypothesis {

	//Testing how to get borders on a 2D array
	public static int row;
	public static int column;
	public static String[][] board;
	public static int answer;
	static Scanner scan = new Scanner(System.in);
	
	public Hypothesis() {
		row = 5;
		column = 5;
		board = new String[row][column];
		answer = -1;
	}
	
	
	
	public static void main(String[] args) {
		//Testing how to get borders on a 2D array
		Hypothesis hp = new Hypothesis();

		String halfway = null;
		
		System.out.print("Just press as directed until you want to quit: ");
		while(answer != 5)
		{
			halfway = scan.next();
			
		}
	}

}
