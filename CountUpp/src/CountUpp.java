import java.util.*;

class CountUpp
{
	public static int count(String str)
	{
		int countD = 0;
		for(int i = 0; i < str.length(); i++)
		{
			if(Character.isUpperCase(str.charAt(i)))
				countD++;
		}	
		return countD;
	}
	public static void main(String[] args)
	{
		String str = new String();
		Scanner input = new Scanner(System.in); 
		System.out.println("Please enter your string: ");
		str = input.nextLine();
		System.out.println("The string is: " +str);
		int counts = count(str);
			if(counts != 0)
			System.out.println("Number of times uppercase letters appears is: " +counts + ((counts > 1) ? " times " : " time "));
	}
}
