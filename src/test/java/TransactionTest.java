import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.Hashtable;

import main.java.Transaction;

public class TransactionTest {
  private Transaction transaction;

  @Before
  public void setup() {
    Date date = new Date();
    transaction = new Transaction(date, 10.95, 10.95);
  }

  @Test
  public void hasTheRightDateAndFormat() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    assertEquals(strDate, transaction.date);
  }

  @Test
  public void hasTheRightAmountAndFormat() {
    assertEquals("10.95", transaction.amount);
  }

  @Test
  public void hasTheRightBalanceAndFormat() {
    assertEquals("10.95", transaction.balance);
  }

  @Test
  public void addInfoCredit() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    Transaction mockTrans = new Transaction(date, 100.23, 100.23);
    assertEquals((strDate + " || 100.23 || || 100.23\n"), mockTrans.info);
  }

  @Test
  public void addInfoDebit() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    Transaction mockTrans = new Transaction(date, -230.24, 500.45);
    assertEquals((strDate + " || || 230.24 || 500.45\n"), mockTrans.info);
  }
}
