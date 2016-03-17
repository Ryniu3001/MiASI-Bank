package operations;

import java.util.Calendar;

import product.Account;
import product.Credit;

 

public class RefundCredit extends Operation {

	
	private Credit credit;
	private Account account;
	private double amount;
	//spłata kredytu
    
	public RefundCredit(Account account,Credit credit, double amount) {
	 
		this.type=9;
		this.account=account;
		this.credit=credit;
		this.description="operacja spłaty kredytu";
		this.amount = amount;
	     
	}
	 
	public Boolean execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();	
		
		if (credit.getBalance() - amount >= 0){
			credit.setBalance(credit.getBalance() - amount);
			account.setBalance(account.getBalance() - amount);
		}else{
			account.setBalance(account.getBalance() - credit.getBalance());
			credit.setBalance(0);
		}
		
		return credit.getBalance() == 0;
	}

}