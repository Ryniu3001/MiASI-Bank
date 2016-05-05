package product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import interests.InterestMechanism;
import operations.Operation;
import report.Visitable;

public abstract class Product implements Visitable {

	protected double balance;
	protected List<Operation> historyOfProduct;
	protected Date startDate;
	protected InterestMechanism interestMechanism;

	// odsetki,saldo
	public Product(double balance) {

		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfProduct = new ArrayList<Operation>();
	 

	}

	public double getBalance() {
		return balance;
	}

	

	 

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public InterestMechanism getInterestMechanism() {
		return interestMechanism;
	}

	public void setInterestMechanism(InterestMechanism interestMechanism) {
		this.interestMechanism = interestMechanism;
	}

	//////////////////

	public void executeOperation(Operation operation) throws Exception {
		operation.execute();
		historyOfProduct.add(operation);
	}

}