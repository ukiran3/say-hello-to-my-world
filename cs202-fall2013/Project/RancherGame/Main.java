package edu.calstatela.cs202.gala.RancherGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.calstatela.cs202.gala.hw3.Grass;
import edu.calstatela.cs202.gala.hw3.Tree;

public class Main {

	public static void main(String[] args) {
		//Open the configuration file
		ConfigurationManager cm = new ConfigurationManager();
		
		try
		{
			Scanner configFile = new Scanner(new File("config.txt"));
			
			//While there is another line, read from the configuration file
			while(configFile.hasNextLine())
			{
				cm.setParameterName(configFile.nextLine());
				cm.setParameterValue(configFile.nextLine());
			}
		} catch(FileNotFoundException error)
		{
			error.getMessage();
			error.getStackTrace();
		}

		//Create the objects for the game
		Board board = new Board();
		Grass grass = new Grass();
		Tree tree = new Tree(board.getRow(),board.getColumn());
		Wolf wolves = new Wolf(board.getRow(),board.getColumn());
		Sheep sheep = new Sheep();
		//TurnCounter timer = new TurnCounter();
		//Get Player name
		System.out.println("Enter your name: ");
		Scanner userInput = new Scanner(System.in);
		String userName = userInput.nextLine();
		Player player = new Player(userName);
		
		if(cm.getManualAutomatic() == -1)
		{
			System.out.println("Enter 0 for manual set-up or 1 for automatic set-up: ");
			cm.setManualAutomatic();
		} else if (cm.getManualAutomatic() == 0) //Manual set-up
		{
			
		} else if (cm.getManualAutomatic() == 1) //Automatic set-up
		{
			
		}
	}

}
