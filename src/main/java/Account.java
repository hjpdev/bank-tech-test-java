import java.util.ArrayList;

class Account {

  private double balance;
  private AccountStatement statement;

  public Account() {
    double balance = 0.00;
    AccountStatement statement = new AccountStatement();
  }

  public double currentBalance() {
    return balance;
  }

  public AccountStatement returnStatement() {
    return statement;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }
}
