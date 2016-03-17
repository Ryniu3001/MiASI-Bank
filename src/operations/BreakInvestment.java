package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class BreakInvestment extends Operation {

	
	private Investment investment;
	private Account account;
	 
    
	public BreakInvestment(Account account) {
	 
		this.type=7;
		 
		this.description="operacja zerwania lokaty";
	     
	}
	 
	public Boolean execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		account.setBalance(account.getBalance() + investment.getBalance());
		return true;
		 
	}

}
