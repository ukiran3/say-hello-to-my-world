import java.lang.*;
import java.io.*;
public class Circles extends GeometricObject implements Comparable
{
	int radius = 1;
	public Circles()
	{
		
	}
	public Circles(int r)
	{
		radius = r;
	}
	public int getRadius()
	{
		return this.radius;
	}
	public int getArea()
	{
		return (int)Math.PI * radius * radius;
	}
	@Override
	public boolean equals(Object o)
	{
		if(this.getRadius() == ((Circles)o).getRadius())
			return true;
		else
			return false;
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
	
	public int compareTo(Object o)
	{
		if(getArea() > ((Circles)o).getArea())
		{
			return 1;
		}
		else
		{
			if(getArea() < ((Circles)o).getArea())
				return -1;
			else
				return 0;
						
		}
	}

	
	public static void main(String[] args)
	{
		Circles cir1 = new Circles(5);
		Circles cir2 = new Circles(5);
		System.out.println("Is first circle equal to second?: " +(cir1.equals(cir2)));
	}
}
