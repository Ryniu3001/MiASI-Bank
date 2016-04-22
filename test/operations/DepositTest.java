package operations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import product.Account;
import product.Investment;

public class DepositTest {
	Account account;
	
	
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		account = new Account(500, client);		
	}
	
	@Test(expected=Exception.class)
	public void deposit() throws Exception  {
		Deposit dep = new Deposit(10000, account, 1);
		dep.execute();
	}
	
	@Test
	public void deposit2() throws Exception  {
		Deposit dep = new Deposit(500, account, 1);
		Investment inv = dep.execute();
		assertEquals(0, account.getBalance(), 0);
		assertEquals(500, inv.getBalance(),0);
	}
}
