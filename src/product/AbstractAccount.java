package product;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import interests.FirstInterestForAccount;
import operations.CreateInvestment;
import operations.Operation;
import operations.PayIn;
import operations.PayOff;
import operations.TakeCredit;
import operations.Transfer;

public abstract class AbstractAccount extends Product {
	
	public AbstractAccount(double balance) {
		super(balance);
	}

	public void execute(Operation operation) throws Exception {
		// TODO Auto-generated method stub
		
	}

	 
	
	
}
