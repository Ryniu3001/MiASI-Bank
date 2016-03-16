package operations;
import java.util.Date;

import product.Product;

public abstract class Operation {

	protected int type;
	protected Date date;
	protected String description;
	
	@Override
	public String toString()
	{
		return "O godz:"+date.toString() + "wykonano "+description;
	}
}
