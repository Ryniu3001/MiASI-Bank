package report;

import product.Product;

import java.util.ArrayList;

public class AccountBalanceReport implements Visitor {

    private double minBalance = Double.MIN_VALUE;
    private double maxBalance = Double.MAX_VALUE;
    private ArrayList<Product> products = new ArrayList<Product>();

    public AccountBalanceReport(double minBalance, double maxBalance) {
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
    }

    @Override
    public void visit(Product product) {
        if (product.getBalance() > minBalance && product.getBalance() < maxBalance) {
            products.add(product);
        }
    }

    @Override
    public void showReport() {
        System.out.println("### REPORT ###");

        for (Product product : getProducts()) {
            System.out.println("balance = " + product.getBalance());
        }

        System.out.println("### END ###");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
