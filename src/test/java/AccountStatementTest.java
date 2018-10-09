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

  @Test 
  public void printStatementFormatsInfoCorrectly() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(date);
    Transaction transaction1 = new Transaction(new Date(), 1000.00, 1000.00);
    accountStatement.addTransaction(transaction);
    Transaction transaction2 = new Transaction(new Date(), 2000.00, 3000.00);
    accountStatement.addTransaction(transaction);
    Transaction transaction3 = new Transaction(new Date(), -500.00, 2500.00);
    accountStatement.addTransaction(transaction);
    assertEquals(accountStatement.printStatement(), "date || credit || debit || balance
                                                    14/01/2012 || || 500.00 || 2500.00
                                                    13/01/2012 || 2000.00 || || 3000.00
                                                    10/01/2012 || 1000.00 || || 1000.00")
  }
}
