package product;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.Operation;
import productsState.AccountClosed;
import productsState.AccountOpen;
import productsState.IAccountState;
import report.Visitor;

public class Account extends Product implements IAccount{

	private List<Operation> historyOperation;
	private List<Investment> investments;
	private List<Credit> credits;
	private Client clientId;
	private IAccountState state;

	/**
	 * @param balance
	 * saldo poczatkowe
	 * @param debit
	 * maksymalna kwota debetu
	 */
	public Account(double balanceStart, Client clientId) {
		super(balanceStart);
		this.clientId = clientId;
		this.investments = new ArrayList<Investment>();
		this.credits = new ArrayList<Credit>();
		this.historyOperation = new ArrayList<Operation>();
		this.interestMechanism = new FirstInterestForAccount(this);
		this.state=new AccountOpen();
	}
	 
	public void addBalance(double amount) {
		state.addBalance(this, amount);
	}

	public void substractBalance(double amount) {
		state.substractBalance(this, amount);
	}
	public void closeAccount() {
		this.state= new AccountClosed();
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void setState(IAccountState state)
	{
		this.state=state;
	}
	public IAccountState getState()
	{
		return state;
	}
	
	

}
