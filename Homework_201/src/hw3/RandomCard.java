package hw3;

import java.util.Random;

public class RandomCard 
{
	public static void main(String args[])
	{
		String rankStr = "", suitStr = "";
		Random random = new Random();
		int rank = random.nextInt(13);
		int suit = random.nextInt(4);
		
		if(rank == 0 || rank == 10 || rank == 11 || rank == 12)
		{
			switch(rank)
			{
				case 0 : rankStr = "Ace";break;
				case 10 : rankStr = "Jack";break;
				case 11 : rankStr = "Queen";break;
				case 12 : rankStr = "King";break;
			}
		}
		else
		{
			rankStr = String.valueOf(rank);
		}
		
		switch(suit)
		{
			case 0: suitStr = "Clubs";break;
			case 1: suitStr = "Diamonds";break;
			case 2: suitStr = "Hearts";break;
			case 3: suitStr = "Spades";break;
		}
		
		System.out.println("The card you picked is "+rankStr+" of "+suitStr+".");
		
	}
}
