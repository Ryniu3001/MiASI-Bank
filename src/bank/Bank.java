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

public class Bank {

	private List<Client> clients;
    private List<Operation> bankHistoryOperation;
    
    public Bank()
    {
    	clients=new ArrayList<Client>();
    	bankHistoryOperation=new ArrayList<Operation>();
    }
	public void addClient(Client client)
	{
		clients.add(client);
	}
	
	public Client getClient(int id)
	{
	    return clients.get(id);
	    
	}
	
	/**
	 * operacja wp³aty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void PayIn(double amount,String numberAccount,Account account)
	{
		PayIn payIn=new PayIn(amount,account.getBalance());
		account.setBalance(payIn.execute());
		bankHistoryOperation.add(payIn);		
	}
	
	/**
	 * operacja wyp³aty
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void PayOff(double amount,Account account)
	{
		PayOff payOff=new PayOff(amount,account.getBalance());
		account.setBalance(payOff.execute());
		bankHistoryOperation.add(payOff);	
	}
	
	/**
	 * operacja przelewu
	 * @param amount kwota przelewu
	 * @param numberAccount numerkonta
	 * @param account konto z którego zostanie wykonany przelew
	 */
	public void Transfer(double amount,String numberAccount,Account account)
	{
		Transfer transfer=new Transfer(amount,numberAccount,account.getDebit(),account.getBalance());
		account.setBalance(transfer.execute());
		bankHistoryOperation.add(transfer);
		
	}

	/**
	 * operacja utworzenia lokaty
	 * @param amount 
	 * @param account konto z którego bêd¹ pobrane pieni¹dze na lokate
	 */
	public void CreateInvestment(double amount,Account account)
	{
		Deposit deposit=new Deposit(amount,account);
		account
	}
}
