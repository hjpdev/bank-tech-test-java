import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class AcountStatementTest {

  private AccountStatement accountStatement;

  @Before
  public void setup() {
    accountStatement = new AccountStatement();
  }
}
