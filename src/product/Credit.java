package product;

import client.Interest;

public class Credit extends Product {

	//flaga informuje czy kredyt jest sp³acony
	private Boolean isRefund;
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
	}
	//operacja sp³aty kredytu
	public void refundCredit()
	{
		//sprawdziæ czy account.balance wystarczy na sp³ate kredytu jesli tak pobierz z konta kase
		//account.PayOff(amount, bankHistoryOperation);
		this.isRefund=true;
	}
}
