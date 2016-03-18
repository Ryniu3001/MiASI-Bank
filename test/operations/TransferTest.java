package operations;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import client.Client;
import product.Account;

public class TransferTest {
	Account account;
	
	@Before
	public void setUp(){
		Client clinet = new Client("Asd", "qwe");
		account = new Account(1000, 100, clinet);
	}

	@Test
	public void transfer1(){
		Transfer transfer = new Transfer(500, account, 10, 1000);
	}
}
