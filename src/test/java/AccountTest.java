import main.java.Account;
import main.java.AccountStatement;
import main.java.CantExceedOverdraftException;

import org.junit.Before;
import org.junit.Test;
import com.sun.source.tree.AssertTree;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
    AccountStatement mockAccountStatement = mock(AccountStatement.class);
    when(mockAccountStatement.printStatement()).thenReturn("Message received by statement");
    Account testAccount = new Account(0, 0, mockAccountStatement);

    testAccount.deposit(10.25);

    assertEquals(testAccount.returnStatement().printStatement(), "Message received by statement");
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
    AccountStatement mockAccountStatement = mock(AccountStatement.class);
    when(mockAccountStatement.printStatement()).thenReturn("Message received by statement");
    Account testAccount = new Account(0, 0, mockAccountStatement);

    testAccount.deposit(20.50);
    testAccount.withdraw(10.25);

    assertEquals(testAccount.returnStatement().printStatement(), "Message received by statement");
  }

  @Test(expected = CantExceedOverdraftException.class)
  public void cannotWithdrawOverODLimit() {
    account.withdraw(5000);
  }
}
