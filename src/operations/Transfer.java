package operations;

import java.util.Calendar;

import product.Account;
import product.Product;

 

public class Transfer extends Operation {

	private Product destinationAccount;
	private double amount;
	private double currentBalance;
    private double maxdebit;
	//przelew type=3
    /**
	 * @param amount kwota przelewu
	 * @param numberAccount nr konta do przelewu
	 * @param maxdebit kwota maksymalnego debetu
	 * @param currentBalance aktualne saldo konta
	 */
	public Transfer(double amount,Product destinationAccount,double maxdebit,double currentBalance) {
	 
		this.type=3;
		this.amount=amount;
		this.destinationAccount=destinationAccount;
	    this.currentBalance=currentBalance;
	    this.maxdebit=maxdebit;
	    this.description="operacja przelewu";
	}
	 
	public Double execute() throws Exception{
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		
		if (currentBalance + maxdebit >= amount){
			destinationAccount.setBalance(destinationAccount.getBalance() + amount);
			return currentBalance-amount;
		}else{
			throw new Exception();
		}
			
		
	}

}
