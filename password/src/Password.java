
import java.util.Scanner;

public class Password
{
	String pwd = new String();
	public static boolean validatePWD(String pwd)
	{
		boolean i = true,j,l,m;
		if((j = vSize(pwd)) && (l = vLD(pwd)) && (m = v2D(pwd)))
		{
			i = true;
		}
		else
		{
			i = false;
		}
		return i;
	}
	public static boolean vSize(String pwd)
	{
		boolean i = true;
		if(pwd.length() >= 8)
		{
			i = true;
		}
		else
		{
			i = false;
			System.out.println("The password must have atleast 8 characters, Invalid password.");
		}
		return i;
	}
	public static boolean vLD(String pwd)
	{
		boolean i = true;
		int j = pwd.length();
		for(int k = 0; k < j; k++)
		{
			if((pwd.charAt(k) >= '0' && pwd.charAt(k) <= '9') || (pwd.charAt(k) >= 'A' && pwd.charAt(k) <= 'Z') || (pwd.charAt(k) >= 'a' && pwd.charAt(k) <= 'z'))
			{
				i = true;
			}
			else
			{
				i = false;
			}
		}
		if(!i) System.out.println("The password must have only digits and letters, Invalid password.");
		return i;
	}
	public static boolean v2D(String pwd)
	{
		boolean i = true;
		int j = pwd.length(), count = 0;
		for(int k = 0; k < j; k++)
		{
			if((pwd.charAt(k) >= '0' && pwd.charAt(k) <= '9'))
			{
				count++;
			}
		}
		if(count >= 2)
		{
			i = true;
		}
		else
		{
			i = false;
			System.out.println("The password must have atleast 2 digits, Invalid password.");
		}
		return i;
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Hello! Please enter the password you want to set: ");
		String str = input.nextLine();
		boolean k = validatePWD(str);
		if(k)
		{
			System.out.println("The Password you entered is Valid password and is accepted as: " +str);
		}
		else
		{
			System.out.println("The password you entered is Invalid. Kindly try again...");
		}
	}
}
