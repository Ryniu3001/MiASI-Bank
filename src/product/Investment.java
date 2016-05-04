package product;

 
import java.util.Calendar;
import java.util.Date;

import interests.FirstInterestForInvestment;
import report.Visitor;

public class Investment extends Product {

 
	//flaga informuje czy lokata jest zakonczona
	 
	private Account account;
	private Date dateEnd;
	private int months;
	
	public Investment(double balance,Account account, int months) {
		super(balance);
		this.account=account;
		this.months=months;
		this.interestMechanism = new FirstInterestForInvestment(this);
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.startDate);
		cal.add(Calendar.MONTH, months);
		dateEnd = cal.getTime();
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
	
}
