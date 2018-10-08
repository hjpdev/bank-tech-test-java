
import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

class Transaction {
  public String date;
  public String amount;
  public String balance;
  public Hashtable<String, String> info = new Hashtable<>();

  Transaction(Date inputDate, double inputAmount, double inputBalance) {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    date = dateFormatter.format(inputDate);
    amount = String.valueOf(inputAmount);
    balance = String.valueOf(inputBalance);
    addInfo();
  }

  private void addInfo() {
    info.put("date", date);
    info.put("amount", amount);
    info.put("balance", balance);
  }
}
