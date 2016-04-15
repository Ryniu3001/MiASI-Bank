package interests;

import product.Account;

public class SecondInterestForAccount extends InterestMechanism {
	private double percentage;
	public SecondInterestForAccount(Account account) {
		product = account;
	}
	
	@Override
	public void calculate() {
		if (product.getBalance() <= 1000){
			percentage = 0.1;
		}else if (product.getBalance() > 1000 && product.getBalance() <= 5000){
			percentage = 0.2;
		}else{
			percentage = 0.3;
		}
		
		if (product.getBalance()> 0){
			product.setBalance(product.getBalance() + (product.getBalance()*percentage));
		}		
	}
}
