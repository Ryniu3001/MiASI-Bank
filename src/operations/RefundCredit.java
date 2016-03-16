package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;
import product.Investment;

 

public class RefundCredit extends Operation {

	
	private Credit credit;
	private Account account;
	//sp�ata kredytu
    
	public RefundCredit(Account account,Credit credit) {
	 
		this.type=9;
		this.account=account;
		this.credit=credit;
		this.description="operacja sp�aty kredytu";
	     
	}
	 
	public void execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();		 
	}

}