import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TransactionTest {
  private Transaction transaction;

  @Before
  public void setup() {
    transaction = new Transaction();
  }
}
