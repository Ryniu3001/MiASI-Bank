package operations;

import java.util.Calendar;

import interests.InterestMechanism;

public class ChangeMechanismInterest extends Operation {

	 
 
	private InterestMechanism mechanismNew;
  	 
	public ChangeMechanismInterest(InterestMechanism mechanismNew) {
	 
		this.type=5;
		this.description="operacja zmiany mechanizmu";

		this.mechanismNew=mechanismNew;
	     
	}
	 
	public Void execute() {
	 
		Calendar cal = Calendar.getInstance();
		this.date = cal.getTime();
		return null;
	}

}
