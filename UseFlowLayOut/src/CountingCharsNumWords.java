import java.io.*;

class CountChar 
{
	public static void main(String args[])
	{
		try{

			FileInputStream file = new FileInputStream("D:/hello.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(file));
			String str;
			int countWords = 0;
			int countLetter = 0;
			int countLines = 0;

			while ((str = br.readLine())!= null)   
			{
				countLines++;
				int length=str.length();
				for(int i = 0;i < length; i++)
				{
					countLetter++;
					if(Character.isWhitespace(str.charAt(i)))
						countWords++;
				}
			}
			System.out.println ("Numbers of lines are "+countLines);
			System.out.println ("Numbers of Character are "+countLetter);
			System.out.println ("Numbers of Words are "+(countWords+countLines));
			br.close();
		}

		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}
