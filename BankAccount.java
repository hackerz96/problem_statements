import java.util.Scanner;

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class BankAccount {

    // fields
    private String accountNumber;
    private String name;
    private double balance;

    // constructor
    public BankAccount(String accountNumber, String name, double balance){
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // deposit method
    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit Amount!");
        }
    }

    // withdraw method with exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Amount Debited: " + amount);
            System.out.println("Updated Balance: " + balance);
        } else {
            throw new InsufficientBalanceException("Insufficient Balance or Invalid Amount!");
        }
    }

    // display account details
    public void display(){
        System.out.println("========================== Account Details ==========================");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + name);
        System.out.println("Current Balance: " + balance);
        System.out.println("=====================================================================");
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    // main method
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BankAccount[] Accounts = new BankAccount[10];
        int i = 0;

        while (true) {
            System.out.println("\nEnter Your Choice:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");

            int choice = scn.nextInt();
            scn.nextLine(); // consume leftover newline

            switch(choice){
                case 1:
                    System.out.println("Enter Account Number: ");
                    String accountNumber = scn.nextLine();
                    System.out.println("Enter Account Holder Name: ");
                    String name = scn.nextLine();
                    System.out.println("Enter Initial Account Balance: ");
                    double balance = scn.nextDouble();
                    scn.nextLine(); // consume newline
                    Accounts[i++] = new BankAccount(accountNumber, name, balance);
                    System.out.println("Account Created Successfully!");
                    break;

                case 2:
                    System.out.println("Enter Account Number: ");
                    String accNum = scn.nextLine();
                    System.out.println("Enter Amount to Deposit: ");
                    double amount = scn.nextDouble();
                    scn.nextLine(); // consume newline
                    boolean found = false;
                    for(int j = 0; j < i; j++){
                        if(Accounts[j].getAccountNumber().equals(accNum)){
                            Accounts[j].deposit(amount);
                            found = true;
                            break;
                        }
                    }
                    if(!found) System.out.println("Account Not Found!");
                    break;

                case 3:
                    System.out.println("Enter Account Number: ");
                    String accNum1 = scn.nextLine();
                    System.out.println("Enter Amount to Withdraw: ");
                    double amount1 = scn.nextDouble();
                    scn.nextLine(); // consume newline
                    boolean found1 = false;
                    for(int j = 0; j < i; j++){
                        if(Accounts[j].getAccountNumber().equals(accNum1)){
                            try {
                                Accounts[j].withdraw(amount1);
                            } catch (InsufficientBalanceException e) {
                                System.out.println("Withdrawal Failed: " + e.getMessage());
                            }
                            found1 = true;
                            break;
                        }
                    }
                    if(!found1) System.out.println("Account Not Found!");
                    break;

                case 4:
                    System.out.println("Enter Account Number: ");
                    String accNum2 = scn.nextLine();
                    boolean found2 = false;
                    for(int j = 0; j < i; j++){
                        if(Accounts[j].getAccountNumber().equals(accNum2)){
                            Accounts[j].display();
                            found2 = true;
                            break;
                        }
                    }
                    if(!found2) System.out.println("Account Not Found!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scn.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Please try again.");
                    break;
            }
        }
    }
}
