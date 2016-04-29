package operations;

import java.util.Calendar;

import interests.InterestMechanism;
import product.Product;

 

public class CalculateInterest extends Operation {  
	private Product product;
     
	private InterestMechanism mechanism;
	public CalculateInterest(Product product) {
	 product=product;
	 
	}
	 
	public void execute() {
 
		product.getInterestMechanism().calculate();
	}

}