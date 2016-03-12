package operations;
import java.util.Date;

import product.Account;

public abstract class Operation {

	protected int type;
	protected Date date;
	protected String description;
	protected Account account;
	
	
	public abstract void execute();
	
}
