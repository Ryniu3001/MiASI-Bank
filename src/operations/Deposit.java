package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class Deposit extends Operation {

	
	private double amount;
	private Account account;
   
	//operacja utworzenia lokaty type=6
    /**
	 * @param amount kwota wp³aty
	 * @param currentBalance aktualne saldo konta
	 */
	public Deposit(double amount,Account account) {
	 
		this.type=1;
		this.amount=amount;
	    this.account=account;
	     
	}
	 
	public Investment execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		Investment investment=new Investment(amount,account);
		return investment;
	}

}