package main.java;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

public class AccountStatement {

  private ArrayList log = new ArrayList<>();

  public AccountStatement() {
    ArrayList log[];
  }

  public ArrayList returnLog() {
    return log;
  }

  public void addTransaction(Transaction transaction) {
    log.add(transaction.info);
  }

  public String printStatement() {
    String result = "date || credit || debit || balance\n";
    for (int i = log.size() - 1; i >= 0 ; i--) {
      result += log.get(i);
    }
    return result;
  }
}
