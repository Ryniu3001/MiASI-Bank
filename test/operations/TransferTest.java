package operations;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import client.Client;
import product.Account;
import product.AccountDebet;

public class TransferTest {
	Account account1;
	Account account2;
	AccountDebet accountDebet;
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		Client client2 = new Client("qwe", "sdf");
		account1 = new Account(100, client);
		account2 = new Account(1000, client2);
		accountDebet=new AccountDebet(account2,100);
	}

	@Test
	public void transfer1() throws Exception{
		Transfer transfer = new Transfer(account1,account2,1000);
		transfer.execute();
		assertEquals(1100, account1.getBalance(),0);
		assertEquals(0, account2.getBalance(),0);
	}
	
	
	@Test(expected=Exception.class)
	public void transfer2() throws Exception{
		Transfer transfer = new Transfer(account1,account2,1100);
		transfer.execute();
	}
	@Test(expected=Exception.class)
	public void transfer3ClosedAccount() throws Exception{
		account1.closeAccount();
		Transfer transfer = new Transfer(account1,account2,1100);
		transfer.execute();
	}
	@Test
	public void transfer4AccountWithDebet() throws Exception{
	
		Transfer transfer = new Transfer(account1,accountDebet,1100);
		transfer.execute();
		assertEquals(1200, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(100, accountDebet.getCurrentDebet(),0);
	}
	@Test(expected=Exception.class)
	public void transfer5AccountWithDebet() throws Exception{
	
		Transfer transfer = new Transfer(account1,accountDebet,1200);
		transfer.execute();
	}
	@Test
	public void transfer6AccountWithDebet() throws Exception{
		transfer4AccountWithDebet();
		Transfer transfer2 = new Transfer(accountDebet,account1,1100);
		transfer2.execute();
		assertEquals(100, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(0, accountDebet.getCurrentDebet(),0);
	}
}
