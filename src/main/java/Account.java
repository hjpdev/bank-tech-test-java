package main.java;

import java.util.ArrayList;

public class Account {

  private double balance;
  private AccountStatement statement;

  public static void main(String[] args) {
    System.out.println("Welcome...");
  }

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
