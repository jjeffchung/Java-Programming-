import java.util.*;

public class BankAccount {

	Scanner input = new Scanner(System.in);

	// Declaring the instance variables

	private String accountOwnerName, accountID;

	private Double balanceInAccount;

	private int interestRate;

	
	// Setting the constructor

	public BankAccount(String initialaccountOwnerName, String initialaccountID, Double initialbalanceInAccount,
			 int initialinterestRate) {

		accountOwnerName = initialaccountOwnerName;

		accountID = initialaccountID;

		balanceInAccount = initialbalanceInAccount;

		interestRate = initialinterestRate;
		
		
	}

	// Setting the getters

	public String getAccountOwnerName() {
		return accountOwnerName;
	}

	public String getAccountID() {
		return accountID;
	}

	public Double getBalanceInAccount() {
		return balanceInAccount;
	}

	public int getinterestRate() {
		return interestRate;
	}
	

	
	// Setting the setters

	public void setAccountOwnerName(String newAccountOwnerName) {
		accountOwnerName = newAccountOwnerName;
	}

	public void setAccountID(String newAccountID) {
		accountID = newAccountID;
	}

	public void setBalanceInAccount(Double newBalanceInAccount) {
		if (newBalanceInAccount > 0.0) {   
			balanceInAccount = newBalanceInAccount;
		} else if (newBalanceInAccount <= 0.0) {// Has to be greater than zero. Cannot be negative.
			System.out.println("Sorry, your balance cannot be 0 or less than 0.");
		}
	}
	
	 public void setUserDeposit (double newuserdeposit)	{
		 if (newuserdeposit <=0){
			 System.out.println("You cannot deposit a balance of 0 or less than 0.");
		 }else{
			 balanceInAccount += newuserdeposit;
		 }
	 }
	 
	 public void setUserWithdraw (double newuserwithdraw)	{
		 if (newuserwithdraw <=0){
			 System.out.println("You cannot withdraw a balance of 0 or less than 0.");
		 }else if (newuserwithdraw>balanceInAccount){
			 System.out.println("You cannot withdraw more than the current balance in your account.");	//User cannot withdraw more than balance in account as there will be a negative	 
		 }else{
			
			 balanceInAccount -= newuserwithdraw; 
		 }
	 }
	 
	public void setInterestRate(int newInterestRate) {
		if (newInterestRate <= 0) {
			System.out.println("The interest rate has be to be greater than 0.");
		} else if (newInterestRate > 0) {
			interestRate = newInterestRate;     // The interest rate has to be greater than 0 to be usable. 
										
		}
	
	 
	}

	// Setting the toString method

	public String toString() {
		String a = "Account Owner Name: " + accountOwnerName + "\n\tAccount ID: " + accountID
				+ "\n\tPreferred Interest Rate: " + interestRate + "\n\tBalance in Account: " + balanceInAccount;
		return a;
	}

	public void currentaccountdetails() { // Provides current account details prior to withdrawing and depositing any amount and without interest rate.
									
		System.out.println("Welcome " + accountOwnerName+".");
		System.out.println("Your Account ID is: " + accountID);
		System.out.println("Your current balance is: " + balanceInAccount);
		System.out.println(" "); //To create better visual clarity for the user
	}
	
	public void withinterestdetails(){
		System.out.println("Your chosen interest rate is: " + interestRate + "%");
		Double updatedbalancewithinterest = ((balanceInAccount * interestRate) / 100) + balanceInAccount;
		System.out.println("Your current balance with a " + interestRate + "% interest rate added is: $"
				+ updatedbalancewithinterest);
	}

	public void accountwithdrawal() {
		
		   // Balance in account - amount user withdrew																																																																																							
		Double updatedloweredbalance = ((balanceInAccount * interestRate) / 100) + balanceInAccount;
		System.out.println("Your new balance is: $" + updatedloweredbalance); // printing the user's updated account balance
		System.out.println(" ");  //To create better visual clarity for the user
	}
}
