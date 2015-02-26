import java.util.Date;
import java.util.Scanner;

class Account
{
	
	private int id;
	public static double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();


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

	public void setId(int id)
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

	public void setDateCreated(Date dateCreated)
	{
		this.dateCreated = dateCreated;
	}


	public static double getMonthlyInterestRate(double annualInterestRate)
	{
		return ((annualInterestRate)/12*100);
	}

	public double Withdraw(double wd)
	{
		balance = balance-wd;
		return balance;
	}

	public double deposit(double dp)
	{
		balance = balance+dp;
		return balance;
	}


}

class CheckingAccount extends Account
{

	private double overDraft;
	public CheckingAccount(int id, double balance, double annualInterestRate,double overDraft) {
		super(id, balance, annualInterestRate);
		this.overDraft = overDraft;
	}	
	public double withdraw(double withdraw)
	{
		balance=balance-withdraw;
		if(balance<overDraft)
		{
			System.out.print("\n Withdraw can't be done. The Amount of Withdrawn balance is below in Overdraft limit which is $"+overDraft+" ." );
			balance = balance+withdraw;
		}
		return balance;
	}
}

class SavingsAccount extends Account
{
	private double overDraft;
	public SavingsAccount(int id, double balance, double annualInterestRate,double overDraft)
	{
		super(id, balance, annualInterestRate);
		this.overDraft = overDraft;
	}

	public double withdraw(double withdraw)
	{
		balance=balance-withdraw;
		if(balance<overDraft){
			System.out.print("\n Withdrawal can't be done. The Amount of Withdrawn Balance is below in Overdraft limit which is $" +overDraft+ " .");
			balance=balance+withdraw;
		}
		return balance;
	}
}







