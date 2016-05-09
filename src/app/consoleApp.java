package app;

import bank.Bank;
import client.Client;
import product.Account;
import report.AccountBalanceReport;

public class consoleApp {
    public static void main(String[] args) throws Exception {

		/*
          do zrobienia
          1. dokoĹ„czenie testĂłw
          2. sprawdzenie czy mechanizmy odsetkowe dziaĹ‚ajÄ… prawidĹ‚owo
          3. nie mamy ĹĽadnych testĂłw na mockach
		 
		  */

        Bank bank=new Bank();

        int id = bank.addClient(new Client("Zenek", "Kowalski"));
        Client client = bank.getClient(id);
        int accountIndex = bank.addAccount(new Account(0, client));
        int accountIndex2 = bank.addAccount(new Account(5000, client));

        Account account = (Account) bank.getProduct(accountIndex);
        Account account2 = (Account) bank.getProduct(accountIndex2);
        
        bank.transfer(account, account2, 2000);

       
        final AccountBalanceReport report = new AccountBalanceReport(0,50000);
        bank.accountReport(report);
        report.showReport();

        System.out.println(bank.getHistory());
    }
}
