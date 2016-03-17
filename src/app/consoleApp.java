package app;

import bank.Bank;
import client.Client;
import product.Account;

public class consoleApp {
	
	public static void main(String[] args)
	{
		Bank bank= Bank.getInstance();
	 
		bank.addClient(new Client("Zenek","Kowalski","321"));
		int accountIndex = bank.addAccount(new Account(0,1000,"321"));
		int accountIndex2 = bank.addAccount(new Account(5000,1000,"321"));
		
	 
		Account account=(Account)bank.getProduct(accountIndex);
		Account account2=(Account)bank.getProduct(accountIndex2);
		
		account.PayIn(10000);		
		System.out.println("Bilans1: " + account.getBalance());
		
		account.PayOff(5000);		
		System.out.println("Bilans1: " + account.getBalance());
		
		account2.Transfer(5000, account);
		
		account.createNewCredit(50000);
		System.out.println("Bilans1: " + account.getBalance());
		
		//System.out.println(Bank.getInstance().getHistory());
		
	 
		 
		 
 
		
	 
	}

}
