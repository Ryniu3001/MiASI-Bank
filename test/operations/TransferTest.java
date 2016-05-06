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
		//test przelewu z konta 2 do konta 1

	}
	
	
	@Test(expected=Exception.class)
	public void transfer2() throws Exception{
		Transfer transfer = new Transfer(account1,account2,1100);
		transfer.execute();
		//test przelewu za dużej kwoty
	}
	@Test(expected=Exception.class)
	public void transfer3ClosedAccount() throws Exception{
		account1.closeAccount();
		Transfer transfer = new Transfer(account1,account2,1100);
		transfer.execute();
		//test przeelewu z zamkniętego konta
	}
	@Test
	public void transfer4AccountWithDebet() throws Exception{
	
		Transfer transfer = new Transfer(account1,accountDebet,1100);
		transfer.execute();
		assertEquals(1200, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(100, accountDebet.getCurrentDebet(),0);
		//test przelewu z konta debetowego sumy równej maxdebet i stanu konta
	}
	
	@Test(expected=Exception.class)
	public void transfer5AccountWithDebet() throws Exception{
	
		Transfer transfer = new Transfer(account1,accountDebet,1200);
		transfer.execute();
		//test przelewu z konta debetowego kwoty wiekszej od sumy stanu konta i maxdebetu
	}
	@Test
	public void transfer6AccountWithDebet() throws Exception{
		transfer4AccountWithDebet();
		Transfer transfer2 = new Transfer(accountDebet,account1,1100);
		transfer2.execute();
		assertEquals(100, account1.getBalance(),0);
		assertEquals(1000, accountDebet.getBalance(),0);
		assertEquals(0, accountDebet.getCurrentDebet(),0);
		//test przelewu na konto debetowe 
	}
	@Test
	public void transfer7AccountWithDebet() throws Exception{
		transfer4AccountWithDebet();
		Transfer transfer2 = new Transfer(accountDebet,account1,50);
		transfer2.execute();
		assertEquals(1150, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(50, accountDebet.getCurrentDebet(),0);
		//test przelewu na konto debetowe kwoty mniejszej od aktualnego debetu
	}
	@Test
	public void transfer8AccountWithDebet() throws Exception{
		transfer7AccountWithDebet();
		Transfer transfer2 = new Transfer(accountDebet,account1,50);
		transfer2.execute();
		assertEquals(1100, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(0, accountDebet.getCurrentDebet(),0);
		//test przelewu na konto debetowe kwoty równej wysokości debetu
	}
	
	@Test(expected=Exception.class)
	public void transfer9() throws Exception{
		Transfer transfer = new Transfer(account1,account2,-1000);
		transfer.execute();

		//test przelewu z konta 2 do konta 1 nieprawidłowej sumy

	}
	@Test(expected=Exception.class)
	public void transfer10() throws Exception{
		transfer4AccountWithDebet();
		Transfer transfer = new Transfer(accountDebet,account2,-1000);		 
		transfer.execute();
		 
		//test przelewu z konta 2 na konto debetowe nieprawidłowej sumy
	}
	@Test
	public void transfer1AccountWithDebet() throws Exception{
	
		Transfer transfer = new Transfer(account1,accountDebet,1050);
		transfer.execute();
		assertEquals(1150, account1.getBalance(),0);
		assertEquals(0, accountDebet.getBalance(),0);
		assertEquals(50, accountDebet.getCurrentDebet(),0);
		//test przelewu z konta debetowego kwoty większej od stanu konta, ale nierównej maxdebet
	}
}
