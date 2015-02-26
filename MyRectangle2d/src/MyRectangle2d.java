//import java.util.*;
public class MyRectangle2d
{
	public MyRectangle2d()
	{
		x = 0;
		y = 0;
		width = 1;
		height = 1;
	}
	public MyRectangle2d(double x1,double y1,double width1,double height1)
	{
		x = x1;
		y = y1;
		width = width1;
		height = height1;
	}
	double x,y,width,height;
	public void setWidth(double width1)
	{
		width = width1;
	}
	public void setHeight(double height1)
	{
		height = height1;
	}
	public double getWidth()
	{
		return width;
	}
	public double getHeight()
	{
		return height;
	}
	public void setX(double x1)
	{
		x = x1;
	}
	public void setY(double y1)
	{
		y = y1;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	
	public double getArea()
	{
		return (width * height);
	}
	public double getPerimeter()
	{
		return 2 * (width + height);
	}
	public boolean contains(double x1, double y1)
	{
		boolean torf = false;
		double dist = Math.sqrt(Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
		if(dist <= width/2 && dist <= height/2)
			torf = true;
		return torf;
	}
	public boolean contains(MyRectangle2d r)
	{
		double dist;
		dist = Math.sqrt(((x-r.x)*(x-r.x))-((y-r.y)*(y-r.y)));
		if(dist < (height + r.height))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean overlaps(MyRectangle2d r)
	{
		double dist;
		dist = Math.sqrt(((x - r.x) * (x - r.x)) - ((y - r.y) * (y - r.y)));
		if(dist < (height + r.height)) 
		{
			return true;
		}
		else
			return false;

	} 
	public static void main(String args[])
	{
		MyRectangle2d rect = new MyRectangle2d();
		
		System.out.println("The Rectangle with the values x: " +rect.x+ "and y: " +rect.y+ " and width: " +rect.width+" and height: " +rect.height+ "\n Area is: " +rect.getArea()+ "\n Perimeter is: " +rect.getPerimeter());
		MyRectangle2d rect1 = new MyRectangle2d(2,2,5.4,4.9);
		System.out.println("The Rectangle with the values x: " +rect1.x+ "and y: " +rect1.y+ " and width: " +rect1.width+" and height: " +rect1.height+ "\n Area is: " +rect1.getArea()+ "\n Perimeter is: " +rect1.getPerimeter());
		System.out.println("Is the new rectangle contains the point 3 and 3? " +rect1.contains(3,3));
		System.out.println("Is the new rectangle contains the default rectangle? " +rect1.contains(rect));
		System.out.println("Is the new rectangle overlaps default rectangle? " +rect1.overlaps(rect));
	}
}
