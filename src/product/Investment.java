package product;

 
import product.Account;

public class Investment extends Product {

	private Account account;
	public Investment(double balance,Account account) {
		super(balance);
		this.account=account;
	}
}
