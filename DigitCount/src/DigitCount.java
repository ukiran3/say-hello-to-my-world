import java.util.*;
import java.lang.Character;
public class DigitCount
{
	public static int[] count(String str)
	{
		int[] countD = new int[10];
		for(int i = 0; i < str.length(); i++)
		{
			if(Character.isDigit(str.charAt(i)))
				countD[str.charAt(i) - '0']++;
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
		int counts[] = count(str);
		for(int i = 0; i < counts.length; i++)
		{
			if(counts[i] != 0)
			System.out.println("Number of times " +(char)('0' + i)+ " appears is: " +counts[i] + ((counts[i] > 1) ? " times " : " time "));
		}
	}
}
