
public class Complex
{
	private double a;
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	private double b;
	public Complex()
	{
		this(10,10);
	}
	public Complex(double a, double b)
	{
		this.a = a;
		this.b = b;
	}
	public Complex add(Complex c1)
	{
		Complex c3 = new Complex();
		c3.setA(c1.getA() + this.getA());
		c3.setB(c1.getB() + this.getB());
		return c3;
	}
	public Complex subtract(Complex c1)
	{
		Complex c3 = new Complex();
		c3.setA(c1.getA() - this.getA());
		c3.setB(c1.getB() - this.getB());
		return c3;
	}
	public Complex multiply(Complex c1)
	{
		Complex c3 = new Complex();
		c3.setA(c1.getA() + this.getA());
		c3.setB(c1.getB() + this.getB());
		return c3;
	}
	public Complex divide(Complex c1)
	{
		Complex c3 = new Complex();
		c3.setA(c1.getA() + this.getA());
		c3.setB(c1.getB() + this.getB());
		return c3;	
	}
	public Complex abs(Complex c1)
	{
		Complex c3 = new Complex();
		c3.setA(c1.getA() + this.getA());
		c3.setB(c1.getB() + this.getB());
		return c3;
	}
	@Override
	public String toString()
	{
		return ""+this.getA()+"+" +this.getB();
	}
	public static void main()
	{
		Complex c2 = new Complex();
		Complex c1 = new Complex(5,5);
		
		System.out.println(c1.add(c2).toString());
	}
}
