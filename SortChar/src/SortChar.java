import java.util.*;

public class SortChar
{
	public static String sort(String str)
	{
		char temp;
		char sort1[] = new char[20];
		for(int k = 0; k < str.length(); k++)
		{
				sort1[k] = str.charAt(k);
		}
		for(int i = 0; i < str.length(); i++)
		{
			for(int j = i + 1; j < str.length(); j++)
			{
				if(sort1[i] > sort1[j])
				{
					temp = sort1[j];
					sort1[j] = sort1[i];
					sort1[i] = temp;
				}
			}
		}
		String sorted = new String();
		sorted = String.valueOf(sort1);
		return sorted;
	}
	public static void main(String[] args)
	{
		String str1 = new String();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your string: ");
		str1 = input.nextLine();
		System.out.println("The string is: " +str1);
		System.out.println("The sorted string is: " +sort(str1));
	}
}
