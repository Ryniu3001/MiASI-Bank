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
	public void payIn(double amount) {
		this.account.payIn(amount);
	}

	@Override
	public void PayOff(double amount) {
		this.account.PayOff(amount);
	}

	@Override
	public void Transfer(double amount, Account destination) throws Exception {
		this.account.Transfer(amount, destination);
		
	}

	@Override
	public void createNewInvestment(List<Operation> bankHistoryOperation, double amount) {
		this.account.createNewInvestment(bankHistoryOperation, amount);
		
	}

	@Override
	public void createNewCredit(double amount) {
		this.account.createNewCredit(amount);
		
	}

}
