import java.util.Scanner;

public class PhoneKeypad 
{
	public static int getNumber(char uppercaseLetter)
	{
		int n, j = 0;
		n = (int)(uppercaseLetter);
		int i = n - 'A';
		if(i == 0 || i == 1 || i == 2)
		{ 
			return j = 2; 
		}
		else
		
			if(i == 3 || i == 4 || i == 5)
				return j = 3;
		
		else
		
			if(i == 6 || i == 7 || i == 8)
				return j = 4;
		
		else
		
			if(i == 9 || i == 10 || i == 11)
				return j = 5;
		
		else
		
			if(i == 13 || i == 14 || i == 12)
				return j = 6;
		
		else
		
			if(i == 15 || i == 16 || i == 17 || i == 18)
				return j = 7;
		
		else
		
			if(i == 19 || i == 21 || i == 20)
				return j = 8;
		
		else
		
			if(i == 22 || i == 24 || i == 23 || i == 25)
				return j = 9;
		
		return n;
		
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String phno1 = input.nextLine();
		String phno = phno1.toUpperCase();
		for(int i = 0; i <= phno.length() - 1; i++)
		{
			int n = getNumber(phno.charAt(i));
			if(phno.charAt(i) >= '0' && phno.charAt(i) <= '9' )
			{
				System.out.print(phno.charAt(i));
			}
			else
			if(n >= 0 && n <= 9)
				System.out.print(n);
			
				
		}		
	}
}
