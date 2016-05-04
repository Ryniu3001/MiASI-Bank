package bank;

import product.Account;

class BankMediator {
    private Bank fromBank;
    private Bank toBank;


    public BankMediator(final Bank fromBank, final Bank toBank) {
        this.fromBank = fromBank;
        this.toBank = toBank;
    }

    void makePaymentBetweenBanks(final Account fromAccount, final double amount, final Account toAccount) throws Exception {
        fromBank.payOff(fromAccount, amount);
        fromBank.payIn(toAccount, amount);
    }
}
