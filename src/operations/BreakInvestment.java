package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class BreakInvestment extends Operation {

	
	private Investment investment;
	private Account account;
	 
    
	public BreakInvestment(Account account, Investment investment) {
	 
		this.type=7;
		this.description="operacja zerwania lokaty";
		this.account = account;
		this.investment = investment;
	     
	}
	 
	public Boolean execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		//TODO: Nalezy zastosowac jakis mechanizm odstekowy i przypisac go do klasy Investment
		if (this.date.before(investment.getDateEnd())){
			account.payIn(investment.getBalance());
		}else{
			account.payIn(investment.getBalance() * 1.1);
		}
		investment.setBalance(0);
		return true;
		 
	}

}
