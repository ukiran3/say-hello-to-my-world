package hw3;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor 
{
	static int u_input, cmp_ran_num;
	
	private static int read_put() 
	{
		
		Scanner input = new Scanner(System.in);
		int r_inp = input.nextInt();
		return r_inp;
	}
	
	private static int winningNum(int u_input2, int cmp_ran_num2) 
	{
		int dup = -1;
		
		if(u_input2 == 0)
		{
			if(cmp_ran_num2 == 1)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		if(u_input2 == 1)
		{
			if(cmp_ran_num2 == 0)
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		if(u_input2 == 2)
		{
			if(cmp_ran_num2 == 0)
			{
				return 0;
			}
			else
			{
				return 2;
			}
		}
		return dup;
	}
	
	public static void main(String args[])
	{
		System.out.println("Please enter a number between 0 and 2");
		u_input = read_put();
		
		System.out.println("Your input is: "+u_input);
		switch(u_input)
		{
		case 0 : System.out.println("Rock \n"
				+ "          _______\n"
				+ "      ---'   ____)\n"
				+ "            (_____)\n"
				+ "            (_____)\n"
				+ "            (____)\n"
				+ "      ---.__(___)");
				break;
		case 1 : System.out.println("Paper \n"
				+ "          _______\n"
				+ "      ---'   ____)____\n"
				+ "                ______)\n"
				+ "                _______)\n"
				+ "              _______)\n"
				+ "      ---.__________)");
		break;
			case 2: System.out.println("Scissors \n"
					+ "    _______\n"+
      "---'   ____)____\n"+
      "          ______)\n"+
      "      __________)\n"+
      "     (____)\n"+
      "---.__(___)");
			break;
		}
		Random rand = new Random();
		cmp_ran_num = rand.nextInt(3);
		System.out.println("My random number is: "+cmp_ran_num);
		switch(cmp_ran_num)
		{
			case 0 : System.out.println("Rock \n"
					+ "          _______\n"
					+ "      ---'   ____)\n"
					+ "            (_____)\n"
					+ "            (_____)\n"
					+ "            (____)\n"
					+ "      ---.__(___)");
			break;
			case 1 : System.out.println("Paper \n"
					+ "          _______\n"
					+ "      ---'   ____)____\n"
					+ "                ______)\n"
					+ "                _______)\n"
					+ "              _______)\n"
					+ "      ---.__________)");
			break;
			case 2: System.out.println("Scissors \n"
					+ "    _______\n"+
      "---'   ____)____\n"+
      "          ______)\n"+
      "      __________)\n"+
      "     (____)\n"+
      "---.__(___)");
			break;
		}
		if(u_input > 2 && u_input < 0)
		{
			System.out.println("Your input is invalid. Please try again!");
		}
		else
		{
			if(u_input == cmp_ran_num)
			{
				System.out.println("Its a draw");
			}
			else
			{
				int win_num = winningNum(u_input, cmp_ran_num);
				if(win_num == u_input)
				{
					System.out.println("You win!");
				}
				else
				{
					System.out.println("I won!");
				}
			}
		}
	}
}
//http://www.retrojunkie.com/asciiart/health/hands.htm1
