//Uday Kiran Bodi
//CIN: 302560458
package edu.calstatela.cs;
import java.util.*;
public class Term
{	
	private int coeff;
	private int power;
	private static int sumOfConstants = 0;
	
	public Term()	//default term constructor.
	{
		
	}
	
	public void setCoeff(int coef)	//set the value for coeff with coef.
	{
		this.coeff = coef;
	}
	
	public int getCoeff()	//returns value of coeff.
	{
		return coeff;
	}
	
	public int getPower()	//returns value of power.
	{
		return power;
	}
	
	public void setPower(int pow)	//sets value of power to be pow.
	{
		this.power = pow;
	}
	
	public static ArrayList<Integer> makeArray(String str1)		//returns arrayList by splitting str1 into coeffs and powers.
	{
		ArrayList<String> list1 = new ArrayList<String>();
		//String str1 = list.get(0);
		String str = addConstants(str1);
		//System.out.println(str);
		String tokens[] = str.split("x");
		if(tokens.length == 0)
		{
			list1.add("1");
		}
		else
		if(tokens[0].matches(""))
		{
			list1.add("1");
		}
		else
		{
			if(tokens[0].matches("-"))
			{
				list1.add("-1");
			}
			else
			{
				list1.add(tokens[0]);
			}
		}
		for(int j = 1; j < tokens.length; j++)
		{
			if(tokens[j].charAt(0) == '^')
			{
				for(int k = 1; k < tokens[j].length(); k++)
				{
						if(tokens[j].charAt(k) == '+')
						{
							list1.add(tokens[j].substring(1, k));
							if(k != tokens[j].length() - 1)
							{
								list1.add(tokens[j].substring(k + 1, tokens[j].length()));
							}
							else
							{
								list1.add("1");
							}
						}
						else
						{
							if(tokens[j].charAt(k) == '-')
							{
								if(k != 1)
								{
									list1.add(tokens[j].substring(1, k));
									if(k != tokens[j].length() - 1)
									{
										list1.add(tokens[j].substring(k, tokens[j].length()));
									}
									else
									{
										list1.add("-1");
									}
								}
								else
								{
									if(k == 1)
									{
										if((tokens[j].indexOf('+', 2) < 0) && (tokens[j].indexOf('-', 2) < 0))
										{
											list1.add(tokens[j].substring(1, tokens[j].length()));
										}
									}
								}
							}
							else
							{
								if((tokens[j].indexOf('+', 1) < 0) && (tokens[j].indexOf('-', 1) < 0))
								{
									//if(!list1.contains(tokens[j].substring(1, tokens[j].length())))
										list1.add(tokens[j].substring(1, tokens[j].length()));
								}
							}
						}
				}
			}
			else
			{
				list1.add("1");
				if(tokens[j].charAt(0) == '+')
				{
					if(tokens[j].length() != 1)
						list1.add(tokens[j].substring(1,tokens[j].length()));
					else
						list1.add("1");
				}
				else
				{
					if(tokens[j].charAt(0) == '-')
					{
						if(tokens[j].length() != 1)
							list1.add(tokens[j].substring(0,tokens[j].length()));
						else
							list1.add("-1");
					}
				}
			}
		}
		if(str.endsWith("x"))
				list1.add("1");
		if(sumOfConstants != 0)
			list1.add("0");
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		for(int i = 0; i < list1.size(); i++)
		{
			if(list1.get(i).indexOf('+', 1) < 0 && list1.get(i).indexOf('-', 1) < 0)
				//System.out.println(list1.get(i));
				list2.add(Integer.valueOf(list1.get(i)));
		}
		if(list2.size() % 2 == 0)
		{
			//System.out.println(list2.toString());
		}
		else
		{
			System.out.println(list2.toString());
			System.out.println("Try Again...");
		}
		
		return list2;
	}
	
	private static String addConstants(String str)	//returns String after adding all the constants in the polynomial.
	{
		String[] s = str.split("[+]");
		Integer[] arr = new Integer[20];
		String[] s3 = new String[20];
		int size = 0,sum = 0,size1 = 0;
		for(int i = 0; i < s.length; i++)
		{
			if(s[i].indexOf('x') < 0)
			{
				if(s[i].contains("-"))
				{
					String[] s2 = s[i].split("-");
					for(int j = 0; j < s2.length; j++)
					{
						if(j != 0)
						{
							//if(s[i].charAt(s[i].indexOf("-" + s2[j]) - 1) != '^')
							{
								arr[size] = Integer.valueOf("-" + s2[j]);
								size++;
							}
						}
						else
						{
							if(!s2[j].matches(""))
							{
								arr[size] = Integer.valueOf(s2[j]);
								size++;
							}
						}
					}
				}
				else
				{
					arr[size] = Integer.valueOf(s[i]);
					size++;
				}
			}
			else
			{
				//if(!s[i].contains("^-"))
				{
				 String[] s1 = s[i].split("-");
				 for(int j = 0; j < s1.length; j++)
				 {
					if(s1[j].indexOf('x') < 0)
					{
						if(!s1[j].matches(""))
						{
							if(j != 0)
							{
								//System.out.println(s1[j]);
								//if(s[i].indexOf(s1[j]) != 0)
								//if(s[i].charAt(s[i].indexOf("-" + s1[j]) - 1) != '^')
								{
									arr[size] = Integer.valueOf("-" + s1[j]);
									size++;
								}
							}
							else
							{
								arr[size] = Integer.valueOf(s1[j]);
								size++;
							}
						}
					}
					else
					{
						//System.out.println(s1[j]);
						s3[size1] = s1[j];
						size1++;
					}
				}
				}
			}
		}
		for(int k = 0; k < size; k++)
		{
			sum = sum + arr[k];
		}
		StringBuilder str1 = new StringBuilder();
		StringBuilder str2 = new StringBuilder(str);
		for(int k = 0; k < size1; k++)								//4x^6-6-5x^7+9-90-90+90
		{
			if(str2.indexOf(s3[k]) != 0)
			{
				
					str1.append(str2.charAt(str2.indexOf(s3[k]) - 1));
					str1.append(s3[k]);
					str2.delete(0, str2.indexOf(String.valueOf(s3[k].charAt(s3[k].length() - 1))) + 1);
 					//System.out.println(str2);
			}
			if(str2.indexOf(s3[k]) == 0)										//-6x^6+5x^-5-9-4x^4+111+3x^-3-2x^2+9+x^-1+6
			{
					//str1.append(str2.charAt(str2.indexOf(s3[k])));
					str1.append(s3[k]);
					str2.delete(0, str2.indexOf(String.valueOf(s3[k].charAt(s3[k].length() - 1))) + 1);
 					//System.out.println(str2);
			}
		} 
		sumOfConstants = sum;
		StringBuilder str3 = new StringBuilder(str1);
		if(sum < 0)
		{
			str3.append(String.valueOf(sum));
		}
		else
		{
			if(sum > 0)
			{
				if(str3.length() != 0)
				{
					str3.append("+" +sum);
				}
				else
				{
					str3.append(sum);
					//System.out.println(sum);
				}
			}
			//else
			{
				//return str3;
			}
		}
		if(str3.length() > 0)
		if(str3.charAt(0) == '+')
			str3.deleteCharAt(0);
		return String.valueOf(str3);
	}

}
