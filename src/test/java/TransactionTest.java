import main.java.Transaction;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    assertEquals("10.95", transaction.amount);
  }

  @Test
  public void hasTheRightBalanceAndFormat() {
    assertEquals("10.95", transaction.balance);
  }

  @Test
  public void addInfoCredit() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();

    assertEquals(("11/02/2018 || 10.95 || || 10.95\n"), transaction.info);
  }

  @Test
  public void addInfoDebit() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
    Transaction mockTrans = new Transaction(date, -230.24, 500.45);

    assertEquals(("11/02/2018 || || 230.24 || 500.45\n"), mockTrans.info);
  }
}
