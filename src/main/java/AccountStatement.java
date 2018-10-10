package main.java;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

public class AccountStatement {

  private ArrayList log = new ArrayList<>();

  public AccountStatement() {
    ArrayList log[];
  }

  public ArrayList returnLog() {
    return log;
  }

  public void addTransaction(Date date, double amount, double balance) {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    String strBalance = String.valueOf(balance);
    if (amount >= 0) {
      log.add(strDate + " || " + String.valueOf(amount) + " || || " + strBalance + "\n");
    } else {
      log.add(strDate + " || || " + String.valueOf(amount).substring(1) + " || " + strBalance + "\n");
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
