package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class BreakInvestment extends Operation {

	
	private Investment investment;
	 
    
	public BreakInvestment(Investment investment) {
		this.investment = investment;  
	}
	 
	public void execute() {
		
		//tutaj trzeba obliczyc odsetki i je dodac
		this.investment.getAccount().addBalance(investment.getBalance());
		investment.closeProduct();
		 
	}

}
