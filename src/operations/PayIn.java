package operations;

import java.util.Calendar;

import product.Account;

 

public class PayIn extends Operation {

	
	private double amount;
	private Account to;
    
	public PayIn(Account to,double amount) {
	 
		this.to=to;
		this.amount=amount;
	     
	}
	 
	public void execute() throws Exception {
	 
		 to.addBalance(amount);
	}

}
