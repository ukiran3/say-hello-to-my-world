public class Myinteger
{
	public static int value = 10;
	
	public Myinteger(int value)
	{
		this.value = value;
	}
	public Myinteger()
	{
		this(value);
	}
	public int getValue()
	{
		return value;
	}
	public boolean isEven()
	{
		boolean j = true;
		if(value % 2 == 0)
		return j;
		else
			return !j;
	}
	public boolean isOdd()
	{
		boolean j = true;
		if(value % 2 != 0)
		return j;
		else
			return !j;
	}
	public boolean isPrime()
	{
		int count = 0;
		boolean j = true;
		for(int i = 2 ; i < value / 2; i++)
		{
			if(value % i == 0)
				count++;
		}
		if(count != 0)
			return !j;
		else
			return j;
			
	}

	public static boolean isEven(int m)
	{
		boolean j = true;
		if(m % 2 == 0)
		return j;
		else
			return !j;
	}
	public static boolean isOdd(int m)
	{
		boolean j = true;
		if(m % 2 != 0)
		return j;
		else
			return !j;
	}

	
	public static boolean isPrime(int m)
	{
		int count = 0;
		boolean j = true;
		for(int i = 2 ; i < m / 2; i++)
		{
			if(m % i == 0)
				count++;
		}
		if(count != 0)
			return !j;
		else
			return j;		
	}
	
	public static boolean isEven(Myinteger m)
	{
		boolean j = true;
		if(m.value % 2 == 0)
		return j;
		else
			return !j;
	}
	public static boolean isOdd(Myinteger m)
	{
		boolean j = true;
		if(m.value % 2 != 0)
		return j;
		else
			return !j;
	}
	public static boolean isPrime(Myinteger m)
	{
		int count = 0;
		boolean j = true;
		for(int i = 2 ; i < m.value / 2; i++)
		{
			if(m.value % i == 0)
				count++;
		}
		if(count != 0)
			return !j;
		else
			return j;		
	}
	
	public boolean equals(int val)
	{
		boolean j = true;
		if(val == value)
		return j;
		else
			return !j;
	}
	public boolean equals(Myinteger m)
	{
		boolean j = true;
		if(m.value == value)
		return j;
		else
			return !j;
	}
	public static int[] parseInt(char[] ch)
	{
		int arr[] = new int[20];
		for(int k = 0; k < ch.length; k++)
			arr[k] = (int)ch[k];
		return arr;
	}
	public static int[] parseInt(String ch)
	{
		int arr[] = new int[20];
		for(int k = 0; k < ch.length(); k++)
			arr[k] = (int)ch.charAt(k);
		return arr;

	}
	public static void main(String args[])
	{
		
		Myinteger mi = new Myinteger(20);
		Myinteger mi1 = new Myinteger(11);
		System.out.println("The value is: " +mi.getValue()+ " is Odd? " +mi.isOdd());
		System.out.println("The value is: " +mi.getValue()+ " is Even? " +mi.isEven());
		System.out.println("The value is: " +mi.getValue()+ " is Prime? " +mi.isPrime(mi1));
		System.out.println("The values " +mi.getValue()+ " and "+ mi1.getValue()+ " are equal? " + ((mi.equals(mi1))? "true" : "false"));
	}
}
