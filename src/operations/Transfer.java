package operations;

import java.util.Calendar;

import product.Account;

 

public class Transfer extends Operation {

	private Account destinationAccount;
	private Account sourceAccount;
	private double amount;

	//przelew type=3
    /**
	 * @param amount kwota przelewu
	 * @param numberAccount nr konta do przelewu
	 * @param maxdebit kwota maksymalnego debetu
	 * @param currentBalance aktualne saldo konta
	 */
	public Transfer(Account sourceAccount, double amount,Account destinationAccount) {
	 
		this.type=3;
		this.amount=amount;
		this.destinationAccount=destinationAccount;
		this.sourceAccount = sourceAccount;
	   // this.currentBalance=currentBalance;
	    //this.maxdebit=maxdebit;
	    this.description="operacja przelewu";
	}
	 
	public Void execute() throws Exception{
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		
		if (sourceAccount.getBalance() + sourceAccount.getDebit() >= amount){
			destinationAccount.setBalance(destinationAccount.getBalance() + amount);
			sourceAccount.setBalance(sourceAccount.getBalance()- amount); 
		}else{
			throw new Exception();
		}
		
		return null;
			
		
	}

}
