import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

  SRPN srpn;

  // initialise calculator in constructor
  public MainTest() {
    srpn = new SRPN();
  }

  /**
   * Specification Test 1
   */
  @Test
  void specificationTest01() {

    Long actual1 = srpn.processCommand("10 2 + =");
    Assertions.assertEquals(12, actual1);

    Long actual2 = srpn.processCommand("11 3 - =");
    Assertions.assertEquals(8, actual2);

    Long actual3 = srpn.processCommand("9 4 * =");
    Assertions.assertEquals(36, actual3);

    Long actual4 = srpn.processCommand("11 3 / =");
    Assertions.assertEquals(3, actual4);

    Long actual5 = srpn.processCommand("11 3 % =");
    Assertions.assertEquals(2, actual5);
  }


  /**
   * Specification Test 2
   */
  @Test
  void specificationTest02() {
    Long actual1 = srpn.processCommand("3 3 * 4 4 * + =");
    Assertions.assertEquals(25, actual1);

    Long actual2 = srpn.processCommand("1234 2345 3456 d + d + d =");
    Assertions.assertEquals(7035, actual2);

  }


  /**
   * Specification Test 3
   */
  @Test
  void specificationTest03() {
    Long actual1 = srpn.processCommand("2147483647 1 + =");
    Assertions.assertEquals(2147483647, actual1);

    Long actual2 = srpn.processCommand("-2147483647 1 - = 20 - =");
    Assertions.assertEquals(-2147483648, actual2);

  }

  /**
   * Specification Test 4
   */
  @Test
  void specificationTest04() {
    Long actual1 = srpn.processCommand("100000 0 - d * =");
    Assertions.assertEquals(100000, actual1);
  }


  /**
   * Specification Test 5
   */
  @Test
  void specificationTest05() {
    Long actual1 = srpn.processCommand("1 +");
    Assertions.assertEquals(1, actual1);
    Long actual2 = srpn.processCommand("10 5 -5 + /");
    Assertions.assertEquals(0, actual2);
  }

  /**
   * Specification Test 6
   */
  @Test
  void specificationTest06() {
    Long actual11 = srpn.processCommand("11 + 1 + 1 + d");
    Assertions.assertEquals(13, actual11);
    Long actual12 = srpn.processCommand("3 3 ^ 3 ^ 3 ^ =");
    Assertions.assertEquals(Integer.MAX_VALUE, actual12);
  }

  /**
   * Specification Test 7
   */
  @Test
  void specificationTest07() {
    Long actual1 = srpn.processCommand("# This i s a comment # 1 2 + # And so i s t h i s # d");
    Assertions.assertEquals(3, actual1);
  }

  /**
   * Specification Test 8
   */
  @Test
  void specificationTest08() {
    Long actual1 = srpn.processCommand("r r r r r r r r r r r r r r r r r r r r r r d r r r d");
    Assertions.assertEquals(1804289383, actual1);
  }

}
