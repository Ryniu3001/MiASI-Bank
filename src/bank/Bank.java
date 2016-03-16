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
    	products=new ArrayList<Product>();
    }
	public void addClient(Client client)
	{
		clients.add(client);
	}
 
	public void addAccount(Account account)
	{
		 //tutaj powinna byæ walidacja czy istnieje klient o idClient
		//czy debet i balance jest wiêkszy od 0 jeœli nie to zg³oœ wyj¹tek
		products.add(account);
	}
	public Product getProduct(int id)
	{
		return products.get(id);
	}
 
	public List<Operation> getHistory()
	{
		return bankHistoryOperation;
	}
	 
	
	
 
}
