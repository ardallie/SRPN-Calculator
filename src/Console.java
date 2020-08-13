/**
 * Parsing the user input from the console.
 */
public class Console {

  /**
   * The process of cleaning, parsing and splitting
   * the console input string into the array of tokens
   *
   * @param consoleInput input string from the console
   * @return String array with parsed operators, operands and commands
   */
  public static String[] parseConsoleInput(String consoleInput) {
    String lower = consoleInput.toLowerCase();
    return delimitConsoleInput(lower).split(" ");
  }


  /**
   * Uses regular expressions to correctly delimit the console input
   * with spaces (e.g from '15r5 1/+' to '15 r 5 1 / +')
   * Regex features such as lookahead and groups are used.
   *
   * @param consoleInput input string from the console
   * @return string of the input tokens correctly delimited with spaces
   */
  public static String delimitConsoleInput(String consoleInput) {
    // 1. remove comments
    // 2. remove multiple spaces
    // 3. split two bundled characters (but only when the second character is not a digit)
    // 4. split bundled command/operator and a digit. Excl. minus to keep negative numbers intact.
    // 5. trim (remove leading and trailing spaces)
    return consoleInput
        .replaceAll("#[^#]+#|##", "")
        .replaceAll(" +", " ")
        .replaceAll("([\\p{P}\\p{S}a-z0-9])(?=[\\p{P}\\p{S}a-z])", "$1 ")
        .replaceAll("([^- 0-9])(?=[0-9])", "$1 ")
        .trim();
  }

  /**
   * Console message on startup.
   * It has been disabled for compatibility.
   */
  public static void initialiseConsole() {
    System.out.println("RSPN Calculator v1 is running.");

  }

  /**
   * Prints out a message to the console if the user input is invalid.
   * ~~~ Improvement Idea ~~~
   * The legacy SRPN Calculator uses a single, generic message in response to the invalid input.
   * Method can be used to add specific messages, e.g. on detecting decimal point or parentheses.
   * To comply with the requirements, the extension has been disabled.
   *
   * @param op single element of the input string
   */
  public static void printInputError(String op) {
    switch (op) {
      case ")":
      case "(":
        System.out.println("Reverse Polish notation doesn't require parentheses.");
        break;
      case ".":
        System.out.println("The program performs operations on integers only.");
        break;
      default:
        System.out.println("Unrecognised operator or operand: \"" + op + "\".");
        break;
    }
    // additional guidance to complement the message above
    System.out.println("Please use only: 0 1 2 3 4 5 6 7 8 9 + - * / : ^ =");
  }

}
