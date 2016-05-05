package interests;

import product.AccountDecorator;
import product.Account;

public class FirstInterestForAccount extends InterestMechanism {
		
	private double percentage;
	public FirstInterestForAccount(Account account) {
		product = account;
	}
	

	@Override
	public void calculate() {
		if (product.getBalance() <= 1000){
			percentage = 0.05;
		}else if (product.getBalance() > 1000 && product.getBalance() <= 5000){
			percentage = 0.3;
		}else{
			percentage = 0.5;
		}
		
		if (product.getBalance()> 0){
			product.setBalance(product.getBalance() + (product.getBalance()*percentage));
		}		
	}

}
