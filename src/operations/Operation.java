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
		return "Typ operacji: " + type + "\n" +
				"Czas: " + date.toString() + "\n" 
				+ "Opis: " + description + "\n";
	}
}
