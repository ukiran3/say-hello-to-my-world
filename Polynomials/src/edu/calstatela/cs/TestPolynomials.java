//Uday Kiran Bodi
//CIN: 302560458
package edu.calstatela.cs;
import edu.calstatela.cs.Polynomials;


import java.util.*;
public class TestPolynomials extends Polynomials
{	
	//ArrayList<ArrayList<Integer>> polynomials = new ArrayList<ArrayList<Integer>>();
	Polynomials poly1 = new Polynomials();	//Creates object of polynomials.
	//Polynomials poly1 = new Polynomials(String str);
	//Polynomials poly1 = new Polynomials(Polynomials ArrayList<ArrayList<Integer>> polynomials);
	public static String read()		//reads and returns the string polynomial.
	{
		//ArrayList <String> list = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the polynomial in the format: -12x^5+6x^3-3x+5");
		String str = input.nextLine();
		return str;
	}
	
	public void print(ArrayList<String> list)
	{
		System.out.println(list.toString());
	}
	
	public void printMenu(String str)	//prints menu and asks for operation to be performed.
	{	
		if(valuate(str))
		{
		System.out.println("-------------MENU-------------");
		System.out.println("1. Addition. ");
		System.out.println("2. Substraction. ");
		System.out.println("3. Multiplication. ");
		System.out.println("4. Differentiation. ");
		System.out.println("5. Evaluation. ");
		System.out.println("6. Multipolynomials polynomial with x. ");
		System.out.println("7. Multipolynomials polynomial with a number. ");
		System.out.println("8. Divide polynomial with a number. ");
		System.out.println("9. Divide polynomial with x. ");
		System.out.println("10. Exit ");
		System.out.println("Enter the type of operation you would like to perform on: " +str);
		Scanner input1 = new Scanner(System.in);
		int choice = input1.nextInt();
		switch(choice)
		{
			case 1 : System.out.println("Addition. ");	//adding 2nd polynomial with 1st one.
						System.out.println("Enter the polynomial for addition: ");
						String polyadd = read();
						ArrayList<Integer> aladd = makeArrayList(makeArray(polyadd));
						polynomials.add(aladd);
						String sumPoly = addPolynomial();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(sumPoly)));
						printMenu(sumPoly);
						break;
			case 2 : System.out.println("Substraction. ");	//subtracting 2nd polynomial from 1st one.
						System.out.println("Enter the polynomial for Substraction: ");
						String polysub = read();
						ArrayList<Integer> alsub = makeArrayList(makeArray(polysub));
						polynomials.add(alsub);
						
						String diffPoly = subtractPolynomial();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(diffPoly)));
						printMenu(diffPoly);
						break;
			case 3 : System.out.println("Multiplication. ");	//multiplying two polynomials.
						System.out.println("Enter the polynomial for Multiplication: ");
						String polymul = read();
						ArrayList<Integer> almul = makeArrayList(makeArray(polymul));
						polynomials.add(almul);
						
						String prodPoly = multiplyPolynomial();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(prodPoly)));
						printMenu(prodPoly);
						break;
			case 4 : System.out.println("Differentiation. ");	//Differentiating a polynomial.
						
						String deriPoly = diffPolynomial();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(deriPoly)));
						printMenu(deriPoly);
						break;
			case 5 : System.out.println("Evaluation. ");		//Evaluating the polynomial with a value for x.
						evalPolynomial();
						printMenu(str);
						break;
			case 6 : System.out.println("Multiply polynomial with x. ");	//Multiply Polynomial with x.
						
						String xMulPoly = multiplyPolyWithX();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(xMulPoly)));
						printMenu(xMulPoly);
						break;
			case 7 : System.out.println("Multiply polynomial with a number. ");	//Multiply polynomial with a number. 
						
						String numMulPoly = multiplyPolynomialWithNum();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(numMulPoly)));
						printMenu(numMulPoly);
						break;
			case 8 : System.out.println("Divide polynomial with a number. ");	//Divide polynomial with a number. 
						
						String numDivPoly = dividePolynomialWithNumber();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(numDivPoly)));
						printMenu(numDivPoly);
						break;
			case 9 : System.out.println("Divide polynomial with x. ");	//Divide polynomial with x. 
						
						String xDivPoly = dividePolynomialWithX();
						polynomials.clear();
						polynomials.add(makeArrayList(makeArray(xDivPoly)));
						printMenu(xDivPoly);
						break;
			case 10 : System.out.println("Exit. ");	//Exit.
						System.exit(0);
						break;
			default : System.out.println("The choice you entered is a wrong one, Kindly try again...");	//switch default case.
						printMenu(str);
						break;
		}
		}
		else
			System.out.println("The striing you entered is not a valid one to be polynomial. Kindly try again...");
			
	}
	
	public static void main(String[] args)
	{
		try
		{
			TestPolynomials ptest = new TestPolynomials();	//creating object for TestPolynomials class.
			String str = read();
			if(valuate(str))
			{
				polynomials.add(makeArrayList(makeArray(str)));
				ptest.printMenu(str);	//calling printMeny function.
			}
			else
			{
				System.out.println("The striing you entered is not a valid one to be polynomial. Kindly try again...");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error occured: " +e);
		}
	}
}
