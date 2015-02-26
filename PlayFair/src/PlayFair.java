import java.util.*;
public class PlayFair
{
	public char[][] makeMatrix(String secretCode)	//Returns the matrix created by using the secret message given by user.
	{
		char[][] matrix = new char[9][9];
		int m = 0,i = 0,j = 0;
		char charArray[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 '()*+,-./:;<=>[]^?".toCharArray();
		int size = charArray.length;
		for(int k = 0; k < secretCode.length(); k++)
		{
			for(int l = 0; l < size ; l++)
			{
				if(charArray[l] == secretCode.charAt(k))
				{
					if(j == 9)
					{
						i++; j = 0;
					}
					if(j < 9 && i < 9)
					{
						matrix[i][j] = charArray[l];
						j++;	
					}
					for(int n = l + 1; n < charArray.length; n++)	//deleting the already obtained character.
					{
						//if(v[l] != '?')
						charArray[n - 1] = charArray[n];
					}
					size--;
				}
			}
		}
		for(int k = i ; k < 9; k++)
		{
			for(int n = j ; n < 9 ; n++)
			{
				matrix[k][n] = charArray[m];
				m++;
			}
			j = 0;
		}
		for(i = 0; i < 9; i++)
		{
			for(j = 0; j < 9; j++)
			{
				System.out.print(" " +matrix[i][j]+ " ");	//printing the matrix.
			}
			System.out.println("");
		} 
		return matrix;
	} 
	public void encrypt(String message,char[][] matrix)	//To encrypt the message using that matrix. 
	{
		int firsti = 9,firstj = 9,secondi = 9,secondj = 9;
		int size = message.length();
		char[] encryptedArray = new char[size];
		if(size % 2 == 0)
		{
		 for(int i = 1; i < size; i = i + 2)
		 {
			 char first = message.charAt(i - 1);
			 char second = message.charAt(i);
			if( first != second)
			{
			 for(int j = 0; j < 9; j++)
			 {
				 for(int k = 0; k < 9; k++)
				 {
					 if(matrix[j][k] == first)
					 {
						  firsti = j;			//getting ith position of first letter.
						  firstj = k;			//getting jth position of first letter.
					 }
				 }                                              
			 }
			 for(int j = 0; j < 9; j++)
			 {
				 for(int k = 0; k < 9; k++)
				 {
					 if(matrix[j][k] == second)
					 {
						  secondi = j;			//getting ith position of second letter.
						  secondj = k;			//getting jth position of second letter.
					 }
				 }
			 }
			 if(firsti != 9 && firstj != 9 && secondi != 9 && secondj != 9)
			 {
				 if(firsti == secondi)		// performing first condition of Encrypt.
				 {
					 //System.out.println(firsti );
					 //System.out.println(firstj );
					 //System.out.println(secondi );
					 //System.out.println(secondj );
					 if(firstj != 8 && secondj != 8)
					 {
						 encryptedArray[i - 1] = matrix[firsti ][firstj + 1];
						 encryptedArray[i] = matrix[firsti ][secondj + 1];
					 }
					 else
					 {
						 if(firstj == 8)
						 {
							 encryptedArray[i - 1] = matrix[firsti ][0];
							 encryptedArray[i] = matrix[firsti ][secondj + 1];
						 }
						 if(secondj == 8)
						 {
							 encryptedArray[i - 1] = matrix[firsti ][firstj + 1];
							 encryptedArray[i] = matrix[firsti ][0];
						 }
					 }
				 }
				 if(firstj == secondj )		// performing second condition of Encrypt.
				 {
					 if(firsti != 8 && secondi != 8)
					 {
						 encryptedArray[i - 1] = matrix[firsti + 1][firstj ];
						 encryptedArray[i] = matrix[secondi + 1][firstj ];
					 }
					 else
					 {
						 if(firsti == 8)
						 {
							 encryptedArray[i - 1] = matrix[0][firstj ];
							 encryptedArray[i] = matrix[secondi + 1][firstj ];
						 }
						 if(secondi == 8)
						 {
							 encryptedArray[i - 1] = matrix[firsti + 1][firstj ];
							 encryptedArray[i] = matrix[0][firstj ];
						 }
					 }
				 }
				 if(firstj != secondj && firsti != secondi )		//performing third condition of Encrypt.
				 {
					 encryptedArray[i - 1] = matrix[firsti ][secondj ];
					 encryptedArray[i] = matrix[secondi ][firstj ];
				 }
			 }
			}
			else
			{
				 System.out.println("Two consecutive identical characters are not allowed...{" +first+ "" +second+ "}");
				 String[] args = {};
				 System.out.println("Do you wish to continue... (Enter Y or N): ");
					Scanner input3 = new Scanner(System.in);
					char choice = input3.next().charAt(0);
					//input3.close();
					if(choice == 'y' || choice == 'Y')
					{
						main(args);
					}
					else
					{
						System.exit(0);
					}
			}
		 }
		System.out.print("{" +String.valueOf(encryptedArray)+ "}");
		}
		else
		{
			//System.out.println("Hello");
			StringBuilder str = new StringBuilder(message);
			str = str.append(" ");		//Appending a blank space when odd number of characters are observed.
			encrypt(String.valueOf(str),matrix);
		}
		System.out.println("");
	}
	public void decrypt(String message,char[][] matrix)		//Method for decrypting the message using the same matrix.
	{
		int firsti = 9,firstj = 9,secondi = 9,secondj = 9;
		boolean count = false;
		int size = message.length();
		char[] decryptedArray = new char[size];
		if(size % 2 == 0)		//verifying fourth condition for Decryption.
		{
			//decryptedArray[size] = ' ';
		 for(int i = 1; i < size; i = i + 2)
		 {
			 char first = message.charAt(i - 1);
			 char second = message.charAt(i);
			if( first != second)
			{
			 for(int j = 0; j < 9; j++)
			 {
				 for(int k = 0; k < 9; k++)
				 {
					 if(matrix[j][k] == first)
					 {
						  firsti = j;			
						  firstj = k;
					 }
				 }                                              
			 }
			 for(int j = 0; j < 9; j++)
			 {
				 for(int k = 0; k < 9; k++)
				 {
					 if(matrix[j][k] == second)
					 {
						  secondi = j;
						  secondj = k;
					 }
				 }
			 }
			 if(firsti != 9 && firstj != 9 && secondi != 9 && secondj != 9)
			 {
				 if(firsti == secondi)			//performing first condition of Decrypt.
				 {
					 //System.out.println(firsti );
					 //System.out.println(firstj );
					 //System.out.println(secondi );
					 //System.out.println(secondj );
					 if(firstj != 0 && secondj != 0)
					 {
						 decryptedArray[i - 1] = matrix[firsti ][firstj - 1];
						 decryptedArray[i] = matrix[firsti ][secondj - 1];
					 }
					 else
					 {
						 if(firstj == 0)
						 {
							 decryptedArray[i - 1] = matrix[firsti ][8];
							 decryptedArray[i] = matrix[firsti ][secondj - 1];
						 }
						 if(secondj == 0)
						 {
							 decryptedArray[i - 1] = matrix[firsti ][firstj - 1];
							 decryptedArray[i] = matrix[firsti ][8];
						 }													
					 }
				 }
				 if(firstj == secondj)		//performing second condition of Decrypt.
				 {
					 if(firsti != 0 && secondi != 0)
					 {
						 decryptedArray[i - 1] = matrix[firsti - 1][firstj ];
						 decryptedArray[i] = matrix[secondi - 1][firstj ];
					 }
					 else
					 {
						 if(firsti == 0)
						 {
							 decryptedArray[i - 1] = matrix[8][firstj ];
							 decryptedArray[i] = matrix[secondi - 1][firstj ];
						 }
						 if(secondi == 0)
						 {
							 decryptedArray[i - 1] = matrix[firsti - 1][firstj ];
							 decryptedArray[i] = matrix[8][firstj ];
						 }
					 }
				 }
				 if(firstj != secondj && firsti != secondi)			//performing third condition of Decrypt.
				 {
					 decryptedArray[i - 1] = matrix[firsti ][secondj ];
					 decryptedArray[i] = matrix[secondi ][firstj ];
				 }
			 }
			}
			else
			{
				System.out.println("Note: Decoding can be done only after Encoding...");		//Printing error message if two consecutive letters are observed.
			}
		 }
		 System.out.print("{" +String.valueOf(decryptedArray)+ "}");		//Printing the decrypted message. 
		}
		else
		{
			System.out.println("Note: Decoding can be done only after Encoding...");		
		}
	System.out.println("");
	}
	public boolean validateMessage(String message)		//returns true if the message is following character conditions.
	{
		boolean torf = false;
		int count = 0;
		for(int i = 0; i < message.length(); i++)
		{
			if((message.charAt(i) == (char)32) || (message.charAt(i) >= (char)39 && message.charAt(i) <= '?') || (message.charAt(i) >= 'A' && message.charAt(i) <= '[') || (message.charAt(i) >= (char)97 && message.charAt(i) <= (char)122) || message.charAt(i) == ']' || message.charAt(i) == '^')
			//if((message.charAt(i) >= (char)32 && message.charAt(i) <= (char)122) && message.charAt(i) != (char)33 && message.charAt(i) != (char)34 && message.charAt(i) != (char)35 && message.charAt(i) != (char)36 && message.charAt(i) != (char)37 && message.charAt(i) != (char)38 && message.charAt(i) != (char)64 && message.charAt(i) != (char)92 && message.charAt(i) != (char)94 && message.charAt(i) != (char)95 && message.charAt(i) != (char)96)	
			{
			}
			else
				count++;
		}
		if(count == 0)
			torf = true;
		else
		{
			//System.out.println("The " +count);
			torf = false ;
		}
		return torf;
	}
	public void encode(String secretCode)		//method for encoding the message using secretCode.
	{
			char[][] matrix = makeMatrix(secretCode);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your message to be encoded: ");
			String encodeMessage = input.nextLine();
			boolean validate = validateMessage(encodeMessage);
			if(validate)
			{
					System.out.println("The Encoded message is: ");
					encrypt(encodeMessage,matrix);			//calling encrypt method to perform encryption on the message.
					//System.out.println("Encoding cannot be done because of the above mentioned reason. Kindly Try Again.");
			}
			else
				System.out.println("Your message is Invalid ");
			//input.close();
	}
	public void decode(String secretCode)		//method for decoding the message using the secretCode.
	{
			char[][] matrix = makeMatrix(secretCode);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your message to be decoded: ");
			String decodeMessage = input.nextLine();
			//input.close();
			boolean validate = validateMessage(decodeMessage);
			if(validate)
			{
				System.out.println("The Decoded message is: ");
				decrypt(decodeMessage,matrix);		//calling decrypt method to perform decryption on the message.
			}
			else
				System.out.println("Your message is Invalid ");
	}
	public void menuMethod()			//prints menu and asks user whether to encode or to decode.
	{
		PlayFair obj = new PlayFair();		//creating obj for PlayFair class.
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the world of Crytography...");
		System.out.println("MENU");
		System.out.println("------");
		System.out.println("1. Encode. ");
		System.out.println("2. Decode. ");
		System.out.println("3. Exit. ");
		System.out.println("Enter your choice: ");		
		int eord = input.nextInt();			// Asking user whether to Encode or Decode.
		//input.close();
		switch(eord)
		{
			case 1 : 	Scanner input1 = new Scanner(System.in);
						System.out.println("Hello. Enter your secret word to start Encoding...: ");
						String secretCodeToEncode = input1.nextLine();
						//obj.secretCode = secretCodeToEncode;
						boolean validMessage = obj.validateMessage(secretCodeToEncode);   	//Calling validateMessage method to check whether this message is reaching the character conditions or not.
						if(validMessage)
						{
							//System.out.println(" Your message is valid ");
							obj.encode(secretCodeToEncode);			//Calling encode method to start encoding the string entered by User.
						}
						else
							System.out.println("Your message is carrying some Invalid characters. Kindly Try Again...");
						break;
			
			case 2 : 	Scanner input2 = new Scanner(System.in);
						System.out.println("Hello. Enter your secret word to start Decoding...: ");
						String secretCodeToDecode = input2.nextLine();
						validMessage = obj.validateMessage(secretCodeToDecode);
						if(validMessage)
							obj.decode(secretCodeToDecode);			//Calling encode method to start encoding the string entered by User.
						else
							System.out.println("Your message is carrying some Invalid characters. Kindly Try Again...");
						break;
						
			case 3 : 	System.out.println("Exit");
						System.exit(0);
						break;
						
			default : 	System.out.println("The choice you entered is Invalid");
						System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		try				//Using Exception Handling.
		{
		char choice;
		PlayFair object = new PlayFair();  //Creating object for the class PlayFair. 
		object.menuMethod();		//Calling menuMethod method.
		do
		{
			System.out.println("Do you wish to continue... (Enter Y or N): ");
			Scanner input3 = new Scanner(System.in);
			choice = input3.next().charAt(0);

			if(choice == 'y' || choice == 'Y')
			{
				object.menuMethod();
			}
			else
			{
				System.exit(0);
			}
		}while(choice == 'y' || choice == 'Y');
		}
		catch(Exception e)
		{
			System.out.println("Unable to execute..." +e.getMessage());			//printing error message(if any).
		}
	}
}
