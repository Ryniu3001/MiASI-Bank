package app;

import bank.Bank;
import client.Client;
import product.Account;

public class consoleApp {
	
	public static void main(String[] args)
	{
		Bank bank=new Bank();
		Client client=new Client("Zenek","Kowalski","5252");
		bank.addClient(client);
		
		bank.getClient(0).addProduct(new Account(500,1000));
		
		bank.Transfer(500, "124424224244242", (Account)bank.getClient(0).GetProduct(0));
		
		System.out.println("s");
	}

}
