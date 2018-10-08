import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

public class AccountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
  }

  @Test
  public void addTransactionAddsDetails() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormatter.format(date);
    ArrayList<Hashtable> testLog = new ArrayList<Hashtable>();
    Hashtable<String, String> testTrans = new Hashtable<>();
    testTrans.put("date", formattedDate);
    testTrans.put("amount", "10.0");
    testTrans.put("balance", "10.0");
    testLog.add(testTrans);
    accountStatement.addTransaction(date, 10.00, 10.00);
    assertEquals(testLog, accountStatement.returnLog());
  }
}
