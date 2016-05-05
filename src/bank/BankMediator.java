package bank;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import product.Account;

class BankMediator {
    private List<Bank> banks;
  
    private static BankMediator instance = null;
    
    public static BankMediator getInstance() {
        if (instance == null) {
            instance = new BankMediator();
        }
        return instance;
    }
    public BankMediator() {
    	banks=new ArrayList<Bank>();
    }
    public void addBank(Bank bank)
    {
    	banks.add(bank);
    }
    public void removeBank(Bank bank)
    {
    	banks.remove(bank);
    }

    void makePaymentBetweenBanks(Bank from,Account fromAccount,Account toAccount,double amount) throws Exception {
       
        Bank to=whichBankHasAccount(toAccount);
        if(to!=null)
        {
        	 from.payOff(fromAccount, amount);
        	 to.payIn(toAccount, amount);
        }
        else
        {
        	throw new RuntimeException("Mediator hasn't Bank with toAccount");
        }
        
    }
    private Bank whichBankHasAccount(Account toAccount)
    {
    	for(int i=0;i<banks.size();i++)
    	{
    		if(banks.get(i).ifBankContainsAccount(toAccount))
    			return banks.get(i);
    	}
    	return null;
    }
}
