package productsState;

import product.Account;

public interface IAccountState {

	public void addBalance(Account account,double amount);
	public void substractBalance(Account account,double amount);
	
}
