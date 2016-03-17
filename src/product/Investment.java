package product;

 
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		 
	}
	public void BreakInvestment(List<Operation> bankHistoryOperation)
	{
		//zwywamy lokate po uplynieciu czasu - naliczamy odsetki
		//należałoby to jakoś zautomatyzować
		if (Calendar.getInstance().getTime().after(dateEnd)){
			this.balance += 0.1 * this.balance;
		}
		
		BreakInvestment breakInvestment=new BreakInvestment(account);
		isRefund = breakInvestment.execute();
		addOperationToHistory(breakInvestment);
	}
}
