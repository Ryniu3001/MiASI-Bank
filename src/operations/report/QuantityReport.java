package operations.report;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bank.Bank;
import product.Product;

/**
 * @author marcin
 * Raport ilości założonych produktów
 */
public class QuantityReport implements Report {

	//TODO: Umozliwić ustawienie zakresu dat
	
	private Date date;
	private Bank bank;
	private List<Product> list;
	
	public QuantityReport() {
		Calendar cal = Calendar.getInstance();
		date = cal.getTime();
		bank = Bank.getInstance();
		generate();
	}
	
	private void generate(){
		this.list = bank.getProducts();
	}

	@Override
	public String printOutResult() {
		return new StringBuilder().append("Ilość wszystkich produktów: ").append(list.size()).append("\n").toString();
	}

}
