package main.java;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

public class Transaction {
  public String date;
  public double amount;
  public String balance;

  public Transaction(Date inputDate, double inputAmount, double inputBalance) {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    date = dateFormatter.format(inputDate);
    amount = inputAmount;
    balance = String.valueOf(inputBalance);
  }
}
