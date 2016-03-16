package operations;

import java.util.Calendar;

 

public class PayIn extends Operation {

	
	private double amount;
	private double currentBalance;//balance before operation
   
	//wp³ata type=1
    /**
	 * @param amount kwota wp³aty
	 * @param currentBalance aktualne saldo konta
	 */
	public PayIn(double amount,double currentBalance) {
	 
		this.type=1;
		this.amount=amount;
		this.currentBalance=currentBalance;
	     
	}
	 
	public double execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return currentBalance+amount;
	}

}
