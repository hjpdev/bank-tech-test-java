import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

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
}
