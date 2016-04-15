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

	protected InterestMechanism interestMechanism;

	// odsetki,saldo
	public Product(double balance) {

		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfProduct = new ArrayList<Operation>();

	}

	// �rodki(saldo) dla konta bankowego, �rodki na lokacie, �rodki(kwota)
	// kredytu
	public double getBalance() {
		return balance;
	}

	// operacja naliczenia odsetek
	public void CalculateInterest() {
		CalculateInterest calculateInterest = new CalculateInterest(this.getInterestMechanism());
		calculateInterest.execute();
		addOperationToHistory(calculateInterest);
	}

	// operacja zmiany mechanizmu odsetek
	public void ChangeMechanismInterest(InterestMechanism newInterestMechanism) {
		ChangeMechanismInterest changeMechanismInterest = new ChangeMechanismInterest(newInterestMechanism);
		changeMechanismInterest.execute();
		addOperationToHistory(changeMechanismInterest);
	}

	protected void addOperationToHistory(Operation operation) {
		Bank.getInstance().getHistory().add(operation);
		this.historyOfProduct.add(operation);
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

}