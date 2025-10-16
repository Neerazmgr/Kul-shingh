// BankAccountSimulation.java

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount, String atmName) {
        System.out.println(atmName + " trying to deposit Rs." + amount);
        balance += amount;
        System.out.println(atmName + " successfully deposited Rs." + amount);
        System.out.println("Current Balance: Rs." + balance);
        System.out.println("--------------------------------------");
    }

    // Synchronized withdraw method
    public synchronized void withdraw(double amount, String atmName) {
        System.out.println(atmName + " trying to withdraw Rs." + amount);

        if (balance >= amount) {
            balance -= amount;
            System.out.println(atmName + " successfully withdrew Rs." + amount);
        } else {
            System.out.println(atmName + " - Insufficient balance! Transaction failed.");
        }

        System.out.println("Current Balance: Rs." + balance);
        System.out.println("--------------------------------------");
    }
}

// Thread class representing ATM
class ATMThread extends Thread {
    private BankAccount account;
    private boolean isDeposit; // true = deposit, false = withdraw
    private double amount;
    private String atmName;

    public ATMThread(BankAccount account, boolean isDeposit, double amount, String atmName) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
        this.atmName = atmName;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount, atmName);
        } else {
            account.withdraw(amount, atmName);
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance

        // Creating threads (ATMs)
        Thread atm1 = new ATMThread(account, true, 500, "ATM-1");
        Thread atm2 = new ATMThread(account, false, 700, "ATM-2");
        Thread atm3 = new ATMThread(account, false, 400, "ATM-3");
        Thread atm4 = new ATMThread(account, true, 200, "ATM-4");

        // Starting all ATMs (threads)
        atm1.start();
        atm2.start();
        atm3.start();
        atm4.start();
    }
}
