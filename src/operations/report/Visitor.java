package operations.report;

import product.Account;
import product.Credit;
import product.Investment;
import product.Product;

public interface Visitor {
	
	public void visit(Product product);

}
