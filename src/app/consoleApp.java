package app;

import bank.Bank;
import client.Client;
import product.Account;

public class consoleApp {
	
	public static void main(String[] args)
	{
		Bank bank=new Bank();
	 
		bank.addClient(new Client("Zenek","Kowalski","321"));
		
		Account account=new Account(500,1000,"321");
	 
		 
		 
 
		
	 
	}

}
