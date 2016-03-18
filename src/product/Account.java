package product;
 

import java.util.ArrayList;
import java.util.List;

import client.Client;
import operations.Deposit;
import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.TakeCredit;
import operations.Transfer;

public class Account extends Product {

	private List<Operation> historyOperation;
	
	//lokaty   //TODO: kredyt i lokaty ma konto czy klient?
	private List<Investment> investments;
	private List<Credit> credits;
	
	//mechanizm debetowy
	private double debit;
	private Client clientId;
	/**
	 * @param balance saldo poczatkowe
	 * @param debit maksymalna kwota debetu
	*/
	public Account(double balanceStart,double debit,Client clientId) {
		super(balanceStart);
		this.debit=debit;
		this.clientId=clientId;
		this.investments=new ArrayList<Investment>();
		this.credits=new ArrayList<Credit>();
		this.historyOperation=new ArrayList<Operation>();
	}
	 
	 
	
	/**
	 * Operacja wpłaty
	 * @param amount
	 */
	public void PayIn(double amount)
	{
		PayIn payIn=new PayIn(amount,balance);
		try {
			balance=payIn.execute();
		} catch (Exception e) {
			System.out.println("Wyjatek");
		}
		addOperationToHistory(payIn);
	}
	
	
	/**
	 * Operacja wypłaty
	 * @param amount
	 */
	public void PayOff(double amount)
	{
		PayOff payOff=new PayOff(amount,balance,debit);
		
		try {
			balance=payOff.execute();
		} catch (Exception e) {
			System.out.println("Wypłata: Za mało środków na koncie!");
		}
		addOperationToHistory(payOff);
	}
	
	/**
	 * Operacja przelewu
	 * @param amount
	 * @param destination
	 */
	public void Transfer(double amount,Account destination)
	{
		Transfer transfer=new Transfer(amount,destination,debit,balance);
		try {
			balance=transfer.execute();
		} catch (Exception e) {
			System.out.println("Przelew: Za mało środków na koncie!");
		}
		addOperationToHistory(transfer);
	}
	
	
	/**
	 * Operacja stworzenia lokaty
	 * @param bankHistoryOperation
	 * @param amount
	 */
	public void createNewInvestment(List<Operation> bankHistoryOperation,double amount)
	{
		if (balance+debit >= amount){
			Deposit deposit =new Deposit(amount,this, 1);
			investments.add(deposit.execute());
			addOperationToHistory(deposit);
		}else{
			System.out.println("Lokata: Niewystarczająca ilość środków na koncie");
		}
		
	}
	
	/**
	 * Operacja wzięcia kredytu
	 * @param bankHistoryOperation
	 * @param amount
	 */
	public void createNewCredit(double amount)
	{
		//klient bierze kredyt, dodawany jest do listy kredytów i zwiekszane jest saldo
		TakeCredit takeCredit=new TakeCredit(this, amount);
		takeCredit.execute();
		this.PayIn(amount);
		addOperationToHistory(takeCredit);
	}



	public double getDebit() {
		return debit;
	}
	
	
 
}
