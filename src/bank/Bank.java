package bank;

import client.Client;
import interests.InterestMechanism;
import operations.*;
import product.Account;
import product.Credit;
import product.Investment;
import product.Product;
import report.Visitor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bank {

    private List<Client> clients;
    private List<Operation> bankHistoryOperation;
    private List<Product> products;
    

    public Bank() {
        clients = new ArrayList<Client>();
        bankHistoryOperation = new ArrayList<Operation>();
        products = new ArrayList<Product>();
    }

    public int addClient(Client client) {
        clients.add(client);
        return clients.size() - 1;
    }

    public int addAccount(Account account) {
        products.add(account);

        return products.size() - 1;
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public List<Operation> getHistory() {
        return bankHistoryOperation;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Client getClient(int id) {
        return clients.get(id);
    }

    ////////////////////////////////////////////////
    // operacja przelewu
    public void transfer(Account to, Account from, double amount) throws Exception {
    	if(products.contains(to)){
	        Operation operation = new Transfer(to, from, amount);
	        from.executeOperation(operation);
	        bankHistoryOperation.add(operation);
    	}
    	else
    	{
    		BankMediator.getInstance().makePaymentBetweenBanks(this,from,to,amount);
    	}

    }

    // operacja wpłaty
    public void payIn(Account to, double amount) throws Exception {
        Operation operation = new PayIn(to, amount);
        to.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    // operacja wypłaty
    public void payOff(Account from, double amount) throws Exception {
        Operation operation = new PayOff(from, amount);
        from.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    // operacja tworzenia lokaty
    public void createInvestment(Investment investment) throws Exception {

        Operation operation = new CreateInvestment(investment);
        investment.executeOperation(operation);
        products.add(investment);
        bankHistoryOperation.add(operation);

    }

    // operacja zakonczenia lokaty
    public void breakInvestment(Investment investment) throws Exception {

    	//oblicz najpierw odsetki do kredytu
    	Calendar cal = Calendar.getInstance();
		if(investment.getDateEnd().compareTo(cal.getTime())<0){
		    CalculateInterest interest=new CalculateInterest(investment);
		    investment.executeOperation(interest);
		    bankHistoryOperation.add(interest);
		}
        Operation operation = new BreakInvestment(investment);
        investment.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    // operacja naliczania odsetek
    public void calculateInterest(Product product) throws Exception {
        Operation operation = new CalculateInterest(product);
        product.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    // zmiana mechanizmu odsetkowego
    public void changeInterestMechanism(Product product, InterestMechanism newInterestMechanism) throws Exception {
        Operation operation = new ChangeMechanismInterest(product, newInterestMechanism);
        product.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    // wziecie kredytu
    public void takeCredit(Credit credit) throws Exception {
        Operation operation = new TakeCredit(credit);
        credit.executeOperation(operation);
        //dolicz do kredytu odsetek
		CalculateInterest interest=new CalculateInterest(credit);
		credit.executeOperation(interest);
        products.add(credit);
        bankHistoryOperation.add(operation);
        bankHistoryOperation.add(interest);
    }

    // splata kredytu
    public void refundCredit(Credit credit) throws Exception {
        Operation operation = new RefundCredit(credit);
        credit.executeOperation(operation);
        bankHistoryOperation.add(operation);
    }

    public void accountReport(Visitor report) {
        for (Product product : products) {
            product.accept(report);
        }
    }
    public boolean ifBankContainsAccount(Account account)
    {
    	return products.contains(account);
    }
}
