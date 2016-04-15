package operations;

import java.util.Calendar;

import interests.InterestMechanism;
import product.Product;

 

public class CalculateInterest extends Operation {  
	//naliczanie odsetek type=4
     
	private InterestMechanism mechanisms;
	public CalculateInterest(InterestMechanism mechanism) {
	 
		this.type=4;
		this.description="operacja naliczania odsetek";    
		this.mechanisms = mechanism;
	}
	 
	public Void execute() {
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		mechanisms.calculate();
		return null;
		
	}

}