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
		this.description="operacja wp�aty";
	     
	}
	 
	public double execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return currentBalance+amount;
	}

}
