package bank;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import operations.Operation;
import product.Account;
import product.Product;

public class Bank {

	private static List<Client> clients;
    private static List<Operation> bankHistoryOperation;
    private static List<Product> products;
    private static Bank instance = null;
    
    private Bank()
    {
    	clients=new ArrayList<Client>();
    	bankHistoryOperation=new ArrayList<Operation>();
    	products=new ArrayList<Product>();
    }
    
    public static Bank getInstance(){
    	if (instance == null){
    		instance = new Bank();
    	}
    	return instance;
    }
    
	public int addClient(Client client)
	{
		clients.add(client);
		return clients.size()-1;
	}
 
	public int addAccount(Account account)
	{
		 //tutaj powinna by� walidacja czy istnieje klient o idClient
		//czy debet i balance jest wi�kszy od 0 je�li nie to zg�o� wyj�tek
		products.add(account);
		
		return products.size()-1;
	}
	public Product getProduct(int id)
	{
		return products.get(id);
	}
 
	public List<Operation> getHistory()
	{
		return bankHistoryOperation;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public Client getClient(int id){
		return clients.get(id);
	}
 
}
