package operations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import product.Account;
import product.Credit;

public class RefundCreditTest {
	Account account;
	Credit credit;
	
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		account = new Account(1000, client);
		credit = new Credit(50000, account);		
	}
	
	@Test
	public void refund1() throws Exception{
		RefundCredit refund = new RefundCredit(account, credit, 50000);
		assertTrue(refund.execute());
	}
	
	
	@Test(expected=Exception.class)
	public void refund2() throws Exception{
		RefundCredit refund = new RefundCredit(account, credit, 1000);
		refund.execute();
	}
	
	//TODO: dodac przypadek w ktorym klient splaca wiecej niz wzial kredytu
}
