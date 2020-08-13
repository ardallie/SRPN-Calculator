import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SRPNTest {

  SRPN srpn;

  // initialise calculator in constructor
  public SRPNTest() {
    srpn = new SRPN();
  }

  /**
   * Testing the expressions where operands or result are over the limit of an integer.
   */
  @Test
  void evaluateExpressionTest1() {
    String[] tokens1 = {"3000000000", "0", "-"};
    Long actual1 = srpn.evaluateExpression(tokens1);
    Assertions.assertEquals(Integer.MAX_VALUE, actual1);

    String[] tokens2 = {String.valueOf(Integer.MAX_VALUE), "0", "-"};
    Long actual2 = srpn.evaluateExpression(tokens2);
    Assertions.assertEquals(Integer.MAX_VALUE, actual2);

    String[] tokens3 = {"-3000000000", "0", "-"};
    Long actual3 = srpn.evaluateExpression(tokens3);
    Assertions.assertEquals(Integer.MIN_VALUE, actual3);

    String[] tokens4 = {String.valueOf(Integer.MIN_VALUE), "0", "-"};
    Long actual4 = srpn.evaluateExpression(tokens4);
    Assertions.assertEquals(Integer.MIN_VALUE, actual4);

    String[] tokens5 = {"3000000000", "2", "/"};
    Long actual5 = srpn.evaluateExpression(tokens5);
    Assertions.assertEquals(1073741823, actual5);
  }

  @Test
  void evaluateExpressionTest2() {
    // 10 5 2 + * 7 5 - 2 10 *
    String[] tokens1 = {"10", "5", "2", "+", "*", "7", "5", "-", "2", "10", "*"};
    Long actual1 = srpn.evaluateExpression(tokens1);
    Assertions.assertEquals(20, actual1);
  }

  @Test
  void evaluateExpressionTest3() {
    // r r - r 10 / +
    String[] tokens = {"r", "r", "-", "r", "10", "/", "+"};
    Long actual = srpn.evaluateExpression(tokens);
    Assertions.assertEquals(1125527774, actual);
  }

  @Test
  void evaluateExpressionTest4() {
    // calculate one result to leave an element on stack
    String[] tokens1 = {"5", "2", "+"};
    Long actual1 = srpn.evaluateExpression(tokens1);
    Assertions.assertEquals(7, actual1);
    // should take a missing operand from stack
    String[] tokens2 = {"1", "+"};
    Long actual2 = srpn.evaluateExpression(tokens2);
    Assertions.assertEquals(8, actual2);
  }

  @Test
  void evaluateExpressionTest5() {
    // 0.67 * 30 = 20, and not 0 * 30 = 0
    String[] tokens1 = {"2", "3", "/", "30", "*"};
    Long actual1 = srpn.evaluateExpression(tokens1);
    // Assertions.assertEquals(20, actual1);

    // 1.5 * 10 = 15, and not 1 * 10 = 10
    String[] tokens2 = {"3", "2", "/", "10", "*"};
    Long actual2 = srpn.evaluateExpression(tokens2);
    // Assertions.assertEquals(15, actual1);

  }


  @Test
  void reduceOperandsTest1() {
    Long actual1 = srpn.reduceOperands(15, 5, "+");
    Assertions.assertEquals(20, actual1);

    Long actual2 = srpn.reduceOperands(15, 5, "-");
    Assertions.assertEquals(10, actual2);

    Long actual3 = srpn.reduceOperands(15, 5, "*");
    Assertions.assertEquals(75, actual3);
  }

  @Test
  void reduceOperandsTest2() {

    Long actual1 = srpn.reduceOperands(15, 5, "/");
    Assertions.assertEquals(3, actual1);

    Long actual2 = srpn.reduceOperands(15, 5, "%");
    Assertions.assertEquals(0, actual2);

    Long actual3 = srpn.reduceOperands(15, 5, "^");
    Assertions.assertEquals(759375, actual3);
  }


}
