import java.util.Date;

public class Account 
{
	private int id;                   //A private int data field named id for the account.
	private static double balance;				//A private double data field named balance for the account.
	private double annualInterestRate;	//A private double data field named annualInterestRate that stores the current interest rate.			
	Date dateCreated = new Date();        //private Date data field named dateCreated that stores the date when the account was created.
	public Account()
	{
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}
	public Account(int id, double balance, double annualInterestRate)
	{
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setId(Account acc)
	{
		this.id = id;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	public void setAnnualInterestRate(double annualInterestRate)
	{
		this.annualInterestRate = annualInterestRate;
	}
	public int getId()
	{
		return id;
	}
	public double getBalance()
	{
			return balance;
	}
	public double getAnnualInterestRate()
	{
			return annualInterestRate;
	}
	public Date getDateCreated()
	{
		return dateCreated;
	}
	public double getAnnualInterest(double annualInterestRate)
	{
		double annualInterest = ((this.balance * this.annualInterestRate) / 100);
		return annualInterest;
	}
	public double getMonthlyInterestRate(double annualInterestRate)
	{
			double monthlyInterest;
			return monthlyInterest = (annualInterestRate / 12) * 100;  
	}
	public double deposit(double deposit1)
	{
		
		return balance = balance + deposit1;
	}
	public double withdraw(double wDraw)
	{
		if(balance >= wDraw)
		{
			balance = balance - wDraw;
			
		}
		return balance;
		
	}
public static void main(String args[])
{
		Account account = new Account(1122,20000,4.5);
		System.out.println("Your account actual balance is: " +account.getBalance());
		System.out.println("Your account balance after your recent withdrawal is: " +account.withdraw(500));
		System.out.println("Your Account balance after your deposit is: " +account.deposit(600));
		System.out.println("YOur monthly interest rate is: " +account.getMonthlyInterestRate(4.5));
}	
}
