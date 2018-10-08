import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.Hashtable;

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
  public void addsAllInfoToAnInfoVariable() {
    Hashtable mockInfo = new Hashtable();
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    mockInfo.put("date", strDate);
    mockInfo.put("amount", "10.95");
    mockInfo.put("balance", "10.95");
    assertEquals(mockInfo, transaction.info);
  }
}
