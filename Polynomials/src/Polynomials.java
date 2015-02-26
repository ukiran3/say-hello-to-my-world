//package edu.calstatela.cs;
import java.util.*;
public class Polynomials extends Term
{
	ArrayList<ArrayList<Integer>> ply = new ArrayList<ArrayList<Integer>>();
	
	public Polynomials()
	{
		
	}
	
	public Polynomials(ArrayList<ArrayList<Integer>> polynomial)
	{
		this.ply = polynomial;
	}
	
	public Polynomials(String str)
	{
		ply.add(makeArrayList(makeArray(str)));	
	}
	
	public static ArrayList<Integer> makeArrayList(ArrayList<Integer> list)
	{
		ArrayList<Integer> poly = new ArrayList<Integer>();	
		Term term = new Term();
		if(list.size() % 2 == 0)
		{
			for(int j = 2; j <= list.size(); j = j + 2)
			{
				term.setCoeff(list.get(j - 2));
				term.setPower(list.get(j - 1));
				
				//System.out.println(term.makeTerm().toString());
				poly.add(term.getCoeff());
				poly.add(term.getPower());
			}
		}
		
		return poly;
		//System.out.println(poly.toString());
	}
	
	public String printPoly(ArrayList<Integer> list)
	{
		ArrayList<Integer> powers = new ArrayList<Integer>();
		ArrayList<Integer> coeffs = new ArrayList<Integer>();
		
		for(int i = 0; i < list.size(); i++)
		{
			if(i % 2 != 0)
			{
				powers.add(list.get(i));
			}
			else
			{
				coeffs.add(list.get(i));
			}
		}
		
		
		//for(int j = 0; j < powers.size(); j++)
			int key,m,keyc;
			ArrayList<Integer> powers1 = new ArrayList<Integer>(powers);
			ArrayList<Integer> coeffs1 = new ArrayList<Integer>(coeffs);
			for(int l = 0; l < powers1.size(); l++)
			{
				int num = powers1.get(l);
				for(int k = l + 1; k < powers1.size(); k++)
				{
					if(num == powers1.get(k))
					{
						coeffs1.set(l, coeffs1.get(k) + coeffs1.get(l));
						powers1.remove(k);
						coeffs1.remove(k);
					}
				}
			}
			coeffs = coeffs1;
			powers = powers1;
			
			System.out.println(coeffs1 + "" + powers1); 
			for(int i = 1; i < powers.size(); i++)
			{
				key = powers.get(i);
				keyc = coeffs.get(i);
				m = i - 1;
				while(m > -1 && powers.get(m) < key)
				{
					powers.set(m + 1, powers.get(m));
					coeffs.set(m + 1, coeffs.get(m));
					m = m - 1;
				}
				
				powers.set(m + 1, key);
				coeffs.set(m + 1, keyc);
			}
			//coeffs = coeffs1;
			//powers = powers1;
			//System.out.println(coeffs + "" + powers);
			//System.out.println(coeffs);
			//System.out.println(powers);
		
		StringBuffer str = new StringBuffer();
		for(int j = 0; j < powers.size(); j++)
		{
			if(powers.get(j) > 1)
			{
				if(coeffs.get(j) < 0)
				{
					str.append(coeffs.get(j) +"x^"+ powers.get(j));
				}
				if(coeffs.get(j) > 0)
				{
					if(j != 0)
					{
						if(str.length() > 0)
							str.append("+" +coeffs.get(j) +"x^"+ powers.get(j));
						else
							str.append(coeffs.get(j) +"x^"+ powers.get(j));
					}
	
					else
						str.append(coeffs.get(j) +"x^"+ powers.get(j));
				}
			}
			else
			{
				if(powers.get(j) == 1)
				{
					if(coeffs.get(j) < 0)
					{
						str.append(coeffs.get(j) +"x");
					}
					if(coeffs.get(j) > 0)
					{
						if(j != 0)
						{
							if(str.length() > 0)
								str.append("+" +coeffs.get(j) +"x");
							else
								str.append(coeffs.get(j) +"x");
						}
						else
						{
							str.append(coeffs.get(j) +"x");
						}
					}
				}
				if(powers.get(j) == 0)
				{
					if(coeffs.get(j) < 0)
					{
						str.append(coeffs.get(j));
					}
					else
					{
						if(str.length() > 0)
							str.append("+" +coeffs.get(j));
						else
							str.append(coeffs.get(j));
					}
				}
			}
		}
		for(int i = 0; i < str.length(); i++)
		{
			if(str.indexOf("-1x") >= 0)
				str.deleteCharAt(str.indexOf("-1x") + 1);
			if(str.indexOf("1x") >= 0)
				str.deleteCharAt(str.indexOf("1x"));
		}
	
		String polynomial = new String(str);
		System.out.println(polynomial);
		return polynomial;
	}

	public String addPolynomial()
	{
		ArrayList<Integer> powers = new ArrayList<Integer>();
		ArrayList<Integer> coeffs = new ArrayList<Integer>();
		for(int j = 0; j < ply.size(); j++)
		{
			//System.out.println(ply.get(j).toString());
			for(int i = 0; i < ply.get(j).size(); i++)
			{
				if(i % 2 != 0)
				{
					if(!powers.contains(ply.get(j).get(i)))
					{
						powers.add(ply.get(j).get(i));
					}
					else
					{
						coeffs.set(powers.indexOf(ply.get(j).get(i)), coeffs.get(coeffs.size()- 1) + coeffs.get(powers.indexOf(ply.get(j).get(i))));
						coeffs.remove(coeffs.size() - 1);
					}
				}
				else
				{
					coeffs.add(ply.get(j).get(i));
				}
			}
			
			//System.out.println(coeffs);
			//System.out.println(powers);
		}
		ArrayList<Integer> polyn = new ArrayList<Integer>();
		int size = powers.size() * 2;
		for(int i = 0; i < size ; i++)
		{
			if(i % 2 == 0)
			{
				polyn.add(coeffs.get(0));
				coeffs.remove(0);
			}
			else
			{
				polyn.add(powers.get(0));
				powers.remove(0);
			}
		}
		return printPoly(polyn);
	}
	
