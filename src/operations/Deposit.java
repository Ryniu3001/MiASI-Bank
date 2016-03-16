package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class Deposit extends Operation {

	
	private double amount;
	private Account account;
   
	//operacja utworzenia lokaty type=6
	public Deposit(double amount,Account account) {
	 
		this.type=6;
		this.amount=amount;
	    this.account=account;
	    this.description="operacja utworzenia lokaty";
	}
	 
	public Investment execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		Investment investment=new Investment(amount, account);
		return investment;
	}

}