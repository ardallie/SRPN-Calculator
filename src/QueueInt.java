/**
 * Managing the series of read-only numbers that can be invoked with the 'r' command
 * Numbers are stored in the Queue of Integers that inherits from the ADT Queue.
 */
public class QueueInt extends Queue<Integer> {

  /**
   * Constructor to initialise and fill up the queue with predefined numbers.
   */
  public QueueInt() {
    initNumbers();
  }

  /**
   * Load up a queue with numbers copied from the legacy SRPN Calculator
   * r r r r r r r r r r r r r r r r r r r r r r d (console input).
   */
  private void initNumbers() {
    this.enqueue(1804289383);
    this.enqueue(846930886);
    this.enqueue(1681692777);
    this.enqueue(1714636915);
    this.enqueue(1957747793);

    this.enqueue(424238335);
    this.enqueue(719885386);
    this.enqueue(1649760492);
    this.enqueue(596516649);
    this.enqueue(1189641421);

    this.enqueue(1025202362);
    this.enqueue(1350490027);
    this.enqueue(783368690);
    this.enqueue(1102520059);
    this.enqueue(2044897763);

    this.enqueue(1967513926);
    this.enqueue(1365180540);
    this.enqueue(1540383426);
    this.enqueue(304089172);
    this.enqueue(1303455736);

    this.enqueue(35005211);
    this.enqueue(521595368);
  }

  /**
   * Returns next number from the queue.
   * The same number is enqueued again for the next round.
   *
   * @return a number from the beginning of the queue
   */
  public int getNumber() {
    // remove first item from the queue
    int num = this.dequeue();
    // add it back to the end of the queue
    this.enqueue(num);
    return num;
  }

}
