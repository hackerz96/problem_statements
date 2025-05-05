// Custom exception class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount class
class BankAccount {
    double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdrawal(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("InsufficientFundsException.");
        } 
        else {
            balance -= amount;
            System.out.println("Withdrawal of amount " + amount + " successful. New balance: " + balance);
        }
    }
}

// Main class
public class SimpleBankingSystem {
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount(959999);
        System.out.println("Initial balance: " + newAccount.balance);

        try {
            newAccount.withdrawal(1000000); // Should throw exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            newAccount.withdrawal(50000); // Should succeed
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
