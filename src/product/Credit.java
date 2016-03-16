package product;

import client.Interest;

public class Credit extends Product {

	//flaga informuje czy kredyt jest sp�acony
	private Boolean isRefund;
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
	}
	//operacja sp�aty kredytu
	public void refundCredit()
	{
		//sprawdzi� czy account.balance wystarczy na sp�ate kredytu jesli tak pobierz z konta kase
		//account.PayOff(amount, bankHistoryOperation);
		this.isRefund=true;
	}
}
