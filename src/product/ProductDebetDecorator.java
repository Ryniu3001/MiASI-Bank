package product;

import java.util.List;

import operations.Operation;

public class ProductDebetDecorator extends AbstractAccount {
	private Account account;
	
	public ProductDebetDecorator(Account account) {
		super(account.getBalance());
		this.account = account;
	}

	@Override
	public void execute(Operation operation) throws Exception {
		this.account.executeOperation(operation);
	}

}
