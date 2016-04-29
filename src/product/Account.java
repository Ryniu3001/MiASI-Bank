package product;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.Operation;
import operations.report.Visitor;

public class Account extends Product {

	private List<Operation> historyOperation;

	// lokaty //TODO: kredyt i lokaty ma konto czy klient?
	private List<Investment> investments;
	private List<Credit> credits;

	private Client clientId;

	/**
	 * @param balance
	 *            saldo poczatkowe
	 * @param debit
	 *            maksymalna kwota debetu
	 */
	public Account(double balanceStart, Client clientId) {
		super(balanceStart);
		this.clientId = clientId;
		this.investments = new ArrayList<Investment>();
		this.credits = new ArrayList<Credit>();
		this.historyOperation = new ArrayList<Operation>();
		this.interestMechanism = new FirstInterestForAccount(this);
	}


	/////////////////////////////////////////////////////////////////////////
	// operacje do dodawania i odejmowania z salda
	// tutaj mozna zrobic walidacje np. jesli na koncie nie ma wystarczajaco
	///////////////////////////////////////////////////////////////////////// kasy???
	public void addBalance(double amount) {
		this.balance += amount;
	}

	public void substractBalance(double amount) {
		this.balance -= amount;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
