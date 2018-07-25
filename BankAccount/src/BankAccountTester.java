import java.util.*;

public class BankAccountTester {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please, enter your name: "); // Prompting user to enter name															
		String accountOwnerName = input.nextLine();

		
		System.out.println("Please, enter your account ID: "); // Prompting user for account ID																															
		String accountID = input.nextLine();
		

		System.out.println("Please, enter your balance: "); // Prompting user for initial balance to set account 																																											
		Double balanceInAccount = input.nextDouble();
		

		System.out.println("Please, add a preferred interest rate:"); // Prompting user for an interest rate to add																																																																																																					
		int interestRate = input.nextInt();
		
		System.out.println("Thank you setting up an account with us " + accountOwnerName + "."); // Adds a good	user interactivity																							
																																																																										

		System.out.println(" "); // Creating a space in between the menu options for the user to provide better visual clarity
		
			
		
		BankAccount userAcc = new BankAccount(accountOwnerName, accountID, balanceInAccount,interestRate);

		boolean Banktransaction = true;

		while (Banktransaction) {               // List of options for the user to choose from
			System.out.println("Press 1 to view current account details:");
			System.out.println("Press 2 to make a deposit:");
			System.out.println("Press 3 to make a withdrawal:");
			System.out.println("Press 4 to view account balance with preferred interest rate:");
			System.out.println("Press 5 to quit the program:");

			int userChoice = input.nextInt();

			switch (userChoice) {
			case 1:
				userAcc.currentaccountdetails(); // To print the current account details to the user									
				break;
					
			case 2:
				System.out.println("Please, enter an amount to deposit to account."); //To make a deposit to the account 
				Double userdeposit=input.nextDouble(); 
				userAcc.setUserDeposit(userdeposit); 	
				break;

			case 3:
				System.out.println("Please, enter an amount to withdraw from account.");	
				Double userwithdraw=input.nextDouble(); 
				userAcc.setUserWithdraw(userwithdraw); // To make a withdrawal from the account										
				break;
				
			case 4:
				userAcc.withinterestdetails(); // To print the account balance with interest rate calculated  									
				break;

			case 5:
				System.out.println("Thank you for banking with us " +accountOwnerName+"." + " We hope to see you soon."); // To quit the program when done																																																																																																																						
				return;
			}

		}

	}
}
