package hw3;

	import java.util.*;
	class main1
	{
	public static void main(String args[])
	{
	int a=0,b=0,c=0,d=0,e=0,f=0,r=0;
	float x=0,y=0;
	Scanner sr=new Scanner(System.in);
	System.out.println(" A 2*2 sytem of linear equations:");
	System.out.println("ax+by=e\tcx+dy=f"); 
	System.out.println("Enter 'a' value");
	a=sr.nextInt();
	System.out.println("Enter 'b' value");
	b=sr.nextInt();
	System.out.println("Enter 'c' value");
	c=sr.nextInt();
	System.out.println("Enter 'd' value");
	d=sr.nextInt();
	System.out.println("Enter 'e' value");
	e=sr.nextInt();
	System.out.println("Enter 'f' value");
	f=sr.nextInt();
	r=(a*d)-(b*c);
	if(r==0)
	{
	System.out.println("The equation has no solution");
	}
	else
	{
	x=((e*d)-(b*f))/r;
	y=((a*f)-(e*c))/r;

	System.out.println("x value is:\t"+ x);
	System.out.println("y value is: \t" + y);
	}
	}
	}


}

