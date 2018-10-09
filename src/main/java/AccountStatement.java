package main.java;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

class AccountStatement {

  private ArrayList<Hashtable<String, String>> log = new ArrayList<Hashtable<String, String>>();

  AccountStatement() {
    ArrayList log[];
  }

  public ArrayList returnLog() {
    return log;
  }

  public void addTransaction(Transaction transaction) {
    log.add(transaction.info);
  }

}
