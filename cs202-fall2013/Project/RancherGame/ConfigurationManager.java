package edu.calstatela.cs202.gala.RancherGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConfigurationManager {

	private ArrayList<String> parameterName; //The parameter names
	private ArrayList<String> parameterValue; //The parameter values
	private String mode; //Easy or hard mode
	private boolean diagonalMove; //Determines if diagonalMove is legal
	private int manualOrAutomatic; //0 = manual; 1 = automatic
	
	public ConfigurationManager()
	{
		parameterName = new ArrayList<String>();
		parameterValue = new ArrayList<String>();
		mode = null;
		diagonalMove = false;
		manualOrAutomatic = -1;
	}

	public void setParameterName(String nextLine) 
	{
		int index = 0; //Use this to find the first digit of the line
		String description = null;
		
		//First check if line is a comment
		if((String.valueOf(nextLine.charAt(0))).equals("/"))
		{
			return;
		} 

		
		
		while(!Character.isDigit(nextLine.charAt(index))) //While character is not a digit at this index
		{
			if (index == 10)
			{
				if(Character.isLetter(nextLine.charAt(index)))
				{
					index = 0;
				}
			}
			System.out.println("Index was: " + index);
			index++;
			System.out.println("Index is now: " + index);
			
		}
		
		int ending = index - 1; //Use this to find the last letter of the word of the scanned line
		while(Character.isWhitespace(nextLine.charAt(ending)))
		{
			ending--;
		}
		
		description = nextLine.substring(0, ending + 1); //Extract parameter name
		
		parameterName.add(description);
	}

	public void setParameterValue(String nextLine) {
		// TODO Auto-generated method stub
		
	}
	
	public void setManualAutomatic()
	{
		Scanner userInput = new Scanner(System.in);
		String halfway = userInput.nextLine();
		try
		{
			int userChoice = Integer.parseInt(halfway);
			
			while (userChoice < 0 || userChoice > 1)
			{
				System.out.println("Invalid input, please enter either a 0 or 1: ");
				userChoice = userInput.nextInt();
			}
			
			manualOrAutomatic = userChoice;
		} catch(NumberFormatException e)
		{
			System.out.println("Invalid input, please enter either a 0 or 1");
		}
	}
	
	public int getManualAutomatic()
	{
		return manualOrAutomatic;
	}
}
