package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class CreateInvestment extends Operation {

	private Investment investment;
	 
	public CreateInvestment(Investment investment) {
	 

		 this.investment=investment;
	}
	
	public void execute() throws Exception
	{
		if(this.investment.getIsActive())
			this.investment.getAccount().substractBalance(investment.getBalance());
 

	}
}