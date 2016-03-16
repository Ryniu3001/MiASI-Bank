package operations;

import java.util.Calendar;

import client.InterestMechanism;

 

public class CalculateInterest extends Operation {

	
	 
	private double currentBalance;//balance before operation
	private InterestMechanism mechanism;
   
	//naliczanie odsetek type=4
     
	public CalculateInterest(InterestMechanism mechanism,double currentbalance) {
	 
		this.type=4;
		this.description="operacja naliczania odsetek";
		this.currentBalance=currentBalance; 
		this.mechanism=mechanism;
	     
	}
	 
	public double execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return currentBalance*mechanism.getPercentage();//coœ lepszego trzeba wymyœleæ
	}

}