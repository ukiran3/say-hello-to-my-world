import java.util.*;
public class SplitStr
{
	public static String[] split(String s, String reg)
	{
	
		String[] arr = new String[40];
		String[] arr0 = s.split(reg);
		if(reg.charAt(0) != '[')
		for(int i = 0; i < arr0.length; i++)
		{
			arr[2 * i] = arr0[i];
			if(i != arr0.length - 1)
			arr[(2 * i) + 1] = reg;
		}		
		else
		{
			for(int i = 0; i < arr0.length; i++)
			{
				arr[2 * i] = arr0[i];
				arr[(2 * i) + 1] = String.valueOf(reg.charAt(1));
			}
		}
		return arr;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your string: ");
		String str = input.nextLine();
		System.out.println("Enter the regex string: ");
		String reg = input.nextLine();
		String[] spl = split(str,reg);
		
		
		System.out.println("The array of strings: ");
		for(int i = 0; i< spl.length; i++)
		{
			if(i != spl.length - 1)
				if(spl[i] != null)
				System.out.print(spl[i]+ "  ");
			else
				if(spl[i] != null)
				System.out.print(spl[i]+ " ");
		}
	}
}
