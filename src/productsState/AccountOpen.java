package productsState;

 
import product.Account;

public class AccountOpen implements IAccountState {

	public void addBalance(Account account,double amount) {
		if(amount>0)
			account.setBalance(account.getBalance()+amount);
		else
			throw new RuntimeException("The amount was incorrect");
	}

	public void substractBalance(Account account,double amount) {
		if(amount>0)
        if(account.getBalance() >= amount) {
        	account.setBalance(account.getBalance()-amount);
        } else {
            throw new RuntimeException("Too small balance");
        }
		else
			throw new RuntimeException("The amount was incorrect");
	}
}
