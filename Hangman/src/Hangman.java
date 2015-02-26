import java.util.*;
public class Hangman
{
	public static int count1 = 0;
	public static void don()
	{
		char c;
		StringBuilder s1 = new StringBuilder("***********");
		String[] words = {"computer","science","master","java","object","oriented","technology"};
		Random r1 = new Random();
		int n = r1.nextInt(7);
		String str = words[n];
		System.out.print("(Guess) Enter a letter in word: ");
		for(int j = 0; j < str.length(); j++)
			if(j != (str.length() - 1))
				System.out.print("*");
			else
				System.out.print("* : ");
		Scanner input = new Scanner(System.in);
		c = input.nextLine().charAt(0);
		did(str,s1,c);
		System.out.println("Do you want to guess for another word? Enter y or n>");
		//Scanner input = new Scanner(System.in);
		char c3 = input.nextLine().charAt(0);
		if(c3 == 'y' || c3 == 'Y')
		{
			Hangman.count1 = 0;
			don();
		}
		else
			System.exit(0);
	}
	public static void did(String s, StringBuilder s1,char c1)
	{
		int count = 0;
		for(int k = 0; k < s.length(); k++)
		{
			if(s.charAt(k) == c1)
			{
				count++;
			}
		}
		if(count != 0)
			{
				System.out.print("(Guess) Enter a letter in word: ");
				for(int j = 0; j < s.length(); j++)
				{
					if(s.charAt(j) == c1)
					{
						s1.setCharAt((s.indexOf(c1,j)) , c1);
					}
				}
				prnt(s,s1);
			}
			else
			{
				System.out.println(c1+ " is not in the word");
				Hangman.count1++;
				System.out.print("(Guess) Enter a letter in word: ");
				prnt(s,s1);
			}
		
	}
	public static void prnt(String s,StringBuilder s1)
	{
		if(s.equals(s1.substring(0, s.length())))
		{
			System.out.println("The word is : " +s+ ". You have missed " +Hangman.count1+ ((Hangman.count1 > 1) ? " times " : " time "));
		}
		else
		{
		for(int j = 0; j < s.length(); j++)
		{
			if(Character.isLetter(s1.charAt(j)))
			{
				if(j != (s.length() - 1))
					System.out.print(s1.charAt(j));
				else
					System.out.print(s1.charAt(j)+ " : ");
			}
			else
			{
				if(j != (s.length() - 1))
					System.out.print("*");
				else
					System.out.print("* : ");
			}
		}
		Scanner input = new Scanner(System.in);
		char c2 = input.nextLine().charAt(0);
		did(s,s1,c2);
		}
	}
	public static void main(String[] args)
	{
		don();
	}
}
