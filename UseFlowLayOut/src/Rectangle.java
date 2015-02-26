import java.util.*;
import java.io.*;
public class Rectangle extends GeometricObject implements Comparable
{
	int length = 1;
	int width = 1;
	public int getArea()
	{
		return length * width;
	}
	public Rectangle()
	{
		
	}
	public Rectangle(int length, int width)
	{
		this.length = length;
		this.width = width;
	}
	public int getLength()
	{
		return length;
	}
	public int getWidth()
	{
		return width;
	}
	
	public int compareTo(Object o)
	{
		if(getArea() > ((Rectangle)o).getArea())
		{
			return 1;
		}
		else
		{
			if(getArea() < ((Rectangle)o).getArea())
				return -1;
			else
				return 0;
						
		}
	}
	
	public GeometricObject max(GeometricObject o1, GeometricObject o2)
	{
		if(((Comparable)o1).compareTo(o2) >= 0)
		{
			return o1;
		}
		else
			return o2;
	}
	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle(6,7);
		Rectangle r2 = new Rectangle(4,5);
		System.out.println("The maximum rectangle is rectangle with length: " +((Rectangle)(r1.max(r1, r2))).getLength()+ " and width: " +((Rectangle)(r1.max(r1, r2))).getWidth());
	}
}