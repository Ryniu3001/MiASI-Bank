package product;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

 
import operations.Operation;

public abstract class Product {

	protected double balance;
    protected List<Operation> historyOfProduct;
	private Date startDate;
	
	
	 
	//odsetki,saldo 
	public Product(double balance){
		 
		this.balance = balance;
		Calendar cal = Calendar.getInstance();
		this.startDate = cal.getTime();
		this.historyOfProduct=new ArrayList<Operation>();
		
	}
	//�rodki(saldo) dla konta bankowego, �rodki na lokacie, �rodki(kwota) kredytu
	public double getBalance()
	{
		 return balance;	 
	}
	
	

		
	
}