package product;
 

import operations.Transfer;

public class Account extends Product {

	//mechanizm debetowy
	private double debit;
	/**
	 * @param balance saldo poczatkowe
	 * @param debit maksymalna kwota debetu
	*/
	public Account(double balance,double debit) {
		super(balance);
		this.debit=debit;
	}
	public double getDebit()
	{
		return debit;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
}
