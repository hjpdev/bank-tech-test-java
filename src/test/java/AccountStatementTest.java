import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

public class AcountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
  }

  @Test
  public void addTransactionAddsDetails() {
    String formattedDate = dateFormatter.format(date);
    ArrayList<Hashtable> testLog = new ArrayList<Hashtable>();
    Hashtable<String, String> testTrans = new Hashtable<>();
    testTrans.put("date", formattedDate);
    testTrans.put("amount", "10.00");
    testTrans.put("balance", "10.00");
    testLog.add(testTrans);
    accountStatement.addTransaction(formattedDate, 10.00, 10.00);
    assertArrayEquals(accountStatement.log == testLog);
  }
}
