package operations;

import java.util.Calendar;

 

public class Transfer extends Operation {

	private String numberAccount;
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
	public Transfer(double amount,String numberAccount,double maxdebit,double currentBalance) {
	 
		this.type=3;
		this.amount=amount;
		this.numberAccount=numberAccount;
	    this.currentBalance=currentBalance;
	    this.maxdebit=maxdebit;
	    this.description="operacja przelewu";
	}
	 
	public double execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return currentBalance-amount;
		
	}

}
