package product;

 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import interests.FirstInterestForInvestment;
import operations.BreakInvestment;
import operations.Operation;

public class Investment extends Product {

 
	//flaga informuje czy lokata jest zakonczona
	private Boolean isRefund;
	private Account account;
	private Date dateEnd;
	
	public Investment(double balance,Account account, int months) {
		super(balance);
		this.account=account;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.startDate);
		cal.add(Calendar.MONTH, months);
		dateEnd = cal.getTime();
		this.interestMechanism = new FirstInterestForInvestment(this);
		 
	}
	public void BreakInvestment(List<Operation> bankHistoryOperation)
	{
		BreakInvestment breakInvestment=new BreakInvestment(account, this);
		isRefund = breakInvestment.execute();
		addOperationToHistory(breakInvestment);
	}
	public Boolean getIsRefund() {
		return isRefund;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	
	
}
