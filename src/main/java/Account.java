package main.java;

import java.util.Date;

public class Account {

  private double balance;
  private AccountStatement statement = new AccountStatement();

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
    Transaction transInfo = new Transaction(new Date(), amount, balance);
    statement.addTransaction(transInfo.date, transInfo.amount, transInfo.balance);
  }

  public void withdraw(double amount) {
    balance -= amount;
    Transaction transInfo = new Transaction(new Date(), -amount, balance);
    statement.addTransaction(transInfo.date, transInfo.amount, transInfo.balance);
  }
}
