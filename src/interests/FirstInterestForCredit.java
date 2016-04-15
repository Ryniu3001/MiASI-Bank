package interests;

import product.Account;
import product.Credit;

public class FirstInterestForCredit extends InterestMechanism {

	private double percentage;
	public FirstInterestForCredit(Credit credit) {
		product = credit;
	}
	
	@Override
	public void calculate() {
		if (product.getBalance() <= 1000){
			percentage = 0;
		}else if (product.getBalance() > 1000 && product.getBalance() <= 5000){
			percentage = 0.01;
		}else{
			percentage = 0.05;
		}
		
		if (product.getBalance()> 0){
			product.setBalance(product.getBalance() + (product.getBalance()*percentage));
		}		
	}

}
