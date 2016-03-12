package product;

import client.Interest;

public class Investment extends Account {

	private Investment(double interests, double balance, Interest interest) {
		super(interests, balance, interest);
	}
}
