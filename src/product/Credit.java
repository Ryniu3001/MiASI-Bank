package product;

import interests.FirstInterestForCredit;
import operations.RefundCredit;

public class Credit extends Product {

	 
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
		this.interestMechanism = new FirstInterestForCredit(this);
		
	}
	public Account getAccount()
	{
		return account;
	}
}
