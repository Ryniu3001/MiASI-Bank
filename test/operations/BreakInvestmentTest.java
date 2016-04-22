package operations;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import product.Account;
import product.Investment;
import static org.junit.Assert.assertEquals;


public class BreakInvestmentTest {

	Account account;
	Investment investment;
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		account = new Account(500, client);		
		investment = new Investment(20000, account, 1);
	}
	
	@Test
	public void breakInvestment1(){
		BreakInvestment breakInv = new BreakInvestment(account, investment);
		breakInv.execute();
		assertEquals(20500, account.getBalance(), 0);
		assertEquals(0, investment.getBalance(),0);
	}
	
	//TODO: test z naliczaniem odsetek
}
