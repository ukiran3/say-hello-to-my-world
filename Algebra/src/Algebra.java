import java.util.Scanner;
public class Algebra
{
	
	Scanner input = new Scanner(System.in);
	
	
	
	private double a = getA();
	private double b = getB();
	private double c = getC();
	private double d = getD();
	private double e = getE();
	private double f = getF();
	public Algebra()
	{
		
	}
	public Algebra(double a1, double b1, double c1, double d1, double e1, double f1)
	{
		a = a1;
		b = b1;
		c = c1;
		d = d1;
		e = e1;
		f = f1;
	}
	public double getA()
	{
		System.out.println("Enter value for a: ");
		int a = input.nextInt();
		return a;
	}
	public double getB()
	{
		System.out.println("Enter value for b: ");
		int b = input.nextInt();
		return b;
	}
	public double getC()
	{
		System.out.println("Enter value for c: ");
		int c = input.nextInt();
		return c;
	}
	public double getD()
	{
		System.out.println("Enter value for d: ");
		int d = input.nextInt();
		return d;
	}
	public double getE()
	{
		System.out.println("Enter value for e: ");
		int e = input.nextInt();
		return e;
	}
	public double getF()
	{
		System.out.println("Enter value for f: ");
		int f = input.nextInt();
		return f;
	}
	public boolean isSolvable()
	{
		boolean i;
		if(denom() == 0)
			i = false;
		else
			i = true;
		
		return i; 
	}
	public double denom()
	{
		double denom;
		denom = ((a * d) - (b * c));
		return denom;
	}
	public double getX()
	{
		double x;
		x = ((e * d) - (b * f) / denom());
		return  x;
	}
	public double getY()
	{
		double y;
		y = ((a * f) - (e * c) / denom());
		return  y;
	}
	public static void main(String args[])
	{
		
		//Algebra al = new Algebra(2,3,4,5,6,7);
		Algebra al = new Algebra();
		boolean k = al.isSolvable();
		if(k)
		{
			System.out.println("The Equations are: " +al.a+ " X + " +al.b+ " Y = " +al.e);
			System.out.println("The Equations are: " +al.c+ " X + " +al.d+ " Y = " +al.f);
			System.out.println("The value of X for the values a= " +al.a+ ", b= " +al.b+ ", c= " +al.c+ ", d= " +al.d+ ", e= " +al.e+ ", f= " +al.f+ " is: " +al.getX());
			System.out.println("The value of Y for the values a= " +al.a+ ", b= " +al.b+ ", c= " +al.c+ ", d= " +al.d+ ", e= " +al.e+ ", f= " +al.f+ " is: " +al.getY());
		}
		else
		{
			System.out.println(" The equation has no solution ");
		}
	}
}
