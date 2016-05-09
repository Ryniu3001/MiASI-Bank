package operations;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import client.Client;
import product.Account;
import product.Investment;

@RunWith(EasyMockRunner.class)
public class BreakInvestmentTest {
	@Mock
	Account account1;
	@Mock
	Client client;
	@TestSubject
	Investment investment = new Investment(500,account1,6,client);
	
/*	
	@Before
	public void setUp() throws Exception{
		investment=new Investment(500,account1,6,client);
 
	}*/

	@Test 
	public void breakInvestment1() throws Exception{

		BreakInvestment operation=new BreakInvestment(investment);
		operation.execute();
		//assertEquals(1500, account1.getBalance(),0); //testujemy lokate a nie konto
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
