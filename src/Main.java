import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SRPN Calculator.
 */
class Main {

  /**
   * Main method.
   *
   * @param args console input
   */
  public static void main(String[] args) {

    SRPN srpn = new SRPN();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    try {
      // Keep on accepting input from the command-line
      while (true) {
        String consoleInput = reader.readLine();
        // Close on an End-of-file (EOF) (Ctrl-D on the terminal)
        if (consoleInput == null) {
          // Exit code 0 for a graceful exit
          System.exit(0);
        }
        // Otherwise, (attempt to) process the character
        srpn.processCommand(consoleInput);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.exit(1);
    }
  }

}
