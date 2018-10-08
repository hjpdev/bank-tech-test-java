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

  public void addTransaction(Date date, double amount, double balance) {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    String strAmount = String.valueOf(amount);
    String strBalance = String.valueOf(balance);
    Hashtable<String, String> transaction = new Hashtable<>();
    transaction.put("date", strDate);
    transaction.put("amount", strAmount);
    transaction.put("balance", strBalance);
    log.add(transaction);
  }

}
