package operations;

import java.util.Calendar;

import product.Account;

 

public class PayOff extends Operation {

	
	private double amount;
	private Account from;
    
	public PayOff(Account from,double amount) {
	 
		this.from=from;
		this.amount=amount;
	     
	}
	 
	public void execute() throws Exception {
	 
		 from.substractBalance(amount);
	}

}
