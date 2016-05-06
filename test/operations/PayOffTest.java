package operations;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import client.Client;
import product.Account;
import product.AccountDebet;

public class PayOffTest{

	Account account1;
	AccountDebet accountDebet;
	@Before
	public void setUp(){
		Client client = new Client("Asd", "qwe");
		account1 = new Account(1000, client);
		accountDebet=new AccountDebet(account1,500);
	}
 
 
	
    @Test
    public void payOff1() throws Exception {
    	PayOff operation=new PayOff(account1, 1000);
    	operation.execute();
		assertEquals(0,account1.getBalance(), 0);
		//wypłata z konta sumy równej wysokości salda
    }

    @Test(expected=Exception.class)
	public void payOff2() throws Exception {
	    	PayOff operation=new PayOff(account1, 1100);
	    	operation.execute();
			assertEquals(0,account1.getBalance(), 0);
			//wypłata z konta sumy wyższej wysokości salda
    }   
    @Test(expected=Exception.class)
	public void payOff3() throws Exception {
	    	PayOff operation=new PayOff(account1, 0);
	    	operation.execute();
			assertEquals(0,account1.getBalance(), 0);
			//wypłata z konta nieprawidłowej sumy
    }   
    
    @Test
    public void payOff4() throws Exception {
    	PayOff operation=new PayOff(accountDebet, 1500);
    	operation.execute();
		assertEquals(0,accountDebet.getBalance(), 0);
		assertEquals(500,accountDebet.getCurrentDebet(), 0);
		//wypłata z konta debetowego kwoty równej sumie maxdebet i currentbalance 
    }
    @Test
    public void payOff5() throws Exception {
    	PayOff operation=new PayOff(accountDebet, 900);
    	operation.execute();
		assertEquals(100,accountDebet.getBalance(), 0);
		assertEquals(0,accountDebet.getCurrentDebet(), 0);
		//wypłata z konta debetowego kwoty mniejszej od currentbalance
    }
    @Test
    public void payOff6() throws Exception {
    	PayOff operation=new PayOff(accountDebet, 1000);
    	operation.execute();
		assertEquals(0,accountDebet.getBalance(), 0);
		assertEquals(0,accountDebet.getCurrentDebet(), 0);
		//wypłata z konta debetowego kwoty równej   currentbalance
    }
}
