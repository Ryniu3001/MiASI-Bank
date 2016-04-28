package product;
 

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.Operation;
import operations.TakeCredit;

public class Account extends Product {

	private List<Operation> historyOperation;
	
	//lokaty   //TODO: kredyt i lokaty ma konto czy klient?
	private List<Investment> investments;
	private List<Credit> credits;
	
	private Client clientId;
	/**
	 * @param balance saldo poczatkowe
	 * @param debit maksymalna kwota debetu
	*/
	public Account(double balanceStart,Client clientId) {
		super(balanceStart);
		this.clientId=clientId;
		this.investments=new ArrayList<Investment>();
		this.credits=new ArrayList<Credit>();
		this.historyOperation=new ArrayList<Operation>();
		this.interestMechanism = new FirstInterestForAccount(this);
	}
	 
	 

//	
//	
//	/**
//	 * Operacja stworzenia lokaty
//	 * @param bankHistoryOperation
//	 * @param amount
//	 */
//	public void createNewInvestment(List<Operation> bankHistoryOperation,double amount)
//	{
//		if (balance >= amount){
//			CreateInvestment deposit =new CreateInvestment(amount,this, 1);
//			try {
//				investments.add(deposit.execute());
//			} catch (Exception e) {
//				System.out.println("Za malo srodkow na koncie");
//			}
//			addOperationToHistory(deposit);
//		}else{
//			System.out.println("Lokata: Niewystarczająca ilość środków na koncie");
//		}
//		
//	}
//	
//	/**
//	 * Operacja wzięcia kredytu
//	 * @param bankHistoryOperation
//	 * @param amount
//	 */
//	public void createNewCredit(double amount)
//	{
//		//klient bierze kredyt, dodawany jest do listy kredytów i zwiekszane jest saldo
//		TakeCredit takeCredit=new TakeCredit(this, amount);
//		takeCredit.execute();
//		addOperationToHistory(takeCredit);
//	}
	
	
	/////////////////////////////////////////////////////////////////////////
	//operacje do dodawania i odejmowania z salda
	//tutaj mozna zrobic walidacje np. jesli na koncie nie ma wystarczajaco kasy???
	public void addBalance(double amount)
	{
		this.balance+=amount;
	}
	public void substractBalance(double amount)
	{
		this.balance-=amount;
	}
	
	

 
}
