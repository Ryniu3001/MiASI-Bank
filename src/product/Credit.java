package product;

import client.Client;
import interests.FirstInterestForCredit;
import report.Visitor;

public class Credit extends Product {

	private boolean isActive;
	private Account account;
	public Credit(double balance,Account account,Client client) {
		super(balance,client);
		this.account=account;
		this.interestMechanism = new FirstInterestForCredit(this);
		this.isActive=true;
	}
	public Account getAccount()
	{
		return account;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	public boolean getIsActive()
	{
		return isActive;
	}
	public void setIsActive(boolean isActive)
	{
		 this.isActive=isActive;;
	}
}
