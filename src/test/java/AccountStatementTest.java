import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class AcountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
  }

  @Test
  public void addTransactionAddsDetails() {
    Date formattedDate = dateFormatter.format(date);
    Hashtable testLog = new Hashtable<>();
    testLog.put("date", formattedDate);
    testLog.put("amount", 10);
    testLog.put("balance", 10);
    accountStatement.addTransaction(formattedDate, 10, 10);
    assertArrayEquals(accountStatement.log == testLog);
  }
}
