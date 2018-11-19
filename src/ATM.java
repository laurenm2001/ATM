import java.util.Scanner;
public class ATM {
	
	private Account account;
	
	public ATM(Account account) {
		this.account = account;
	}
	public void Menu() {
		Scanner in = new Scanner(System.in);
		int pin = 0;
		long acc = 0;
		while(pin != account.getUser().getPIN() || acc != account.getAccountNumber()) {
		System.out.print("Welcome to APCSA ATM, the ATM of choice for the UCVTS community.\nTo begin, please enter a valid account number.\nAccount # : ");
		acc = in.nextLong();
		System.out.print("Pin # : ");
		pin = in.nextInt();
		}
		if(pin == account.getUser().getPIN() && acc == account.getAccountNumber()) {
			//System.out.println(account.getOwner.getName());
			System.out.println("   [1] Deposit\n" + 
					"   [2] Withdraw\n" + 
					"   [3] View Balance\n" + 
					"   [4] Exit\n");
			int option = 0;
			while(option != 4) {
				option = in.nextInt();
				if(option == 1) {
					double amount = in.nextDouble();
					if(amount > 0){
						account.deposit(amount);
						System.out.println(account.getBalance());
					}else {
						System.out.println("You have to deposit an amount greater than 0");
					}
				}else if(option == 2) {
					int amount = in.nextInt();
					if (amount <= account.getBalance()) {
						account.withdraw(amount);
						System.out.println(account.getBalance());}
					else {
						System.out.println("You cannot withdraw more than your account holds");
					}
				}else if(option == 3) {
					System.out.println(account.getBalance());
				}else if(option == 4) {
					System.out.println("Goodbye!");
				}else {
					System.out.println("Please input one of the four options");
				}
			}
		}else {
			System.out.println("Please input the right Account Number and Pin");
		}
		in.close();
	}

	
	
	
	
	public static void main(String[] args) {
		ATM atm = new ATM(
				new Account(						// create new BankAccount
					0,							// initial balance is 0
					new User(						// create new User
						1234,						// PIN is 1234
						"Ryan Wilson",					// name is Ryan Wilson
						"January 1, 1970",				// date of birth is January 1, 1970
						"123 Main St., Scotch Plains, NJ 07076"		// address is 123 Main St., Scotch Plains, NJ 07076
					)
				)
			);
		atm.Menu();
	}
}