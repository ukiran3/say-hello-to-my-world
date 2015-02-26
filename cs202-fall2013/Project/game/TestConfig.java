package edu.calstatela.cs202.gala.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestConfig {
	Scanner userInput = new Scanner(System.in);
	private String[] keys;
	private String[] vals;
	private static final int SIZE = 10;
	private int lastIndex;
	
	public TestConfig() {
		this(SIZE);
	}
	
	public TestConfig(int size) {
		keys = new String[size];
		vals = new String[size];
		lastIndex = SIZE - 1;
	}
	
//	private void setLastIndex()
//	{
//		this.lastIndex = SIZE;
//	}
	public int getLastIndex()
	{
		return lastIndex;
	}
	
	/**
	 * Sets the key; this is a keyword to find the value needed
	 * @param key keyword
	 * @param index2 index of the array it is to be set as
	 */
	public void setKey(String key, int index2) {
		for(int index = 0; index < keys.length; index++)
		{
			if(keys[index2] == null){
				keys[index2] = key;
			}
		}
	}
	
	/**
	 * Sets the value; this is a value that can be found given the key
	 * @param val the value of the key
	 * @param index2 the index of the array it is to be set as
	 */
	public void setVal(String val, int index2) {
		for(int index = 0; index < keys.length; index++)
		{
			if(vals[index2] == null){
				vals[index2] = val;
			}
		}
	}
	
	/**
	 * Prints all of the known keys; mostly used for testing purposes
	 */
	public void printAllKeys()
	{
		for(int index = 0; index < keys.length; index++)
		{
			System.out.print(keys[index] + " ");
		}
	}
	
	/**
	 * Prints all of the known values; mostly used for testing purposes
	 */
	public void printAllVals()
	{
		for(int index = 0; index < vals.length; index++)
		{
			System.out.print(vals[index] + " ");
		}
	}

	/**
	 * Read the configuration file that holds values needed to start the game
	 * @param fileName Name of the configuration file
	 * @throws FileNotFoundException Thrown in case the file can't be found
	 */
	public void read(String fileName) throws FileNotFoundException {
		//Read the file to get the key and value
		File file = new File(fileName);
		int index = 0; //Index to be assigned to keys and values
		try
		{
			Scanner config = new Scanner(file);
			
			while (config.hasNext()) {
				String key = config.next();
				String dummy = config.next(); //Note, the variable dummy is '='
				String val = config.next();
				set(key, val, index);
				index++; 
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Leads to methods used to set either the key or the value
	 * @param key the keyword
	 * @param val the value of the keyword
	 * @param index the index the key and value are to be set to
	 */
	private void set(String key, String val, int index) {
		//Set the key
		setKey(key, index);
		
		//Set the value
		setVal(val, index);
	}
	
	/**
	 * Gets a specific value, given the index
	 * @param index The index of the value
	 * @return the specified value
	 */
	public String getVal(int index)
	{
		return vals[index];
	}
	
	/**
	 * Finds a numerical value given a keyword and parses it to Integer
	 * @param key The keyword
	 * @return Value as an integer
	 */
	public int getValue(String key)
	{
		int index = 0;
		
		for(int i = 0; i < keys.length; i++)
		{
			if(keys[i].equals(key))
			{
//				System.out.println("The element of keys is:" + keys[i]);
				index = i;
			}
		}
		
//		System.out.println("Last Index is: " + getLastIndex());
//		
//		System.out.println("Index is: " + index);
		
		String halfway = getVal(index); //Get the value as a String
		
//		System.out.println("Halfway is: " + halfway); 
		
		int result = 0;
		try
		{
			result = Integer.parseInt(halfway); //Change the value into an integer
		} catch(Exception e)
		{
			e.getStackTrace();
		}
		
		return result;
	}

	/**
	 * Find the values of those whose value is of type String
	 * @param key The keyword
	 * @return The value
	 */
	public String getRule(String key)
	{
		int index = 0;
		
		for(int i = 0; i < keys.length; i++)
		{
			if(keys[i].equals(key))
			{
				index = i;
			}
		}
		
//		System.out.println("The key is: " + key);
//		System.out.println("The index is: " + index);
		
		String result = getVal(index); //Get the value as a String
		
		return result;
	}

	public boolean isNumeric(String num)
	{
		int result = 0;
		boolean  good = false;
		
		try
		{
			result = Integer.parseInt(num);
		} catch(Exception e)
		{
			System.out.println("Please enter the number of one of the Sheep.");
			return good;
		}
		good = true;
		return good;
	}
	
	public int parseToInt(String num)
	{
		int result = Integer.parseInt(num);
		return result;
	}
	
	public String getDirection()
	{
		//N, S, E, W, X [Stay], R [Random]
		String choice = null;
		
		choice = userInput.next();
		
		while((!choice.equalsIgnoreCase("N")) && (!choice.equalsIgnoreCase("S")) && (!choice.equalsIgnoreCase("E")) && (!choice.equalsIgnoreCase("W")) && (!choice.equalsIgnoreCase("X")) && (!choice.equalsIgnoreCase("R")))
		{
			System.out.print("Please enter a valid direction: ");
			choice = userInput.next();
		}
		
		return choice;
	}
	
}
