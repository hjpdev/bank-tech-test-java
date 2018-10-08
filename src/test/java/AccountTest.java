import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// import jdk.internal.jline.internal.TestAccessible;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;
import java.util.ArrayList;
import java.util.Hashtable;

public class AccountTest {

  private Account account;
  private AccountStatement accountStatement;

  @Before
  public void setup() {
    account = new Account();
  }

  @Test
  public void zeroBalanceTest() {
    assertTrue(account.currentBalance() == 0.00);
  }

  @Test
  public void depositIncreasesBalance() {
    account.deposit(10.00);
    assertTrue(account.currentBalance() == 10.00);
  }

  @Test
  public void depositAddsTransactionToStatement() {
    Date date = new Date();
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String formattedDate = dateFormatter.format(date);
    AccountStatement testLog = new AccountStatement();
    Hashtable<String, String> testTrans = new Hashtable<>();
    testTrans.put("date", formattedDate);
    testTrans.put("amount", "10.0");
    testTrans.put("balance", "10.0");
    testLog.add(testTrans);
    account.deposit(10.00);
    assertTrue(account.returnStatement() == testLog);
  }

  @Test
  public void withdrawReducesBalance() {
    account.deposit(10.00);
    account.withdraw(5.50);
    assertTrue(account.currentBalance() == 4.50);
  }
}
