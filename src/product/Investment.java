package product;

 
import java.util.Date;
import java.util.List;

import operations.Operation;
import operations.BreakInvestment;
import product.Account;

public class Investment extends Product {

 
	//flaga informuje czy lokata jest zakonczona
	private Boolean isRefund;
	private Account account;
	private Date dateEnd;
	public Investment(double balance,Account account) {
		super(balance);
		this.account=account;
		//ustawienie daty zakonczenia lokaty
		 
	}
	public void BreakInvestment(List<Operation> bankHistoryOperation)
	{
		BreakInvestment breakInvestment=new BreakInvestment(account);
		breakInvestment.execute();
		addOperationToHistory(bankHistoryOperation,breakInvestment);
	}
}
