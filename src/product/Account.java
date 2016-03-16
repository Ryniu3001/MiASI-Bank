package product;
 

import java.util.ArrayList;
import java.util.List;

import operations.Deposit;
import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.Transfer;
import operations.TakeCredit;

public class Account extends Product {

	private List<Operation> historyOperation;
	
	//lokaty
	private List<Investment> investments;
	private List<Credit> credits;
	
	//mechanizm debetowy
	private double debit;
	private String clientId;
	/**
	 * @param balance saldo poczatkowe
	 * @param debit maksymalna kwota debetu
	*/
	public Account(double balanceStart,double debit,String clientId) {
		super(balanceStart);
		this.debit=debit;
		this.clientId=clientId;
		this.investments=new ArrayList<Investment>();
		this.credits=new ArrayList<Credit>();
		this.historyOperation=new ArrayList<Operation>();
	}
	 
	 
	//operacja wp³aty
	public void PayIn(double amount,List<Operation> bankHistoryOperation)
	{
		PayIn payIn=new PayIn(amount,balance);
		balance=payIn.execute();
		addOperationToHistory(bankHistoryOperation,payIn);	
	}
	//operacja wyp³aty
	public void PayOff(double amount,List<Operation> bankHistoryOperation)
	{
		PayOff payOff=new PayOff(amount,balance,debit);
		balance=payOff.execute();
		addOperationToHistory(bankHistoryOperation,payOff);
	}
	//operacja przelewu
	public void Transfer(double amount,String numberAccount,List<Operation> bankHistoryOperation)
	{
		Transfer transfer=new Transfer(amount,numberAccount,debit,balance);
		balance=transfer.execute();
		addOperationToHistory(bankHistoryOperation,transfer);
	}
	//operacja stworzenia lokaty
	public void createNewInvestment(List<Operation> bankHistoryOperation,double amount)
	{
		 //operacja dodania nowej lokaty
		//sprawdzic czy user ma wystarczaj¹co kasy na za³o¿enie lokaty
		//rekalkulacja salda
		Deposit deposit =new Deposit(amount,this);
	    
		investments.add(deposit.execute());
		addOperationToHistory(bankHistoryOperation,deposit);
	}
	//operacja wziêcia kredytu
	public void createNewCredit(List<Operation> bankHistoryOperation,double amount)
	{
		//klient bierze kredyt, dodawany jest do listy kredytów i zwiekszane jest saldo
		TakeCredit takeCredit=new TakeCredit(this, amount);
		takeCredit.execute();
		this.PayIn(amount, bankHistoryOperation);
		addOperationToHistory(bankHistoryOperation,takeCredit);
	}
 
}
