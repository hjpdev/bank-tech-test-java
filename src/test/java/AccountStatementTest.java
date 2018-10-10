import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

import main.java.AccountStatement;
import main.java.Transaction;

public class AccountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
  }

  @Test
  public void addTransactionAddsDetails() {
    Transaction transaction = new Transaction(new Date(), 10.23, 10.23);

    accountStatement.addTransaction(transaction);

    assertEquals(transaction.info, accountStatement.returnLog().get(0));
  }

  @Test
  public void printStatementFormatsInfoCorrectly() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    Transaction transaction1 = new Transaction(new Date(), 1000.11, 1000.11);
    Transaction transaction2 = new Transaction(new Date(), 2000.11, 3000.22);
    Transaction transaction3 = new Transaction(new Date(), -500.11, 2500.11);

    accountStatement.addTransaction(transaction1);
    accountStatement.addTransaction(transaction2);
    accountStatement.addTransaction(transaction3);

    assertEquals(accountStatement.printStatement(),
        "date || credit || debit || balance\n" + strDate + " || || 500.11 || 2500.11\n" + strDate
            + " || 2000.11 || || 3000.22\n" + strDate + " || 1000.11 || || 1000.11\n");
  }
}
