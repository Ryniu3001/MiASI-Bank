package product;

 
import java.util.Calendar;
import java.util.Date;

import client.Client;
import interests.FirstInterestForInvestment;
import report.Visitor;

public class Investment extends Product {

 
	//flaga informuje czy lokata jest zakonczona
	private boolean isActive;
	private Account account;
	private Date dateEnd;
	private int months;
	
	/**
	 * @param balance
	 * kwota lokaty
	 * @param account
	 * konto z którym powiązana jest lokata
	 * @param months
	 * ilosc mc lokaty
	 */
	public Investment(double balance,Account account, int months,Client client) {
		super(balance,client);
		this.account=account;
		this.months=months;
		this.interestMechanism = new FirstInterestForInvestment(this);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, months);
		this.dateEnd = cal.getTime();
		this.isActive=true;
	}
 

	public Date getDateEnd() {
		return dateEnd;
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
