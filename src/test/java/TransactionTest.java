import main.java.Transaction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class TransactionTest {
  private Transaction transaction;

  @Before
  public void setup() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
    transaction = new Transaction(date, 10.95, 10.95);
  }

  @Test
  public void formatsDateCorrectly() {
    assertEquals("11/02/2018", transaction.date);
  }

  @Test
  public void hasTheRightAmountAndFormat() {
    assertTrue(transaction.amount == 10.95);
  }

  @Test
  public void hasTheRightBalanceAndFormat() {
    assertEquals("10.95", transaction.balance);
  }
}
