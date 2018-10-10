import main.java.AccountStatement;
import main.java.Transaction;

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
  public void addTransactionAddsDetails() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
    Transaction transaction = new Transaction(date, 10.23, 10.23);

    accountStatement.addTransaction(transaction.date, transaction.amount, transaction.balance);

    assertEquals("11/02/2018 || 10.23 || || 10.23", accountStatement.returnLog().get(0));
  }

  @Test
  public void printStatementFormatsInfoCorrectly() {
    Date date = new GregorianCalendar(2018, Calendar.FEBRUARY, 11).getTime();
    Transaction transaction1 = new Transaction(date, 1000.11, 1000.11);
    Transaction transaction2 = new Transaction(date, 2000.11, 3000.22);
    Transaction transaction3 = new Transaction(date, -500.11, 2500.11);

    accountStatement.addTransaction(transaction1);
    accountStatement.addTransaction(transaction2);
    accountStatement.addTransaction(transaction3);

    assertEquals(accountStatement.printStatement(),
        "date || credit || debit || balance\n11/02/2018 || || 500.11 || 2500.11\n"
            + "11/02/2018 || 2000.11 || || 3000.22\n11/02/2018 || 1000.11 || || 1000.11\n");
  }
}
