package operations;

import java.util.Calendar;

import product.Account;
import product.IAccount;

 

public class PayOff extends Operation {

	
	private double amount;
	private IAccount from;
    
	public PayOff(IAccount from,double amount) {
	 
		this.from=from;
		this.amount=amount;
	     
	}
	 
	public void execute() throws Exception {
	 
		 from.substractBalance(amount);
	}

}
