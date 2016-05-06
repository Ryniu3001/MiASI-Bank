package product;

import operations.Operation;
import report.Visitor;

public class AccountDebet extends AccountDecorator {
	 
	private double maxDebet;
	private double currentDebet;
	public AccountDebet(Account account,double maxDebet) {
		super(account);
		this.maxDebet=maxDebet;
		 
	}
	
	@Override
	public void addBalance(double amount) {
		if(amount>0){
			if(currentDebet>0)
				if(amount>currentDebet){
					this.account.getState().addBalance(this.account, amount-currentDebet);
					currentDebet=0;					 
				}
				else
				{
					currentDebet-=amount;
				}
			else
				this.account.getState().addBalance(this.account, amount);
			this.setBalance(this.account.getBalance());
		}
		else
				 throw new RuntimeException("The amount was incorrect");
	}
	@Override
	public void substractBalance(double amount) {
		if(amount>0){
			if(account.getBalance()>=amount)
				this.account.getState().substractBalance(this.account, amount);
			else
			{
				if(account.getBalance()+maxDebet-currentDebet>=amount){
					this.currentDebet+=(account.getBalance()-amount)*-1;
					//wyplac z konta ile się da 
					this.account.getState().substractBalance(this.account, account.getBalance());
					
				}
				else
				{
					  throw new RuntimeException("Przekroczono maksymalny debet");
				}
				
			}
			this.setBalance(this.account.getBalance());
		}
		else
			 throw new RuntimeException("The amount was incorrect");
		
	}
	public double getCurrentDebet()
	{
		return currentDebet;
	}

	 

}
