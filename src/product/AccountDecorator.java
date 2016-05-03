package product;

import client.Client;

public class AccountDecorator extends Account {
    public AccountDecorator(double balanceStart, Client clientId) {
        super(balanceStart, clientId);
    }

    @Override
    public void substractBalance(double amount) {
        balance -= amount;
    }
}
