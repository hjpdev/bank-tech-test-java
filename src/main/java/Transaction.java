package main.java;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.Hashtable;

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
    if (inputAmount >= 0) {
      addInfoCredit();
    } else {
      addInfoDebit();
    }
  }

  private void addInfoCredit() {
    info = date + " || " + amount + " || || " + balance + "\n";
  }

  private void addInfoDebit() {
    info = date + " || || " + amount.substring(1) + " || " + balance + "\n";
  }
}
