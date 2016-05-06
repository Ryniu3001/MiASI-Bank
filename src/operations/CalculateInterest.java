package operations;

import java.util.Calendar;

import interests.InterestMechanism;
import product.Product;

 

public class CalculateInterest extends Operation {  
	private Product product;
     

	public CalculateInterest(Product product) {
	 this.product=product;
	 
	}
	 
	public void execute() {
 
		product.getInterestMechanism().calculate();
	}

}