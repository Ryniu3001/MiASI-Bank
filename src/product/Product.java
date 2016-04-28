package product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bank.Bank;
import interests.InterestMechanism;
import operations.CalculateInterest;
import operations.ChangeMechanismInterest;
import operations.Operation;

public abstract class Product {

	protected double balance;
	protected List<Operation> historyOfProduct;
	protected Date startDate;
    protected Boolean isOpen;
	protected InterestMechanism interestMechanism;

	// odsetki,saldo
	public Product(double balance) {

		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfProduct = new ArrayList<Operation>();
		this.isOpen=true;

	}

	 
	public double getBalance() {
		return balance;
	}
	public void closeProduct()
	{
		isOpen=false;
	}
	public Boolean getIsOpen() {
		return isOpen;
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
	
	public void executeOperation(Operation operation) throws Exception
	{
		operation.execute();
		historyOfProduct.add(operation);
	}

}