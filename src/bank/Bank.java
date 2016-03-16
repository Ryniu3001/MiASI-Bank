package bank;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.Transfer;
import operations.Deposit;
import product.Account;
import product.Investment;
import product.Product;

public class Bank {

	private List<Client> clients;
    private List<Operation> bankHistoryOperation;
    private List<Product> products;
    
    public Bank()
    {
    	clients=new ArrayList<Client>();
    	bankHistoryOperation=new ArrayList<Operation>();
    }
	public void addClient(Client client)
	{
		clients.add(client);
	}
	/*
	 * @param amount kwota wp�aty
	 * @param currentBalance aktualne saldo konta
	 */
	public void addAccount(Account account)
	{
		 //tutaj powinna by� walidacja czy istnieje klient o idClient
		//czy debet i balance jest wi�kszy od 0 je�li nie to zg�o� wyj�tek
		products.add(account);
	}
	
	 
	
	
	
	


	/**
	 * operacja utworzenia lokaty
	 * @param amount 
	 * @param account konto z kt�rego b�d� pobrane pieni�dze na lokate
	 */
	public void CreateInvestment(double amount,Account account)
	{
		
		Deposit deposit=new Deposit(amount,account);
	    deposit.execute();
	    bankHistoryOperation.add(deposit);
	}
}
