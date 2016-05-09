package operations;

import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import client.Client;
import product.Account;
import product.Credit;

@RunWith(EasyMockRunner.class)
public class RefundCreditTest {
	@Mock
	Client client;
	@Mock
	Account account = new Account(60000, client);
	@TestSubject
	Credit credit = new Credit(50000, account, client);

	/**
	 * Spłata kredytu
	 * @throws Exception
	 */
	@Test
	public void refund1() throws Exception{
		RefundCredit refund = new RefundCredit(credit);
		refund.execute();
		assertFalse(credit.getIsActive());
	}
	
	
	/**
	 * Spłata nieaktywnego kredytu
	 * @throws Exception
	 */
	@Test(expected=Exception.class)
	public void refund2() throws Exception{
		credit.setIsActive(false);
		RefundCredit refund = new RefundCredit(credit);
		refund.execute();
	}
}
