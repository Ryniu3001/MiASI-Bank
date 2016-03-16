package product;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

 
import operations.Operation;

public abstract class Product {

	protected double balance;
    protected List<Operation> historyOfOperation;
	private Date startDate;
	
	//private 
	//odsetki,saldo 
	public Product(double balance){
		 
		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfOperation=new ArrayList<Operation>();
		
	}
	//œrodki(saldo) dla konta bankowego, œrodki na lokacie, œrodki(kwota) kredytu
	public double getBalance()
	{
		 return balance;	 
	}
	

		
	
}