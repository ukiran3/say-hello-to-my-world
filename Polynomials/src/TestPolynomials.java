import java.util.*;
public class TestPolynomials extends Polynomials
{	
	//ArrayList<ArrayList<Integer>> ply = new ArrayList<ArrayList<Integer>>();
	Polynomials poly1 = new Polynomials();
	//Polynomials poly1 = new Polynomials(String str);
	//Polynomials poly1 = new Polynomials(Polynomials ArrayList<ArrayList<Integer>> ply);
	public static String read()
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
	
	public void printMenu(String str)
	{	
		System.out.println("-------------MENU-------------");
		System.out.println("1. Addition. ");
		System.out.println("2. Substraction. ");
		System.out.println("3. Multiplication. ");
		System.out.println("4. Differentiation. ");
		System.out.println("5. Evaluation. ");
		System.out.println("6. Multiply polynomial with x. ");
		System.out.println("7. Multiply polynomial with a number. ");
		System.out.println("8. Divide polynomial with a number. ");
		System.out.println("9. Divide polynomial with x. ");
		System.out.println("10. Exit ");
		System.out.println("Enter the type of operation you would like to perform on: " +str);
		Scanner input1 = new Scanner(System.in);
		int choice = input1.nextInt();
		switch(choice)
		{
			case 1 : System.out.println("Addition. ");
						System.out.println("Enter the polynomial for addition: ");
						String polyadd = read();
						ArrayList<Integer> aladd = makeArrayList(makeArray(polyadd));
						ply.add(aladd);
						String sumPoly = addPolynomial();
						ply.clear();
						ply.add(makeArrayList(makeArray(sumPoly)));
						printMenu(sumPoly);
						break;
			case 2 : System.out.println("Substraction. ");
						System.out.println("Enter the polynomial for Substraction: ");
						String polysub = read();
						ArrayList<Integer> alsub = makeArrayList(makeArray(polysub));
						ply.add(alsub);
						
						String diffPoly = subtractPolynomial();
						ply.clear();
						ply.add(makeArrayList(makeArray(diffPoly)));
						printMenu(diffPoly);
						break;
			case 3 : System.out.println("Multiplication. ");
						System.out.println("Enter the polynomial for Multiplication: ");
						String polymul = read();
						ArrayList<Integer> almul = makeArrayList(makeArray(polymul));
						ply.add(almul);
						
						String prodPoly = multiplyPolynomial();
						ply.clear();
						ply.add(makeArrayList(makeArray(prodPoly)));
						printMenu(prodPoly);
						break;
			case 4 : System.out.println("Differentiation. ");
						
						String deriPoly = diffPolynomial();
						ply.clear();
						ply.add(makeArrayList(makeArray(deriPoly)));
						printMenu(deriPoly);
						break;
			case 5 : System.out.println("Evaluation. ");
						evalPolynomial();
						printMenu(str);
						break;
			case 6 : System.out.println("Multiply polynomial with x. ");
						
						String xMulPoly = multiplyPolyWithX();
						ply.clear();
						ply.add(makeArrayList(makeArray(xMulPoly)));
						printMenu(xMulPoly);
						break;
			case 7 : System.out.println("Multiply polynomial with a number. ");
						
						String numMulPoly = multiplyPolynomialWithNum();
						ply.clear();
						ply.add(makeArrayList(makeArray(numMulPoly)));
						printMenu(numMulPoly);
						break;
			case 8 : System.out.println("Divide polynomial with a number. ");
						
						String numDivPoly = dividePolynomialWithNumber();
						ply.clear();
						ply.add(makeArrayList(makeArray(numDivPoly)));
						printMenu(numDivPoly);
						break;
			case 9 : System.out.println("Divide polynomial with x. ");
						
						String xDivPoly = dividePolynomialWithX();
						ply.clear();
						ply.add(makeArrayList(makeArray(xDivPoly)));
						printMenu(xDivPoly);
						break;
			case 10 : System.out.println("Exit. ");
						System.exit(0);
						break;
			default : System.out.println("The choice you entered is a wrong one, Kindly try again...");
						printMenu(str);
						break;
		}
	}
	
	public static void main(String[] args)
	{
		TestPolynomials ptest = new TestPolynomials();
		String str = read();
		//print(poly.list);
		ptest.ply.add(makeArrayList(makeArray(str)));
		ptest.printMenu(str);
	}
}
