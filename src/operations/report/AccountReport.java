package operations.report;

import java.util.ArrayList;

import product.Product;

public class AccountReport implements Visitor {

	public AccountReport(double minBalance, double maxBalance) {
		this.minBalance = minBalance;
		this.maxBalance = maxBalance;
	}

	private double minBalance = Double.MIN_VALUE;
	private double maxBalance = Double.MAX_VALUE;
	private ArrayList<Product> products = new ArrayList<>();

	@Override
	public void visit(Product product) {
		if (product.getBalance() > minBalance && product.getBalance() < maxBalance) {
			products.add(product);
		}
	}

	public ArrayList<Product> getProducts() {
		return products;
	}
	
}
