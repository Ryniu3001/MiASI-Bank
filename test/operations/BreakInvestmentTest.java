package operations;

import org.junit.Before;
import org.junit.Test;

import client.Client;
import interests.FirstInterestForInvestment;
import product.Account;
import product.Investment;
import static org.junit.Assert.assertEquals;


public class BreakInvestmentTest {
	Account account1;
	Investment investment;
	@Before
	public void setUp() throws Exception{
		Client client = new Client("Asd", "qwe");
	 
		account1 = new Account(1000, client);
		investment=new Investment(500,account1,6,client);
 
	}

	@Test 
	public void breakInvestment1() throws Exception{
		
		
		
		BreakInvestment operation=new BreakInvestment(investment);
		operation.execute();
		assertEquals(1500, account1.getBalance(),0);
		assertEquals(false, investment.getIsActive());
		//zakonczenie lokaty  
	}
	@Test(expected=Exception.class)
	public void breakInvestment2() throws Exception{
		
		
		investment.setIsActive(false);
		BreakInvestment operation=new BreakInvestment(investment);
		operation.execute();
	 
		//proba zakonczenia lokaty nieaktywnej
	}
 
}
