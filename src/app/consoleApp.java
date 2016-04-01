package app;

import bank.Bank;
import client.Client;
import operations.report.Report;
import operations.report.ReportFactory;
import product.Account;

public class consoleApp {
	
	public static void main(String[] args)
	{
		
		/*
		 * Wydaje mi się że dodawanie do historii banku powinno być realizowane w klasie Operacji.
		 * Informacje np. o kredycie aktualnie mamy w kalsie konta, a czy nie powinno to być w klasie Klienta? 
		 * Klient moze miec kilka kont i moze chciec z innegoi splacic kredyt - to samo z lokatą
		 * 
		 * 
		 * Referencja do kredytu powinna byc w kliencie
		 */
		
		Bank bank= Bank.getInstance();
	 
		int id = bank.addClient(new Client("Zenek","Kowalski"));
		Client client = Bank.getInstance().getClient(id);
		int accountIndex = bank.addAccount(new Account(0,1000, client));
		int accountIndex2 = bank.addAccount(new Account(5000,1000, client));
		
	 
		Account account=(Account)bank.getProduct(accountIndex);
		Account account2=(Account)bank.getProduct(accountIndex2);
		
		account.payIn(10000);		
		System.out.println("Bilans1: " + account.getBalance());
		
		account.PayOff(5000);		
		System.out.println("Bilans1: " + account.getBalance());
		
		try {
			account2.Transfer(5000, account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		account.createNewCredit(50000);
		System.out.println("Bilans1: " + account.getBalance());
		
		Report r = ReportFactory.generateReport(ReportFactory.QUANTITY_REPORT);
		System.out.println(r.printOutResult());
		System.out.println(Bank.getInstance().getHistory());
		
	 
		 
		 
 
		
	 
	}

}
