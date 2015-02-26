import java.util.*;
public class TestTriangle
{
	public static void main(String args[])
	{
		Triangle tri = new Triangle(1,1.5,1);
		tri.setColor("yellow");
		tri.setFilled(true);
		System.out.println(tri.toString());
		System.out.println("Area is: " +tri.getArea());
		System.out.println("Perimeter is: " +tri.getPerimeter());
		System.out.println("Color is: " +tri.getColor());
		System.out.println("Filled? " +tri.isFilled());
		double side1,side2,side3;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter value for side1: ");
		side1 = input.nextDouble();
		System.out.println("Enter value for side2: ");
		side2 = input.nextDouble();
		System.out.println("Enter value for side3: ");
		side3 = input.nextDouble();
		Triangle tri1 = new Triangle(side1,side2,side3);
		System.out.println(tri1.toString());
		System.out.println("Area is: " +tri1.getArea());
		System.out.println("Perimeter is: " +tri1.getPerimeter());
		System.out.println("Color is: " +tri1.getColor());
		System.out.println("Filled? " +tri1.isFilled());
	}
}
