package operations;


import product.Account;
import product.IAccount;

 

public class Transfer extends Operation {

	private IAccount from;
	private IAccount to;
    private double amount;

    /**
	 * @param toAccount
	 * konto docelowe
	 * @param fromAccount
	 * konto źródłowe
	 * @param amount
	 * konto kwota przelewu
	 */
	public Transfer(IAccount toAccount,IAccount fromAccount,double amount) {
	 
		this.to=toAccount;
		this.from=fromAccount;
		 this.amount=amount;
	}
	 
	public void execute() throws Exception{
	 
		to.addBalance(amount);
		from.substractBalance(amount);
		
	}

}
