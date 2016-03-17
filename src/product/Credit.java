package product;

import operations.RefundCredit;

public class Credit extends Product {

	//flaga informuje czy kredyt jest spłacony
	private Boolean isRefund;
	private Account account;
	public Credit(double balance,Account account) {
		super(balance);
		this.account=account;
	}
	//operacja spłaty kredytu
	public void refundCredit(double amount)
	{
		//sprawdzić czy account.balance wystarczy na spłate kredytu jesli tak pobierz z konta kase
		if (account.getBalance() + account.getDebit() >= amount){
			RefundCredit refundCredit=new RefundCredit(account,this, amount);
			isRefund = refundCredit.execute();
			addOperationToHistory(refundCredit);

		}
	 
		account.setBalance(account.getBalance() - amount);
	}
}
