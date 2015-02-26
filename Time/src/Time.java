public class Time
{
	public long hour,minute,second,elaps;
	
	public Time()
	{
			// Obtain the total milliseconds since midnight, Jan 1, 1970
			long totalMilliseconds = System.currentTimeMillis();
			// Obtain the total seconds since midnight, Jan 1, 1970
			long totalSeconds = totalMilliseconds / 1000;
			// Compute the current second in the minute in the hour
			this.second = (int)(totalSeconds % 60);
			// Obtain the total minutes
			long totalMinutes = totalSeconds / 60;
			// Compute the current minute in the hour
			this.minute = totalMinutes % 60;
			// Obtain the total hours
			long totalHours = totalMinutes / 60;
			// Compute the current hour
			this.hour = totalHours % 24;
	}
	public Time(long elaps)
	{
		this.elaps = elaps;
		//Sets the total milliseconds to elapsedTime
		long totalMilliseconds = elaps;
		// Obtain the total seconds using elapsedTime
		long totalSeconds = totalMilliseconds / 1000;
		// Compute the current second in the minute in the hour
		this.second = (int)(totalSeconds % 60);
		// Obtain the total minutes
		long totalMinutes = totalSeconds / 60;
		// Compute the current minute in the hour
		this.minute = totalMinutes % 60;
		// Obtain the total hours
		long totalHours = totalMinutes / 60;
		// Compute the current hour
		this.hour = totalHours % 24;
	}
	public Time(int hour, int minute, int second)
	{
		if(hour >= 0 && hour < 24)
		this.hour = hour;
		else
			System.out.println("The time you entered is wrong");
		if(hour >= 0 && hour < 60)
		this.minute = minute;
		else
			System.out.println("The time you entered is wrong");
		if(hour >= 0 && hour < 60)
		this.second = second;
		else
			System.out.println("The time you entered is wrong");
	}
	public long getHours()
	{
		return this.hour;
	}
	public long getMinutes()
	{
		
		return this.minute;
		
	}
	public long getSeconds()
	{
		return this.second;
	}
	public static void main(String args[])
	{
		Time time = new Time();
		Time time1 = new Time(555550000);
		Time time2 = new Time(10,21,35);
		System.out.println("Current time is " + time.hour + ":" + time.minute + ":" + time.second + " GMT");
		System.out.println("The time with given elapsed time " +time1.elaps+ " is " + time1.hour + ":" + time1.minute + ":" + time1.second + " GMT");
		System.out.println("The time with given hours: " +time2.hour+ " , minutes: " +time2.minute+ " and seconds: " +time2.second+ " is " + time2.hour + ":" + time2.minute + ":" + time2.second + " GMT");
	}
}
