package product;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import client.InterestMechanism;
import operations.Operation;
import operations.CalculateInterest;
import operations.ChangeMechanismInterest;

public abstract class Product {

	protected double balance;
    protected List<Operation> historyOfProduct;
	private Date startDate;
	
	private InterestMechanism interestMechanism;
	 
	//odsetki,saldo 
	public Product(double balance){
		 
		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfProduct=new ArrayList<Operation>();
		this.interestMechanism=new InterestMechanism(5,30);
		
	}
	//œrodki(saldo) dla konta bankowego, œrodki na lokacie, œrodki(kwota) kredytu
	public double getBalance()
	{
		 return balance;	 
	}
	//operacja naliczenia odsetek
	public void CalculateInterest(List<Operation> bankHistoryOperation)
	{
		CalculateInterest calculateInterest=new CalculateInterest(interestMechanism,balance);
		balance=calculateInterest.execute();
		addOperationToHistory(bankHistoryOperation,calculateInterest);
	}
	//operacja zmiany mechanizmu odsetek
	public void ChangeMechanismInterest(List<Operation> bankHistoryOperation,InterestMechanism newInterestMechanism)
	{
		ChangeMechanismInterest changeMechanismInterest=new ChangeMechanismInterest(newInterestMechanism);
		interestMechanism= changeMechanismInterest.execute();
		addOperationToHistory(bankHistoryOperation,changeMechanismInterest);
	}
	protected void addOperationToHistory(List<Operation> bankHistoryOperation,Operation operation)
	{
		bankHistoryOperation.add(operation);
		this.historyOfProduct.add(operation);
	}
	
	

		
	
}