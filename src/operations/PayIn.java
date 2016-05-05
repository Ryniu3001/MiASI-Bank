package operations;

import java.util.Calendar;

import product.Account;
import product.IAccount;

 

public class PayIn extends Operation {

	
	private double amount;
	private IAccount to;
    
	public PayIn(IAccount to,double amount) {
	 
		this.to=to;
		this.amount=amount;
	     
	}
	 
	public void execute() throws Exception {
	 
		 to.addBalance(amount);
	}

}
