package interests;

import product.Account;
import product.Product;

public abstract class InterestMechanism {

	protected Product product;
		
	public abstract void calculate();
}
