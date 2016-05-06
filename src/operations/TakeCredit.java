package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;
 

 

public class TakeCredit extends Operation {

	
	 
	private Credit credit;
	 
    
	public TakeCredit(Credit credit) {
	 
		 this.credit=credit;
	     
	}
	 
	public void execute() throws Exception {
		
		 if(this.credit.getIsActive()){
			 this.credit.getAccount().addBalance(credit.getBalance());
		 }
		 else
			 throw new RuntimeException("This product is disactive");
		 
	 
		 
	}

}