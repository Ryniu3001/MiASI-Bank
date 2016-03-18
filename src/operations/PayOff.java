package operations;

import java.util.Calendar;

 

public class PayOff extends Operation {

	
	private double amount;
	private double currentBalance;//balance before operation
	 private double maxdebit;
	//wyp�ata type=2
 
	public PayOff(double amount,double currentBalance,double maxdebit) {
	 
		this.type=2;
		this.amount=amount;
		this.currentBalance=currentBalance;
		this.maxdebit = maxdebit;
		this.description="operacja wypłaty";
	}
 
	public Double execute() throws Exception {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		
		if(amount > 0 && currentBalance+maxdebit>=amount)
			return currentBalance-amount;
	 
		else
			throw new Exception();	//TODO: Zastąpić swoim wyjątkiem
					
	}

}
