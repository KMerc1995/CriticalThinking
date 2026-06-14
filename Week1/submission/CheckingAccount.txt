package Week1;

public class CheckingAccount extends BankAccount {

    private double interestRate;

    // Constructor
    public CheckingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    // Overdraft Withdrawal Method
    public void processWithdrawal(double amount) {
        balance -= amount;

        if (balance < 0) {
            balance -= 30;
            System.out.println("Overdraft fee assessed: $30");
        }

        System.out.println("Current Balance: $" + balance);
    }

    // Display Account Information
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
