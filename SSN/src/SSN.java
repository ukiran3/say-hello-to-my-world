import java.util.Scanner;

public class SSN
{
	String str = new String();
	
	public static boolean valuateSSN(String str)
	{
		boolean i = true;
		if(str.length() == 11)
		{
			if(str.charAt(3) == (char)45 && str.charAt(6) == (char)45)
			{
					if((str.charAt(0) >= '0' && str.charAt(0) <= '9') && (str.charAt(1) >= '0' && str.charAt(1) <= '9') && (str.charAt(2) >= '0' && str.charAt(2) <= '9') && (str.charAt(4) >= '0' && str.charAt(4) <= '9') && (str.charAt(5) >= '0' && str.charAt(5) <= '9') && (str.charAt(7) >= '0' && str.charAt(7) <= '9') && (str.charAt(8) >= '0' && str.charAt(8) <= '9') && (str.charAt(9) >= '0' && str.charAt(9) <= '9') && (str.charAt(10) >= '0' && str.charAt(10) <= '9'))
					{
						i = true;
					}
					else
					{
						System.out.println("The SSN you have entered is Invalid...");
						i = false;
					}
				
			}
			else
			{
				System.out.println("The SSN you have entered is Invalid...");
				i = false;
			}
		}
		else
		{
			System.out.println("The SSN you have entered is Invalid...");
			i = false;
		}

		return i;
	}
	
	public static void main(String args[])
	{
		boolean j;
		String str1 = new String("hai");
		System.out.println(str1);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your SSN in the format DDD-DD-DDDD (D is Digit): ");
		String ssn = input.nextLine();
		j = valuateSSN(ssn);
		if(j)
		{
			System.out.println("Your SSN number is Valid and is accepted as: " +ssn);
		}
		else
			
		System.out.println("Your SSN is not accepted, kindly try again...");
	}
}
