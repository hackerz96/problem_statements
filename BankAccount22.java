public class BankAccount22 {
    String accountNumber;
    double balance;

    // Constructor
    public BankAccount22(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new ArithmeticException("Insufficient funds for withdrawal.");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of amount: " + amount + " successful. New balance: " + balance);
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    // Main method
    public static void main(String[] args) {
        BankAccount22 account = new BankAccount22("99ASCEX", 25000.0);
        account.displayBalance();
        System.out.println();

        // Try withdrawal: Insufficient funds
        try {
            account.withdraw(30000.0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // Try withdrawal: Invalid amount
        try {
            account.withdraw(-5000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // Try withdrawal: Successful
        try {
            account.withdraw(5000.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        // Final balance
        account.displayBalance();
    }
}
