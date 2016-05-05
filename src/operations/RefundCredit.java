package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;

 

public class RefundCredit extends Operation {

	
	private Credit credit;

    
	public RefundCredit(Credit credit) { 
		this.credit=credit; 
	}
	 
	public void execute() {			 
		this.credit.getAccount().substractBalance(credit.getBalance());	 
	}

}