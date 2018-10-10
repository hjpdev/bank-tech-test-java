package main.java;

import java.util.ArrayList;

public class AccountStatement {

  private ArrayList log = new ArrayList<>();

  public AccountStatement() {
    ArrayList log[];
  }

  public ArrayList returnLog() {
    return log;
  }

  public void addTransaction(String date, double amount, String balance) {
    if (amount >= 0) {
      log.add(date + " || " + String.valueOf(amount) + " || || " + balance + "\n");
    } else {
      log.add(date + " || || " + String.valueOf(amount).substring(1) + " || " + balance + "\n");
    }
  }

  public String printStatement() {
    String result = "date || credit || debit || balance\n";
    for (int i = log.size() - 1; i >= 0; i--) {
      result += log.get(i);
    }
    return result;
  }
}
