import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// import jdk.internal.jline.internal.TestAccessible;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class AccountTest {

  private Account account;

  @Before
  public void setup() {
    account = new Account();
  }

  @Test
  public void zeroBalanceTest() {
    assertTrue(account.currentBalance() == 0.00);
  }

  @Test
  public void accountStatementTest() {
    assertTrue(account.log instanceof AccountStatement);
  }

  @Test
  public void depositIncreasesBalance() {
    account.deposit(10.00);
    assertTrue(account.currentBalance() == 10.00);
  }

  @Test
  public void withdrawReducesBalance() {
    account.deposit(10.00);
    account.withdraw(5.50);
    assertTrue(account.currentBalance() == 4.50);
  }
}
