package product;

import client.Interest;

public class BankAccount extends Account {

	private BankAccount(double interests, double balance, Interest interest) {
		super(interests, balance, interest);
	}

}
