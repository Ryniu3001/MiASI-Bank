package product;

import operations.Operation;
import report.Visitor;

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

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
