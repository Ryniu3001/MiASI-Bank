package operations;

import java.util.Calendar;

 

public class PayIn extends Operation {

	
	private double amount;
	private double currentBalance;//balance before operation
   
	//wp�ata type=1
    
	public PayIn(double amount,double currentBalance) {
	 
		this.type=1;
		this.amount=amount;
		this.currentBalance=currentBalance;
		this.description="operacja wpłaty";
	     
	}
	 
	public Double execute() throws Exception {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();	
		if (amount <= 0)
			throw new Exception();
		else
			return currentBalance+amount;
	}

}
