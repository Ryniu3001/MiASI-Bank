package client;
import java.util.ArrayList;
import java.util.List;

import product.Account;

public class Client {

	private String name;
	private String surname;
	private List<Account> accountList = new ArrayList<Account>();
	private String id; // pesel
	
	
	public void addNewBankAccount(Account account){
		accountList.add(account);
	}
}
