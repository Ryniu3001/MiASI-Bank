package product;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.Deposit;
import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.TakeCredit;
import operations.Transfer;

public abstract class AbstractAccount extends Product {
	
	public AbstractAccount(double balance) {
		super(balance);
	}

	/**
	 * Operacja wpłaty
	 * @param amount
	 */
	public abstract void payIn(double amount);
	
	/**
	 * Operacja wypłaty
	 * @param amount
	 */
	public abstract void PayOff(double amount);
	/**
	 * Operacja przelewu
	 * @param amount
	 * @param destination
	 * @throws Exception 
	 */
	public abstract void Transfer(double amount,Account destination) throws Exception;
	
	
	/**
	 * Operacja stworzenia lokaty
	 * @param bankHistoryOperation
	 * @param amount
	 */
	public abstract void createNewInvestment(List<Operation> bankHistoryOperation,double amount);
	
	/**
	 * Operacja wzięcia kredytu
	 * @param bankHistoryOperation
	 * @param amount
	 */
	public abstract void createNewCredit(double amount);
	
	
}
