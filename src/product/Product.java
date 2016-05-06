package product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import client.Client;
import interests.InterestMechanism;
import operations.Operation;
import report.Visitable;

public abstract class Product implements Visitable {

	protected double balance;
	protected List<Operation> historyOfProduct;
	protected InterestMechanism interestMechanism;
	protected Client clientId;
	// odsetki,saldo
	public Product(double balance,Client client) {

		this.balance = balance;
		 this.clientId=client;
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