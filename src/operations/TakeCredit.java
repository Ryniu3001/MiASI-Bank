package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;
 

 

public class TakeCredit extends Operation {

	
	 
	private Credit credit;
	 
    
	public TakeCredit(Credit credit) {
	 
		 credit=credit;
	     
	}
	 
	public void execute() {
		
		 
		this.credit.getAccount().addBalance(credit.getBalance());
	 
		 
	}

}