package operations;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import client.Client;
import product.Account;
import product.AccountDebet;
import product.Investment;

public class CreateInvestementTest {
	Account account1;
	Investment investment;
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		 
		account1 = new Account(1000, client);
		 investment=new Investment(1100,account1,6,client);
	}

	@Test(expected=Exception.class)
	public void createInvestment1() throws Exception{
		
		CreateInvestment operation=new CreateInvestment(investment);
		operation.execute();
		//proba stworzenia lokaty dla sumy wyzszej niz aktualne saldo
	}
	@Test
	public void createInvestment2() throws Exception{
	 
		CreateInvestment operation=new CreateInvestment(investment);
		operation.execute();
		assertEquals(500, account1.getBalance(),0);
		assertEquals(500, investment.getBalance(),0);
		assertEquals(true, investment.getIsActive());
		//stworzenie lokaty dla konta na sume 500 
	}
	
 
}
