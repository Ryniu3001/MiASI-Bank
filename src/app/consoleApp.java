package app;

import bank.Bank;
import client.Client;
import product.Account;
import report.AccountsSumBalanceReport;

public class consoleApp {
    public static void main(String[] args) {

		/*
         * Wydaje mi się że dodawanie do historii banku powinno być realizowane w klasie Operacji.
		 * Informacje np. o kredycie aktualnie mamy w kalsie konta, a czy nie powinno to być w klasie Klienta? 
		 * Klient moze miec kilka kont i moze chciec z innegoi splacic kredyt - to samo z lokatą
		 * 
		 * 
		 * Referencja do kredytu powinna byc w kliencie
		 * 
		 * 
		 * W klasie abstrakcyjnej Operation dodać pole Product i zmienić jej podklasy tak aby to pole uzupełniały, aby w historii banku było można wyświetlić jakiego 
		 * konta/produktu dotyczy operacja.
		 * Opcjonalnie: flaga zabezpieczająca przed ponownym wykonaniem instancji operacji
		 * 
		 * Obliczenie odsetek ma nie powodowac zmiany stanu (InterestMechanizm) tylko zwracac wartosc, a dopiero operacja CalculateInterest ma dodawac do stnau konta
		 * 
		 * Wozrzec dekorator ma umożliwiać tworzenie debetu na koncie. Sama klasa Account nie wie nic o debecie.
		 * 
		 * Mediator - przelewy do innych bankow. Np jakas klasa KRS - jako mediator.
		 */

        Bank bank = Bank.getInstance();

        int id = bank.addClient(new Client("93101012345", "Zenek", "Kowalski"));
        Client client = Bank.getInstance().getClient(id);
        int accountIndex = bank.addAccount(new Account(0, client));
        int accountIndex2 = bank.addAccount(new Account(5000, client));

        Account account = (Account) bank.getProduct(accountIndex);
        Account account2 = (Account) bank.getProduct(accountIndex2);

        final AccountsSumBalanceReport report = new AccountsSumBalanceReport();
        bank.accountReport(report);
        report.showReport();

        System.out.println(Bank.getInstance().getHistory());
    }
}
