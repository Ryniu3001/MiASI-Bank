package operations;

import java.util.Calendar;

import interests.InterestMechanism;
import product.Product;

public class ChangeMechanismInterest extends Operation {

	 
    private Product product;
	private InterestMechanism interestMechanismNew;
  	 
	public ChangeMechanismInterest(Product product,InterestMechanism mechanismNew) {
	 
		this.product=product;
		this.interestMechanismNew=mechanismNew;
	     
	}
	 
	public void execute() {
	  product.setInterestMechanism(interestMechanismNew);
	}

}
