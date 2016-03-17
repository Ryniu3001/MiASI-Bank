package operations;

import java.util.Calendar;

import product.Account;
import product.Investment;

 

public class Deposit extends Operation {

	
	private double amount;
	private Account account;
	private int months;
   
	//operacja utworzenia lokaty type=6
	/**
	 * Utworzenie nowej lokaty
	 * @param amount	saldo początkowe
	 * @param account	konto źródłowe
	 * @param months	czas w miesiącach
	 */
	public Deposit(double amount,Account account, int months) {
	 
		this.type=6;
		this.amount=amount;
	    this.account=account;
	    this.description="operacja utworzenia lokaty";
	}
	 
	public Investment execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		Investment investment=new Investment(amount, account, months);
		account.setBalance(account.getBalance() - amount);
		return investment;
	}

}