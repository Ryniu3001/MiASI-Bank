package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class BreakInvestment extends Operation {

	
	private Investment investment;
	 
    
	public BreakInvestment(Investment investment) {
		this.investment = investment;  
	}
	 
	public void execute() throws Exception {
		if(this.investment.getIsActive()){
			
			this.investment.getAccount().addBalance(investment.getBalance());
			this.investment.setIsActive(false);
		}else
			
		{
				 throw new RuntimeException("This product is disactive");
		}
		 
	}

}
