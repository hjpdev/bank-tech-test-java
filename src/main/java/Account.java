package main.java;

import java.util.Date;

public class Account {

  private double balance;
  private double overdraft;
  private AccountStatement statement = new AccountStatement();

  public Account() {
    double balance = 0.00;
    double overdraft = 0.00;
    AccountStatement statement = new AccountStatement();
  }

  public Account(double balance, double overdraft, AccountStatement statement) {
    this.balance = balance;
    this.overdraft = overdraft;
    this.statement = statement;
  }

  public double currentBalance() {
    return balance;
  }

  public double overdraftLimit() {
    return overdraft;
  }

  public AccountStatement returnStatement() {
    return statement;
  }

  public void deposit(double amount) {
    balance += amount;
    statement.addTransaction(new Date(), amount, balance);
  }

  public void withdraw(double amount) {
    balance -= amount;
    statement.addTransaction(new Date(), -amount, balance);
  }
}
