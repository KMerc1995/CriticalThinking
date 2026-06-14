package Week1;

public class BankAccount {

    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    // Constructor
    public BankAccount() {
        balance = 0.0;
    }

    // Deposit Method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdrawal Method
    public void withdrawal(double amount) {
        balance -= amount;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Account Summary
    public void accountSummary() {
        System.out.println("Account Summary");
        System.out.println("----------------------");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
