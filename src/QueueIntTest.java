import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueIntTest {

  QueueInt queueInt;

  // initialise queue of numbers in constructor
  public QueueIntTest() {
    queueInt = new QueueInt();
  }

  /**
   * Initial length check.
   */
  @Test
  void lengthTest() {
    QueueInt queueInt = new QueueInt();
    int actual = queueInt.size();
    int expected = 22;
    Assertions.assertEquals(expected, actual);
  }

  /**
   * Make sure the queue can be iterated using for each loop.
   */
  @Test
  void forEachTest() {
    for (int num : queueInt) {
      Assertions.assertNotEquals(0, num);
    }
  }

  /**
   * Test values of the top 5 items.
   */
  @Test
  void valueTest() {
    Assertions.assertEquals(1804289383, queueInt.getNumber());
    Assertions.assertEquals(846930886, queueInt.getNumber());
    Assertions.assertEquals(1681692777, queueInt.getNumber());
    Assertions.assertEquals(1714636915, queueInt.getNumber());
    Assertions.assertEquals(1957747793, queueInt.getNumber());
  }

  /**
   * Get a number from queue 500 times and make sure the queue has the same length.
   */
  @Test
  void iterationTest() {
    for (int i = 0; i < 500; i++) {
      int num = queueInt.getNumber();
      int length = queueInt.size();
      Assertions.assertNotEquals(0, num);
      Assertions.assertEquals(22, length);
    }
  }

}
