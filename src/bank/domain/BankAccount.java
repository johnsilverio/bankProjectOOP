package bank.domain;

public class BankAccount {
    public int accountNumber;
    protected String accountType;
    private String user;
    private double balance;
    private boolean status;

    public BankAccount(int accountNum, String accountType, String user) {
        this.setAccountNumber(accountNum);
        this.setUser(user);
        this.setAccountType(accountType);
        this.setBalance(0.0);
        this.setStatus(false);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean openAccount() {
        double initialBalanceCC = 50.0;
        double initialBalanceCP = 150.0;
        if (this.accountType.equals("CC")) {
            this.balance += initialBalanceCC;
        }
        if (this.accountType.equals("CP")) {
            this.balance += initialBalanceCP;
        }
        if (!this.status) {
            this.status = true;
        }
        return getStatus();
    }

    public void closeAccount() {
        if (this.status) {
            this.status = false;
        }
    }

    public void deposit(double addBalance) {
        if (this.status) {
            this.balance += addBalance;
        }
    }

    public void withdraw(double removeBalance) {
        if (this.status) {
            this.balance -= removeBalance;
        }
        if (this.balance == 0.0) {
            System.out.println("Insufficient balance.🙁");
        }
    }

    public void payMonthlyFee() {
        if (this.accountType.equals("CC")) {
            this.balance -= 12.0;
        }
        if (this.accountType.equals("CP")) {
            this.balance -= 20.0;
        }
    }
}