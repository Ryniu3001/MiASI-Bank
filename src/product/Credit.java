package product;

import java.util.List;

import client.InterestMechanism;
import operations.Operation;
import operations.RefundCredit;

public class Credit extends Product {

	//flaga informuje czy kredyt jest sp�acony
	private Boolean isRefund;
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
	}
	//operacja sp�aty kredytu
	public void refundCredit(List<Operation> bankHistoryOperation)
	{
		//sprawdzi� czy account.balance wystarczy na sp�ate kredytu jesli tak pobierz z konta kase
		RefundCredit refundCredit=new RefundCredit(account,this);
		refundCredit.execute();
	 
		addOperationToHistory(bankHistoryOperation,refundCredit);
		account.PayOff(balance, bankHistoryOperation);
		this.isRefund=true;
	}
}
