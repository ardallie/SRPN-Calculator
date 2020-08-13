import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void isEmpty() {
    Stack<String> stack = new Stack<>();
    Assertions.assertTrue(stack.isEmpty());
    stack.push("Item A");
    Assertions.assertFalse(stack.isEmpty());
  }

  @Test
  void size() {
    Stack<String> stack = new Stack<>();
    Assertions.assertEquals(0, stack.size());
    stack.push("Item A");
    stack.push("Item B");
    stack.push("Item C");
    Assertions.assertEquals(3, stack.size());
  }

  @Test
  void push() {
    Stack<String> stack = new Stack<>();
    stack.push("Item A");
    stack.push("Item B");
    stack.push("Item C");
    Assertions.assertEquals(3, stack.size());
  }

  @Test
  void pop() {
    Stack<String> stack = new Stack<>();

    // add items
    stack.push("Item A");
    stack.push("Item B");
    stack.push("Item C");

    // remove items
    Assertions.assertEquals(3, stack.size());

    Object itemC = stack.pop();
    Assertions.assertEquals("Item C", itemC);
    Assertions.assertEquals(2, stack.size());

    Object itemB = stack.pop();
    Assertions.assertEquals("Item B", itemB);
    Assertions.assertEquals(1, stack.size());

    Object itemA = stack.pop();
    Assertions.assertEquals("Item A", itemA);
    Assertions.assertEquals(0, stack.size());

    // attempt to remove element from an empty collection
    Object empty = stack.pop();
    Assertions.assertNull(empty);
  }

  @Test
  void iterator() {
    Stack<String> stack = new Stack<>();

    // add items
    stack.push("Item A");
    stack.push("Item B");
    stack.push("Item C");

    int index = 0;
    String[] arr = new String[]{"Item C", "Item B", "Item A"};
    for (String item : stack) {
      Assertions.assertEquals(arr[index], item);
      index++;
    }
  }
}