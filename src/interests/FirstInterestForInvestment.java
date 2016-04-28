package interests;

import product.Credit;
import product.Investment;

public class FirstInterestForInvestment extends InterestMechanism {

	private double percentage;
	public FirstInterestForInvestment(Investment inv) {
		product = inv;
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
		
		Investment investment = (Investment)product;
		if (investment.getBalance()> 0 && !investment.getIsOpen()){
			product.setBalance(product.getBalance() + (product.getBalance()*percentage));
		}		
	}
}
