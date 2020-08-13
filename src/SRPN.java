public class SRPN {

  // declare the Stack for operands
  private Stack<String> stack;
  // declare Queue of Integers for the 'r' command
  private QueueInt queueInt;

  /**
   * Constructor to instantiate the Stack and the Queue of Integers.
   */
  public SRPN() {
    stack = new Stack<>();
    queueInt = new QueueInt();
    Console.initialiseConsole();
  }

  /**
   * Retrieves the next number from the Queue of Integers.
   *
   * @return next number from the Queue of Integers
   */
  private String readOnlyNumber() {
    int readOnlyNum = queueInt.getNumber();
    return Integer.toString(readOnlyNum);
  }

  /**
   * Executes the command such as 'r' or 'd' or '='.
   *
   * @param command a command to be executed
   */
  private void executeCommand(String command) {
    switch (command) {
      case "r":
        stack.push(readOnlyNumber());
        break;
      case "d":
        stack.printBottomUp();
        break;
      case "=":
        printResult();
        break;
      default:
        break;
    }
  }

  /**
   * Prints to console the value of an operand from the stack.
   */
  private void printResult() {
    if (stack.isEmpty()) {
      System.out.println("Stack empty.");
    } else {
      System.out.println(stack.peek());
    }
  }

  /**
   * Takes two operands from stack and perform the operation with a provider operator.
   *
   * @param operator denotes operation type (addition, substraction, division etc.)
   * @return result of the evaluation
   */
  private String performArithOperation(String operator) {
    if (stack.size() >= 2) {
      // Safe to evaluate
      // apply saturation arithmetic to both operands
      String elementB = stack.pop();
      String elementA = stack.pop();
      long opB = Token.saturateOperand(Long.parseLong(elementB));
      long opA = Token.saturateOperand(Long.parseLong(elementA));
      long rawResult = reduceOperands(opA, opB, operator);
      // saturation also needs to be applied on the result
      long satResult = Token.saturateOperand(rawResult);
      return Long.toString(satResult);
    } else {
      // Stack underflow since at least one element is null
      return null;
    }
  }

  /**
   * Reduces two operands to a single result
   * by performing an arithmetical operation.
   * TODO: change long to more precise type for the cases like 0.67 * 30 = 20, and not 0 * 30 = 0
   *
   * @param a        operand A
   * @param b        operand B
   * @param operator denotes operation type (addition, substraction, division etc.)
   * @return result of the arithmetical operation
   * @throws ArithmeticException if divisor is 0
   */
  public long reduceOperands(long a, long b, String operator) {
    switch (operator) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        if (b == 0) {
          System.out.println("Divide by 0.");
          // Legacy SRPN returns the operands to the stack
          stack.push(String.valueOf((int) a));
          return b;
        }
        return a / b;
      case "%":
        if (a == 0) {
          System.out.println("Divide by 0.");
          // Legacy SRPN returns the operands to the stack
          stack.push(String.valueOf((int) a));
          return b;
        }
        if (b == 0) {
          // Legacy SRPN throws an error and terminates the application when mod by zero.
          // To preserve the accuracy of this emulation, the fallback has NOT been added
          // and this application will terminate when mod by zero, e.g. `5 0 %`
          throw new ArithmeticException();
        }
        return a % b;
      case "^":
        if (b < 0) {
          System.out.println("Negative power.");
          // Legacy SRPN returns the operands to the stack
          stack.push(String.valueOf((int) a));
          return b;
        } else {
          return (long) Math.pow(a, b);
        }
      default:
        return 0;
    }
  }

  /**
   * Computes the entire expression in Reverse Polish Notation.
   *
   * @param tokens expression tokens that are already parsed and split to Array of Strings
   */
  public Long evaluateExpression(String[] tokens) {
    for (String token : tokens) {
      // token is a command that needs to be executed
      if (Token.isCommand(token)) {
        executeCommand(token);
        continue;
      }
      // token is an operand, push it to stack and move on
      if (Token.isOperand(token)) {
        stack.push(token);
        continue;
      }
      // token is an operator, evaluate
      if (Token.isOperator(token)) {
        String result = performArithOperation(token);
        if (result != null) {
          stack.push(result);
        }
        continue;
      }
      // token is illegal
      Console.printInputError(token);
    }
    // all tokens have been processed
    if (stack.isEmpty()) {
      return null;
    }
    return Long.parseLong(stack.peek());
  }

  /**
   * Parsing the console input and forwarding the tokens to the calculator
   *
   * @param consoleInput user input from the console
   * @return result of the calculation
   */
  public Long processCommand(String consoleInput) {
    // NOP is input string is empty
    if (consoleInput.equals("")) {
      return null;
    }
    // Parse the string from the console into tokens
    String[] tokens = Console.parseConsoleInput(consoleInput);
    // Evaluate the expression
    return evaluateExpression(tokens);
  }

}
