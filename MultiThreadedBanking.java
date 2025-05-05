// Problem: Multi-threaded Banking System
// Design and implement a multi-threaded banking system in Java that simulates 
// multiple users performing concurrent transactions on shared bank accounts. 
// Each transaction can be a deposit, withdrawal, or transfer between accounts.

public class MultiThreadedBanking {

    static class BankAccount {
        private int accountId;
        private double balance;

        public BankAccount(int id, double initialBalance) {
            this.accountId = id;
            this.balance = initialBalance;
        }

        public int getAccountId() {
            return accountId;
        }

        public synchronized void deposit(double amount) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() +
                " deposited $" + amount + " into Account " + accountId +
                " | New Balance: $" + balance);
        }

        public synchronized boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                    " withdrew $" + amount + " from Account " + accountId +
                    " | New Balance: $" + balance);
                return true;
            } else {
                System.out.println(Thread.currentThread().getName() +
                    " failed to withdraw $" + amount + " from Account " + accountId +
                    " | Insufficient funds");
                return false;
            }
        }

        public synchronized double getBalance() {
            return balance;
        }

        public static void transfer(BankAccount from, BankAccount to, double amount) {
            BankAccount firstLock = from.accountId < to.accountId ? from : to;
            BankAccount secondLock = from.accountId < to.accountId ? to : from;

            synchronized (firstLock) {
                synchronized (secondLock) {
                    if (from.withdraw(amount)) {
                        to.deposit(amount);
                        System.out.println(Thread.currentThread().getName() +
                            " transferred $" + amount +
                            " from Account " + from.accountId +
                            " to Account " + to.accountId);
                    } else {
                        System.out.println(Thread.currentThread().getName() +
                            " failed to transfer $" + amount + 
                            " from Account " + from.accountId +
                            " to Account " + to.accountId +
                            " due to insufficient funds.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, 1000);
        BankAccount acc2 = new BankAccount(102, 1500);

        Runnable user1 = () -> {
            acc1.deposit(300);
            acc1.withdraw(200);
            BankAccount.transfer(acc1, acc2, 400);
        };

        Runnable user2 = () -> {
            acc2.withdraw(500);
            acc2.deposit(700);
            BankAccount.transfer(acc2, acc1, 250);
        };

        Runnable user3 = () -> {
            BankAccount.transfer(acc1, acc2, 150);
            acc1.withdraw(100);
            acc2.deposit(100);
        };

        Thread t1 = new Thread(user1, "User-1");
        Thread t2 = new Thread(user2, "User-2");
        Thread t3 = new Thread(user3, "User-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance of Account " + acc1.getAccountId() + ": $" + acc1.getBalance());
        System.out.println("Final Balance of Account " + acc2.getAccountId() + ": $" + acc2.getBalance());
    }
}
