package product;

import interests.FirstInterestForCredit;
import operations.RefundCredit;

public class Credit extends Product {

	//flaga informuje czy kredyt jest spłacony
	private Boolean isRefund;
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
		this.interestMechanism = new FirstInterestForCredit(this);
	}
	//operacja spłaty kredytu
	public void refundCredit(double amount)
	{
		//sprawdzić czy account.balance wystarczy na spłate kredytu jesli tak pobierz z konta kase
		if (account.getBalance() >= amount){
			RefundCredit refundCredit=new RefundCredit(account,this, amount);
			try {
				isRefund = refundCredit.execute();
			} catch (Exception e) {
				System.out.println("Kredyt nalezy splacic jedna rata");
			}
			addOperationToHistory(refundCredit);

		}
	 
		account.setBalance(account.getBalance() - amount);
	}
}
