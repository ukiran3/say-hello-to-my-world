
public class date1
{
	public static void main(String args[])
	{
		long elaps = 1000;
		java.util.Date date = new java.util.Date();
		System.out.println("The elapsed time since Jan 1st 1970 is:" +date.getTime()+ "milliseconds");
		System.out.println(date.toString());
		for(int i = 4; i < 12; i++)
		{
			elaps = elaps * 10;
			date.setTime(elaps);
			System.out.println("The date for the new elapsed time " +date.getTime()+ " milliseconds is: " +date.toString());
		}
		
		
	}
	
}
//date.setTime(Elaps);
		//System.out.println("The date for the new elapsed time " +date.getTime()+ "milliseconds is:" +date.toString());
		//date.setTime(100000000000);
		//System.out.println("The date for the new elapsed time " +date.getTime()+ "milliseconds is:" +date.toString());
		