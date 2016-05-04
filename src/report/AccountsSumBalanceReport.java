package report;

import product.Product;

/**
 * Created by maciej on 04.05.16.
 */
public class AccountsSumBalanceReport implements Visitor {

    private long accountsSumBalance;

    @Override
    public void visit(Product product) {
        accountsSumBalance += product.getBalance();
    }

    public long getSum() {
        return accountsSumBalance;
    }
}
