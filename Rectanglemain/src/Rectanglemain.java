import java.io.*;

class Rectangle
{
   		private double width=1.0;
		private double height=1.0;
Rectangle()
{
}
Rectangle(double x, double y)
{
	width=x;
	height=y;
}
  	double getArea()
	{
		return (width*height);
	}
	double getParameter()
	{
		return 2 * (width + height);
	}
}


class Rectanglemain
{
public static void main(String args[])
{
Rectangle r1= new Rectangle();
Rectangle r2= new Rectangle(2,3);

		System.out.println("The area of default rectangle is: " +r1.getArea()+ " and perimeter is: " +r1.getParameter());
		System.out.println("The area of rectangle with specified width and height is: " +r2.getArea()+ " and perimeter is: " +r2.getParameter());
   	}
}
