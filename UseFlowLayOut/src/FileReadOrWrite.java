import java.util.*;
import java.io.*;
public class FileReadOrWrite {
	
	public static void main(String[] args) throws Exception {
		
		java.io.File file = new java.io.File("D:/Exercise9_19.txt");
		int values[]=new int[100];
		int index=0;
		if(file.exists())
		{
			//System.out.println("File already exists");

			File readFile = new File("D:/Exercise9_19.txt");
			Scanner input = new Scanner(readFile);

			while (input.hasNext())
			{
				values[index]= input.nextInt();

				index=index+1;
			}
			input.close();
			sort(values);
		}
		else
		{

			PrintWriter output = new PrintWriter(file);
			Random numbers = new Random();
			for (int i = 1; i < 100; i++)
			{
				int num = numbers.nextInt();
				//adds space after each number
				output.print(num+" ");
			}
			output.close();
		}

	}

	public static void sort(int [] values)
	{
		int temp;

		for(int i=1;i<values.length;i++)
		{                  
			for(int k=1;k<values.length-1;k++)
			{
				if(values[k-1]>values[k])
				{
					temp=values[k-1];
					values[k-1]=values[k];
					values[k]=temp;
				}

			}

		} 
		
		System.out.println("The Sorted List of numbers is:");

		for(int i=1;i<values.length;i++)
		{
			System.out.println( values[i]);
		}

	}
}