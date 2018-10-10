package main.java;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

public class Transaction {
  public String date;
  public String amount;
  public String balance;
  public String info;

  public Transaction(Date inputDate, double inputAmount, double inputBalance) {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    date = dateFormatter.format(inputDate);
    amount = String.valueOf(inputAmount);
    balance = String.valueOf(inputBalance);
    addInfo(inputAmount);
  }

  private void addInfo(double amount) {
    if (amount >= 0) {
      info = date + " || " + String.valueOf(amount) + " || || " + balance + "\n";
    } else {
      info = date + " || || " + String.valueOf(amount).substring(1) + " || " + balance + "\n";
    }
  }
}
