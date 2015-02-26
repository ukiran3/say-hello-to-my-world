import java.io.*;
import java.util.Scanner;

public class RemovingText
{

	public static void main(String[] args) throws Exception
	{

		File file=new File("D:/text.txt");
		Scanner input1 = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(file);
		pw.print("hello world!");
		pw.close();
		System.out.print("Enter the String you are looking to remove = ");
		String str = input1.next();
		Scanner input2 = new Scanner(file);
		PrintWriter pwriter=new PrintWriter("D:/textAfterRemove.txt");
		while(input2.hasNext())
		{
			String word = input2.next();
			
			if(str.equals(word))
			{
				String string = word.replace(word,"");
				pwriter.print(string);
			}
			else
				pwriter.println(word);
		}
		input2.close();
		pwriter.close();
	}
}



