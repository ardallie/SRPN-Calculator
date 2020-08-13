import java.util.ArrayList;
import java.util.Iterator;

/**
 * LIFO Stack data type built with a linked list.
 * Implementation is based on Sedgewick R., Wayne K., Algorithms 4th edn., pp. 149 - 151
 * *
 * To comply with the legacy SRPN Calculator, the following modifications have been made:
 * 1. The stack has been limited to 23 items
 * 2. pop() prints "Stack underflow." and returns null if empty.
 * .  Standard implementation thows No Such Element Exception.
 * 3. printBottomUp() method was added, it prints stack content in the reversed order (bottom-up)
 *
 * @param <Item> Object type to be stored
 */
public class Stack<Item> implements Iterable<Item> {

  private Node first;
  private int len;

  private class Node {
    // nested class to define Nodes
    Item item;
    Node next;
  }

  /**
   * Constructor.
   */
  public Stack() {
  }

  /**
   * Check if the stack is empty.
   *
   * @return true if empty, false if not
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * Checks the number of items.
   *
   * @return number of items on stack
   */
  public int size() {
    return len;
  }

  /**
   * Adds an item on the top of the stack (LIFO).
   *
   * @param item element to be added
   */
  public void push(Item item) {
    if (item == null) {
      throw new IllegalArgumentException("The item cannot be null");
    }
    // artificial limit of 22 elements to comply with the legacy SRPN Calculator
    if (this.size() <= 22) {
      Node oldFirst = first;
      first = new Node();
      first.item = item;
      first.next = oldFirst;
      len++;
    } else {
      // stack is full, print the message to console
      System.out.println("Stack overflow.");
    }
  }

  /**
   * Remove and return the item from the top of the stack (LIFO)
   * If stack is empty, null is returned.
   *
   * @return element from the top
   */
  public Item pop() {
    if (isEmpty()) {
      System.out.println("Stack underflow.");
      return null;
    }
    Item item = first.item;
    first = first.next;
    len--;
    return item;
  }

  /**
   * Return the item from the top of the stack (LIFO) without removing it
   * If stack is empty, null is returned.
   *
   * @return element from the top
   */
  public Item peek() {
    if (isEmpty()) {
      System.out.println("Stack underflow.");
      return null;
    }
    return first.item;
  }

  /**
   * Prints all items on stack in the reversed order (bottom-up)
   * *
   * Deque ADT would be more suitable for this task since it uses the 'last' field
   * as well as the 'first'. Without it, the bottom-up order cannot be built directly into iterator
   * the stack content must be copied first then iterated, increasing time complexity from N to 2N
   */
  public void printBottomUp() {
    if (this.isEmpty()) {
      System.out.println(Integer.MIN_VALUE);
    } else {
      ArrayList<String> copy = new ArrayList<>();
      for (Item item : this) {
        copy.add(item.toString());
      }
      for (int i = copy.size() - 1; i >= 0; i--) {
        System.out.println(copy.get(i));
      }
    }
  }

  /**
   * Returns an iterator over items in order from top to bottom.
   *
   * @return iterator object
   */
  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public Item next() {
      if (isEmpty()) {
        throw new NullPointerException("There are no elements in collection");
      }
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

}