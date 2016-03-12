package product;
import java.util.Calendar;
import java.util.Date;

import client.Interest;

public abstract class Account {

	private double balance;
	private Interest interest;
	private Date startDate;
	private double debit;
	//private 
	
	public Account(double interests, double balance, Interest interest){
		this.interest = interest;
		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
	}
		
}