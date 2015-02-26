import java.util.Scanner;

public class TestAccount{
	
	public static void main(String args[]){	
		double wd1,d1;
	Scanner input = new Scanner(System.in);
	Account ac = new Account(1122,20000,4.5);
	System.out.println("Your Account number is  " +ac.getId());
	System.out.println("Your Balance amount is  " +ac.getBalance());
	System.out.println("Your Annual Rate of Interest is " +ac.getAnnualInterestRate());
	System.out.println("Enter the amount you want to withdraw  ");
	wd1 = input.nextDouble();

	System.out.println("The current Amount is:   "+ac.Withdraw(wd1));
	System.out.println("Enter the amount you want to deposit  ");
	d1 = input.nextDouble();
	
	
	System.out.println("The Current Amount is:  "+ac.deposit(d1) ); 
	System.out.println("The Monthly Interest Calculated is " + ac.getMonthlyInterestRate(4.5) );
	System.out.println("The Current Date is: " +ac.getDateCreated());
	
	System.out.print("\nEnter 1 to access Saving Account and 2 to access Checking Accout: ");
	int choice1 = input.nextInt();
	System.out.print("\nEnter 1 to Withdraw and 2 to Deposit: ");
	int choice2 = input.nextInt();
	
	CheckingAccount ca=new CheckingAccount(1122,20000,4.5,-100.0);
	SavingsAccount sa=new SavingsAccount(1122,20000,4.5,0.0);
	
	if (choice1==1 && choice2==1){
		System.out.print("Enter the amount you want to withdraw: $");
		double amount = input.nextDouble();
		System.out.print("\nYour Current Balance is= $"+sa.withdraw(amount));
		
	}
	
	else if(choice1==1 && choice2==2){
		System.out.print("Enter the amount you want to deposit: $");
		double amount=input.nextDouble();
		System.out.print("Your Current Balance is= $"+ac.deposit(amount));
		
	}
	
	else if (choice1==2 && choice2==1){
		System.out.print("Enter the amount you want to withdraw: $");
		double amount=input.nextDouble();
		System.out.print("Your Current Balance is= $"+ca.withdraw(amount));
    }
	
	else if(choice1==2 && choice2==2){
		System.out.print("Enter the amount you want to deposit: $");
		double amount=input.nextDouble();
		System.out.print("Your Current Balance is= $"+ac.deposit(amount));
		
	}
	
	else{
		
		System.out.print("Invalid Number");
		
	}
}
}