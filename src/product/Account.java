package product;
 

import java.util.ArrayList;
import java.util.List;

import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.Transfer;

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
	 
	 
	/**
	 * operacja wp³aty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void PayIn(double amount,List<Operation> bankHistoryOperation)
	{
		PayIn payIn=new PayIn(amount,balance);
		balance=payIn.execute();
		this.historyOfProduct.add(payIn);
		bankHistoryOperation.add(payIn);		
	}
	/**
	 * operacja wyp³aty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void PayOff(double amount,List<Operation> bankHistoryOperation)
	{
		PayOff payOff=new PayOff(amount,balance,debit);
		balance=payOff.execute();
		this.historyOfProduct.add(payOff);
		bankHistoryOperation.add(payOff);	
	}
	/**
	 * operacja przelewu
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void Transfer(double amount,String numberAccount,List<Operation> bankHistoryOperation)
	{
		Transfer transfer=new Transfer(amount,numberAccount,debit,balance);
		balance=transfer.execute();
		this.historyOfProduct.add(transfer);
		bankHistoryOperation.add(transfer);	
	}
	/**
	 * operacja naliczanie odsetek do konta bankowego
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void CalculateInterest(List<Operation> bankHistoryOperation)
	{
		 //doliczenie odsetek na podstawie mechanizmu
		//this.historyOfProduct.add(transfer);
		//bankHistoryOperation.add(transfer);	
	}
	/**
	 * operacja zmiany mechanizmu odsetek
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void ChangeMechanismInterest(List<Operation> bankHistoryOperation)
	{
		 //operacja zmiany mechanizmu odsetek
		//this.historyOfProduct.add(transfer);
		//bankHistoryOperation.add(transfer);	
	}
	
	/**
	 * operacja stworzenia lokaty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void createInvestment(List<Operation> bankHistoryOperation,double amount)
	{
		 //operacja dodania nowej lokaty
		//sprawdzic czy user ma wystarczaj¹co kasy na za³o¿enie lokaty
		//rekaukulacja salda
		Investment investment=new Investment(amount);
		investments.add(investment);
		//this.historyOfProduct.add(transfer);
		//bankHistoryOperation.add(transfer);	
	}
	/**
	 * operacja zerwania lokaty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void createInvestment(List<Operation> bankHistoryOperation,Investment investment)
	{
		 //zerwij lokate zmien saldo
		//this.historyOfProduct.add(transfer);
		//bankHistoryOperation.add(transfer);	
	}
	//----------------------------------------------------------------
	//operacja wziêcia kredytu
	public void createNewCredit(double amount,List<Operation> bankHistoryOperation)
	{
		//klient bierze kredyt, dodawany jest do listy kredytów i zwiekszane jest saldo
		Credit credit=new Credit(amount,this);
		credits.add(credit);
		//this.PayIn(amount, bankHistoryOperation);
	}
 
}
