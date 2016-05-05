package productsState;

 
import product.Account;

public class AccountOpen implements IAccountState {

	public void addBalance(Account account,double amount) {
		account.setBalance(account.getBalance()+amount);
	}

	public void substractBalance(Account account,double amount) {
        if(account.getBalance() >= amount) {
        	account.setBalance(account.getBalance()-amount);
        } else {
            throw new RuntimeException("Too small balance");
        }
	}
}
