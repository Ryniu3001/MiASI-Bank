package operations.report;

import product.Product;

public interface Visitable {

	public void accept(Visitor visitor);
}
