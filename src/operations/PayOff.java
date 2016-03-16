package operations;

import java.util.Calendar;

 

public class PayOff extends Operation {

	
	private double amount;
	private double currentBalance;//balance before operation
 
	//wyp³ata type=2
    /**
	 * @param amount kwota wyp³aty
	 * @param currentBalance aktualne saldo konta
	 */
	public PayOff(double amount,double currentBalance) {
	 
		this.type=1;
		this.amount=amount;
		this.currentBalance=currentBalance;
	     
	}
 
	public double execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return currentBalance-amount;
		
	}

}
