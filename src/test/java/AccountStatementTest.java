import main.java.AccountStatement;

import org.junit.Before;
import org.junit.Test;
import com.sun.source.tree.AssertTree;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class AccountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
  }

  @Test
  public void addTransactionAddsDetailsCredit() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();

    accountStatement.addTransaction(date, 10.23, 10.23);

    assertEquals("11/02/2018 || 10.23 || || 10.23\n", accountStatement.returnLog().get(0));
  }

  @Test
  public void addTransactionAddsDetailsDebit() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();

    accountStatement.addTransaction(date, -10.23, 10.23);

    assertEquals("11/02/2018 || || 10.23 || 10.23\n", accountStatement.returnLog().get(0));
  }

  @Test
  public void printStatementFormatsInfoCorrectly() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();

    accountStatement.addTransaction(date, 1000.11, 1000.11);
    accountStatement.addTransaction(date, 2000.11, 3000.22);
    accountStatement.addTransaction(date, -500.11, 2500.11);

    assertEquals(accountStatement.printStatement(),
        "date || credit || debit || balance\n11/02/2018 || || 500.11 || 2500.11\n"
            + "11/02/2018 || 2000.11 || || 3000.22\n11/02/2018 || 1000.11 || || 1000.11\n");
  }
}
