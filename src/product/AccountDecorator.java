package product;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.Operation;
import productsState.AccountClosed;
import productsState.AccountOpen;
import report.Visitor;

public abstract class AccountDecorator extends Product implements IAccount{
 
	protected Account account;
	public AccountDecorator(Account account) {
		super(account.getBalance());
		this.account=account;
		
	}

	@Override
	public void accept(Visitor visitor) {
		this.account.accept(visitor);
		
	}
}
