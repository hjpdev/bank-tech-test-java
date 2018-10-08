import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

// import jdk.internal.jline.internal.TestAccessible;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class AccountTest {

  private Account account;

  @Before
  public void setup() {
    account = new Account();
  }

  @Test
  public void simpleTest() {
    assertEquals("Hello, world", account.helloWorld());
  }
}
