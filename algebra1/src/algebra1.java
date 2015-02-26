import java.io.*;

public class Algebra
{
	private double a,b,c,d,e,f;
	
	public Algebra(double a1, double b1, double c1, double d1, double e1, double f1)
	{
		this.a = a1;
		this.b = b1;
		this.c = c1;
		this.d = d1;
		this.e = e1;
		this.f = f1;
	}
	public double getA()
	{
		return this.a;
	}
	public double getB()
	{
		return this.b;
	}
	public double getC()
	{
		return this.c;
	}
	public double getD()
	{
		return this.d;
	}
	public double getE()
	{
		return this.e;
	}
	public double getF()
	{
		return this.f;
	}
	public boolean isSolvable()
	{
		boolean i;
		return this.denom() == 0 ? false : true; 
	}
	public double denom()
	{
		return denom = (a * d) - (b * c);
	}
	public double getX()
	{
		double x;
		return x = ((e * d) - (b * f)) / denom();
	}
	public double getY()
	{
		double y;
		return y = ((a * f) - (e * c)) / denom();
	}
	public static void main()
	{
		Algebra al = new Algebra(2,3,4,5,6,7);
		System.out.println("The value of X for the values a= " +al.getA()+ ", b= " +al.getB()+ ", c= " +al.getC()+ ", d= " +al.getD()+ ", e= " +al.getE()+ ", f= " +al.getF()+ "is: " +getX());
		System.out.println("The value of Y for the values a= " +al.getA()+ ", b= " +al.getB()+ ", c= " +al.getC()+ ", d= " +al.getD()+ ", e= " +al.getE()+ ", f= " +al.getF()+ "is: " +getY());
	}
}
