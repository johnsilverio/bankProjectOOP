package bank.test;

import bank.domain.BankAccount;

public class BankAccountTest {
    public static void main(String[] args) {
        // Fictional accounts
        BankAccount account1 = new BankAccount(12345678, "CC", "Alice");
        BankAccount account2 = new BankAccount(87654321, "CP", "Bob");
        BankAccount account3 = new BankAccount(11223344, "CC", "Charlie");
        BankAccount account4 = new BankAccount(44332211, "CP", "Diana");

        // Account opening tests
        System.out.println("Account Opening Test:");
        boolean test1 = account1.openAccount();
        boolean test2 = account2.openAccount();
        boolean test3 = account3.openAccount();
        boolean test4 = account4.openAccount();
        printResult(test1, "Account 1 (Alice) opened: ");
        printResult(test2, "Account 2 (Bob) opened: ");
        printResult(test3, "Account 3 (Charlie) opened: ");
        printResult(test4, "Account 4 (Diana) opened: ");

        // Deposit tests
        System.out.println("\nDeposit Test:");
        account1.deposit(1000.0);
        account2.deposit(500.0);
        account3.deposit(1200.0);
        account4.deposit(700.0);
        printBalance(account1, "Account 1 (Alice)");
        printBalance(account2, "Account 2 (Bob)");
        printBalance(account3, "Account 3 (Charlie)");
        printBalance(account4, "Account 4 (Diana)");

        // Monthly fee payment tests
        System.out.println("\nMonthly Fee Payment Test:");
        account1.payMonthlyFee();
        account2.payMonthlyFee();
        account3.payMonthlyFee();
        account4.payMonthlyFee();
        printBalance(account1, "Account 1 (Alice) after fee payment");
        printBalance(account2, "Account 2 (Bob) after fee payment");
        printBalance(account3, "Account 3 (Charlie) after fee payment");
        printBalance(account4, "Account 4 (Diana) after fee payment");

        // Withdrawal tests
        System.out.println("\nWithdrawal Test:");
        account1.withdraw(200.0);
        account2.withdraw(100.0);
        account3.withdraw(500.0);
        account4.withdraw(100.0);
        printBalance(account1, "Account 1 (Alice) after withdrawal");
        printBalance(account2, "Account 2 (Bob) after withdrawal");
        printBalance(account3, "Account 3 (Charlie) after withdrawal");
        printBalance(account4, "Account 4 (Diana) after withdrawal");

        // Account closure tests
        System.out.println("\nAccount Closure Test:");
        account1.closeAccount();
        account2.closeAccount();
        account3.closeAccount();
        account4.closeAccount();
        printResult(!account1.getStatus(), "Account 1 (Alice) closed: ");
        printResult(!account2.getStatus(), "Account 2 (Bob) closed: ");
        printResult(!account3.getStatus(), "Account 3 (Charlie) closed: ");
        printResult(!account4.getStatus(), "Account 4 (Diana) closed: ");
    }

    private static void printResult(boolean result, String message) {
        if (result) {
            System.out.println("✅ " + message + "TRUE");
        } else {
            System.out.println("❌ " + message + "FALSE");
        }
    }

    private static void printBalance(BankAccount account, String accountName) {
        System.out.println(accountName + " - Current balance: " + account.getBalance());
    }
}