import main.java.Account;

import org.junit.Before;
import org.junit.Test;
import com.sun.source.tree.AssertTree;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

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
  public void depositIncreasesBalance() {
    account.deposit(10.00);

    assertTrue(account.currentBalance() == 10.00);
  }

  @Test
  public void depositAddsInfoToStatement() {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(new Date());

    account.deposit(10.25);

    assertEquals(account.returnStatement().printStatement(),
        "date || credit || debit || balance\n" + strDate + " || 10.25 || || 10.25\n");
  }

  @Test
  public void withdrawReducesBalance() {
    account.deposit(10.00);
    account.withdraw(5.50);

    assertTrue(account.currentBalance() == 4.50);
  }

  @Test
  public void withdrawAddsInfoToStatement() {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(new Date());
    account.deposit(20.50);
    account.withdraw(10.25);

    assertEquals(account.returnStatement().printStatement(),
        "date || credit || debit || balance\n" + strDate + " || || 10.25 || 10.25\n");
  }

  @Test(expected = cantExceedOverdraftException.class)
  public void cannotWithdrawOverODLimit() {
    account.withdraw(5000);
  }
}