	public String subtractPolynomial()
	{
		ArrayList<Integer> powers = new ArrayList<Integer>();
		ArrayList<Integer> coeffs = new ArrayList<Integer>();
		for(int k = 0; k < ply.get(1).size(); k++)
		{
			if(k % 2 == 0)
			{
				ply.get(1).set(k, ply.get(1).get(k) * -1);
			}
		}
		for(int j = 0; j < ply.size(); j++)
		{
			//System.out.println(ply.get(j).toString());
			for(int i = 0; i < ply.get(j).size(); i++)
			{
				if(i % 2 != 0)
				{
					if(!powers.contains(ply.get(j).get(i)))
					{
						powers.add(ply.get(j).get(i));

					}
					else
					{
						coeffs.set(powers.indexOf(ply.get(j).get(i)), coeffs.get(coeffs.size()- 1) + coeffs.get(powers.indexOf(ply.get(j).get(i))));
						coeffs.remove(coeffs.size() - 1);
					}
				}
				else
				{
						coeffs.add(ply.get(j).get(i));
				}
			}
			
			//System.out.println(coeffs);
			//System.out.println(powers);
		}
		ArrayList<Integer> polyn = new ArrayList<Integer>();
		int size = powers.size() * 2;
		for(int i = 0; i < size ; i++)
		{
			if(i % 2 == 0)
			{
				polyn.add(coeffs.get(0));
				coeffs.remove(0);
			}
			else
			{
				polyn.add(powers.get(0));
				powers.remove(0);
			}
		}
		return printPoly(polyn);
	}
	
	public String multiplyPolynomial()
	{
		ArrayList<Integer> powers = new ArrayList<Integer>();
		ArrayList<Integer> coeffs = new ArrayList<Integer>();
		//int size = ply.get(0).size() / 2;
		for(int i = 0; i < ply.get(0).size(); i++)
		{
				if(i % 2 != 0)
				{
					powers.add(ply.get(0).get(i));
				}
				else
				{
					coeffs.add(ply.get(0).get(i));
				}
		}
		
		//System.out.println(ply.get(0).toString());
		for(int m = 0; m < ply.get(0).size() / 2 ; m++)
		{
			for(int i = 0; i < ply.get(1).size(); i++)
			{
				if(i % 2 == 0)
				{
					coeffs.add(coeffs.get(m) * ply.get(1).get(i));
					//coeffs.remove(m);
				}
				else
				{
					powers.add(powers.get(m) + ply.get(1).get(i));
					//powers.remove(m);
				}
			}
		}
		for(int i = 0; i < ply.get(0).size() / 2; i++)
		{
			coeffs.remove(0);
			powers.remove(0);
		}
		//System.out.println(coeffs);
		//System.out.println(powers);
		ArrayList<Integer> polyn = new ArrayList<Integer>();
		int size = powers.size() * 2;
		for(int i = 0; i < size ; i++)
		{
			if(i % 2 == 0)
			{
				polyn.add(coeffs.get(0));
				coeffs.remove(0);
			}
			else
			{
				polyn.add(powers.get(0));
				powers.remove(0);
			}
		}
		return printPoly(polyn);
	}
	
	public String diffPolynomial()
	{
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 != 0)
			{
				ply.get(0).set(i - 1, ply.get(0).get(i - 1) * ply.get(0).get(i));
				ply.get(0).set(i, ply.get(0).get(i)- 1);
			}
		}
		//System.out.println(ply.get(0).toString());
		return printPoly(ply.get(0));
	}
	
	public void evalPolynomial()
	{
		System.out.println("Enter a value for x: ");
		Scanner input = new Scanner(System.in);
		int xVal = input.nextInt();
		double value = 0;
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 != 0)
			{
				if(ply.get(0).get(i) != 0)
					value = value + ply.get(0).get(i - 1) * Math.pow(xVal, ply.get(0).get(i));
				else
					value = value + ply.get(0).get(i - 1);
			}
		}
		System.out.println("f(" +xVal+ ") = " +value);
	}
	public String multiplyPolyWithX()
	{
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 != 0)
				ply.get(0).set(i, ply.get(0).get(i) + 1);
		}
		//System.out.println(ply.get(0).toString());
		return printPoly(ply.get(0));
	}
	public String multiplyPolynomialWithNum()
	{
		System.out.println("Enter a value to multiply polynomial with: ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 == 0)
				ply.get(0).set(i, ply.get(0).get(i) * num);
		}
		//System.out.println(ply.get(0).toString());
		return printPoly(ply.get(0));
	}
	public String dividePolynomialWithNumber()
	{
		System.out.println("Enter a value to divide polynomial with: ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 == 0)
				ply.get(0).set(i, ply.get(0).get(i) / num);
		}
		//System.out.println(ply.get(0).toString());
		return printPoly(ply.get(0));
	}
	
	public String dividePolynomialWithX()
	{
		for(int i = 0; i < ply.get(0).size(); i++)
		{
			if(i % 2 != 0)
				ply.get(0).set(i, ply.get(0).get(i) - 1);
		}
		//System.out.println(ply.get(0).toString());
		return printPoly(ply.get(0));
	}
	

	
	public static boolean valuate()
	{
		boolean torf = false;
		
		return torf;
	}
	
}