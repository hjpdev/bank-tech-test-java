import main.java.Account;

import org.junit.Before;
import org.junit.Test;
import com.sun.source.tree.AssertTree;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.text.Format;
import java.util.Date;

public class FeatureTest {
  private Account account;

  @Before
  public void setup() {
    account = new Account();
  }

  @Test
  public void featureTest() {
    Format dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String strDate = dateFormatter.format(new Date());

    account.deposit(500);
    account.withdraw(250);

    assertEquals(account.returnStatement().printStatement(), "date || credit || debit || balance\n" + strDate
        + " || || 250.0 || 250.0\n" + strDate + " || 500.0 || || 500.0\n");
  }
}
