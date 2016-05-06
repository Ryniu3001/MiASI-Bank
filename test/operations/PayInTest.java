package operations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import product.Account;
import product.AccountDebet;
public class PayInTest {


	Account account1;
	AccountDebet accountDebet;
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		account1 = new Account(1000, client);
		accountDebet=new AccountDebet(account1,500);
	}
	
	@Test(expected=Exception.class)
	public void payIn1() throws Exception{
		PayIn payin = new PayIn(account1, -100);
		payin.execute();
		//wpłata nieprawidłowej kwoty
	}
	
	@Test
	public void payIn2() throws Exception{
		PayIn payin = new PayIn(account1, 100);
		payin.execute();
		assertEquals(1100,account1.getBalance(), 0);
		//wpłata kwoty na konto
	}
	@Test
	public void payIn3() throws Exception{
		PayIn payin = new PayIn(accountDebet, 100);
		payin.execute();
		assertEquals(1100,accountDebet.getBalance(), 0);
		assertEquals(0,accountDebet.getCurrentDebet(), 0);
		//wpłata kwoty na konto debetowe
	}
}
