import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility methods relating to a single token
 * e.g. check token type, saturate token
 */
public class Token {

  /**
   * Checks if the token is an operand (0-9).
   *
   * @param op a single token from the input string
   * @return true if the token is an operand, false if not
   */
  public static boolean isOperand(String op) {
    Pattern pattern = Pattern.compile("^[\\d]|^-[\\d]");
    Matcher matcher = pattern.matcher(op);
    return matcher.find();
  }


  /**
   * Checks if the token is an operator + - * / : ^ etc.
   *
   * @param op a single token from the input string
   * @return true if the token is an operator, false if not
   */
  public static boolean isOperator(String op) {
    Pattern pattern = Pattern.compile("^[+\\-*/^%]");
    Matcher matcher = pattern.matcher(op);
    return matcher.find();
  }


  /**
   * Checks if the token is a command such as 'd' or 'r'.
   *
   * @param op a single token from the input string
   * @return true if the token is a command, false if not
   */
  public static boolean isCommand(String op) {
    Pattern pattern = Pattern.compile("^[dr=]");
    Matcher matcher = pattern.matcher(op);
    return matcher.find();
  }


  /**
   * Saturation arithmetic prevents wrapping around
   * if the number is over the integer's size limit.
   *
   * @param result the long result that might be over integer's size limit
   * @return the result within boundaries of an integer
   */
  public static long saturateOperand(long result) {
    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return result;
  }

}
