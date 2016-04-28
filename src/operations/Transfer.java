package operations;


import product.Account;

 

public class Transfer extends Operation {

	private Account from;
	private Account to;
    private double amount;

 
	public Transfer(Account toAccount,Account fromAccount,double amount) {
	 
		this.to=toAccount;
		this.from=toAccount;
		 this.amount=amount;
	}
	 
	public void execute() throws Exception{
	 
		to.addBalance(amount);
		from.substractBalance(amount);
		
	}

}
