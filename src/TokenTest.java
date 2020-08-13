import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TokenTest {

  /**
   * Testing the isOperand() method.
   */
  @Test
  void isOperandTest() {
    boolean actual1 = Token.isOperand("0");
    Assertions.assertTrue(actual1);

    boolean actual2 = Token.isOperand("1");
    Assertions.assertTrue(actual2);

    boolean actual3 = Token.isOperand("5");
    Assertions.assertTrue(actual3);

    boolean actual4 = Token.isOperand("9");
    Assertions.assertTrue(actual4);

    boolean actual5 = Token.isOperand(" ");
    Assertions.assertFalse(actual5);

    boolean actual6 = Token.isOperand("%");
    Assertions.assertFalse(actual6);

    boolean actual7 = Token.isOperand("x");
    Assertions.assertFalse(actual7);
  }

  /**
   * Testing the method that applies saturation arithmetic.
   */
  @Test
  void saturateTest() {
    long actual1 = Token.saturateOperand(-9000000000L);
    Assertions.assertEquals(Integer.MIN_VALUE, actual1);

    long actual2 = Token.saturateOperand(-2147483648);
    Assertions.assertEquals(Integer.MIN_VALUE, actual2);

    long actual3 = Token.saturateOperand(9000000000L);
    Assertions.assertEquals(Integer.MAX_VALUE, actual3);

    long actual4 = Token.saturateOperand(2147483647);
    Assertions.assertEquals(Integer.MAX_VALUE, actual4);

    long actual5 = Token.saturateOperand(0);
    Assertions.assertEquals(0, actual5);

    long actual6 = Token.saturateOperand(128);
    Assertions.assertEquals(128, actual6);
  }


}
