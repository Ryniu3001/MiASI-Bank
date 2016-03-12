package product;

import client.Interest;

public class Credit extends Account {

	private Credit(double interests, double balance, Interest interest) {
		super(interests, balance, interest);
	}
}
