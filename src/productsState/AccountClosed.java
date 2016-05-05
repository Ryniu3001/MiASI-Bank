package productsState;


import product.Account;

 

public class AccountClosed implements IAccountState {
	
	public void addBalance(Account account,double amount) {
		throw new RuntimeException("This account is closed");
	}

	public void substractBalance(Account account,double amount) {
		throw new RuntimeException("This account is closed");
	}

	 
}
