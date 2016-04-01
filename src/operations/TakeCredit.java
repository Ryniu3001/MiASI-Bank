package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;
 

 

public class TakeCredit extends Operation {

	
	 
	private Account account;
	private double amount;
   
	//zaciagniecie kredytu
    
	public TakeCredit(Account account,double amount) {
	 
		this.type=8;
		this.account=account;
		this.amount=amount;
		this.description="operacja zaciagniecia kredytu";
	     
	}
	 
	public Credit execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		account.payIn(amount);
		return new Credit(amount,account);
	}

}