package app;

import bank.Bank;
import client.Client;
import product.Account;

public class consoleApp {
	
	public static void main(String[] args)
	{
		Bank bank=new Bank();
	 
		bank.addClient(new Client("Zenek","Kowalski","321"));
		bank.addAccount(new Account(500,1000,"321"));
		
	 
		Account account=(Account)bank.getProduct(0);
		account.PayIn(500, bank.getHistory());
		System.out.println("test");
		 
	 
		 
		 
 
		
	 
	}

}
