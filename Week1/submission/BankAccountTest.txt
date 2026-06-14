package Week1;

public class BankAccountTest {

    public static void main(String[] args) {

        // Test BankAccount
        BankAccount account = new BankAccount();

        account.setFirstName("Kory");
        account.setLastName("Melillo");
        account.setAccountID(1001);

        account.deposit(500.00);
        account.withdrawal(100.00);

        System.out.println("BANK ACCOUNT TEST");
        account.accountSummary();

        System.out.println();

        // Test CheckingAccount
        CheckingAccount checking = new CheckingAccount(2.5);

        checking.setFirstName("Kory");
        checking.setLastName("Melillo");
        checking.setAccountID(2001);

        checking.deposit(200.00);

        System.out.println("CHECKING ACCOUNT TEST");
        checking.displayAccount();

        System.out.println("\nProcessing withdrawal of $250...");
        checking.processWithdrawal(250.00);

        System.out.println("\nFinal Account Information");
        checking.displayAccount();
    }
}
