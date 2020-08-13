import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleTest {

  SRPN srpn;


  // initialise calculator in constructor
  public ConsoleTest() {
    srpn = new SRPN();
  }

  @Test
  void separateElementsTest1() {
    String actual1 = Console.delimitConsoleInput("15 7 1 1 + - / 3 * 2 1 1 + + -");
    String expected1 = "15 7 1 1 + - / 3 * 2 1 1 + + -";
    Assertions.assertEquals(expected1, actual1);

    String actual2 = Console.delimitConsoleInput("-15 7 1 1 + - / 3 * 2 1 1 + + -");
    String expected2 = "-15 7 1 1 + - / 3 * 2 1 1 + + -";
    Assertions.assertEquals(expected2, actual2);

    String actual3a = Console.delimitConsoleInput("15 -7 1 1 + - / 3 * 2 1 1 + + -");
    String actual3b = Console.delimitConsoleInput("15 -7 1 1 + - / 3 * 2 1 1 + +-");
    String actual3c = Console.delimitConsoleInput("15 -7 1 1 + - / 3 * 2 1 1 ++-");
    String actual3d = Console.delimitConsoleInput("15 -7 1 1 + - / 3 * 2 1 1++-");
    String actual3e = Console.delimitConsoleInput("15 -7 1 1 + - / 3 *2 1 1++-");
    String actual3f = Console.delimitConsoleInput("15 -7 1 1 + - / 3*2 1 1++-");
    String actual3g = Console.delimitConsoleInput("15 -7 1 1 + - /3*2 1 1++-");
    String actual3h = Console.delimitConsoleInput("15 -7 1 1 + -/3*2 1 1++-");
    String actual3i = Console.delimitConsoleInput("15 -7 1 1 +-/3*2 1 1++-");
    String actual3j = Console.delimitConsoleInput("15 -7 1 1+-/3*2 1 1++-");
    String actual3k = Console.delimitConsoleInput("15-7 1 1+-/3*2 1 1++-");
    String actual3l = Console.delimitConsoleInput("15-7 1 1+-/3*2 1 #/# 1++-");
    String actual3m = Console.delimitConsoleInput("15-7 1 1+-/3*2 1 ## 1++-");
    String actual3n = Console.delimitConsoleInput("15-7 1 1+-/3*2 1 # comment # 1++-");
    String actual3o = Console.delimitConsoleInput("15 -7 1 1 + - /3*2 1 1++- # end #");
    String actual3p = Console.delimitConsoleInput("# start # 15 -7 1 1 + - /3*2 1 1++- # end #");
    String actual3q = Console.delimitConsoleInput("# start # 15 -7 1 1 + #mid# - /3*2 1 1++- # end #");
    String expected3 = "15 -7 1 1 + - / 3 * 2 1 1 + + -";
    Assertions.assertEquals(expected3, actual3a);
    Assertions.assertEquals(expected3, actual3b);
    Assertions.assertEquals(expected3, actual3c);
    Assertions.assertEquals(expected3, actual3d);
    Assertions.assertEquals(expected3, actual3e);
    Assertions.assertEquals(expected3, actual3f);
    Assertions.assertEquals(expected3, actual3g);
    Assertions.assertEquals(expected3, actual3h);
    Assertions.assertEquals(expected3, actual3i);
    Assertions.assertEquals(expected3, actual3j);
    Assertions.assertEquals(expected3, actual3k);
    Assertions.assertEquals(expected3, actual3l);
    Assertions.assertEquals(expected3, actual3m);
    Assertions.assertEquals(expected3, actual3n);
    Assertions.assertEquals(expected3, actual3o);
    Assertions.assertEquals(expected3, actual3p);
    Assertions.assertEquals(expected3, actual3q);
  }

  @Test
  void separateElementsTest2() {

    String actual1a = Console.delimitConsoleInput("r r r r r r r r r r");
    String actual1b = Console.delimitConsoleInput("rrrrr         rrrrr");
    String actual1c = Console.delimitConsoleInput("rrrrrrrrrr");
    String expected1 = "r r r r r r r r r r";
    Assertions.assertEquals(expected1, actual1a);
    Assertions.assertEquals(expected1, actual1b);
    Assertions.assertEquals(expected1, actual1c);

    String actual2a = Console.delimitConsoleInput("d d d d d d d d d d");
    String actual2b = Console.delimitConsoleInput("dd dd d d dd dd");
    String actual2c = Console.delimitConsoleInput(" d dd ddd dddd ");
    String expected2 = "d d d d d d d d d d";
    Assertions.assertEquals(expected2, actual2a);
    Assertions.assertEquals(expected2, actual2b);
    Assertions.assertEquals(expected2, actual2c);

    String actual3a = Console.delimitConsoleInput(" d r d d d d d d d r");
    String actual3b = Console.delimitConsoleInput("   d  rd d d ddd dr ");
    String actual3c = Console.delimitConsoleInput("dr dddddddr ");
    String actual3d = Console.delimitConsoleInput("dr dddd # dr # dddr ");
    String expected3 = "d r d d d d d d d r";
    Assertions.assertEquals(expected3, actual3a);
    Assertions.assertEquals(expected3, actual3b);
    Assertions.assertEquals(expected3, actual3c);
    Assertions.assertEquals(expected3, actual3d);

    String actual4a = Console.delimitConsoleInput(" 5 r x £ d . d d -5 r");
    String actual4b = Console.delimitConsoleInput("   5  rx £ d .dd -5r ");
    String actual4c = Console.delimitConsoleInput("5r x£d.dd-5r ");
    String actual4d = Console.delimitConsoleInput("# comment # 5r x£d.dd-5r ");
    String actual4e = Console.delimitConsoleInput("# comment # 5r x£d.dd-5r # comment #");
    String expected4 = "5 r x £ d . d d -5 r";
    Assertions.assertEquals(expected4, actual4a);
    Assertions.assertEquals(expected4, actual4b);
    Assertions.assertEquals(expected4, actual4c);
    Assertions.assertEquals(expected4, actual4d);
    Assertions.assertEquals(expected4, actual4e);

  }

  @Test
  void separateElementsTest3() {
    String actual1a = Console.delimitConsoleInput("dd  10  drr  r1d2rd-10  3+  r51*-1d/d/r/1d-5      dr ");
    String actual1b = Console.delimitConsoleInput("d d 10 drr r1d2rd-10 3+ r51*-1d/d/r/1d-5 dr   ");
    String actual1c = Console.delimitConsoleInput("dd10drrr1d2rd-10 3+r51*-1d/d/r/1d-5dr");
    String actual1d = Console.delimitConsoleInput("dd10drrr1d2rd-10 3+r51*-#comment#1d/d/r/1d-5dr");
    String expected1 = "d d 10 d r r r 1 d 2 r d -10 3 + r 51 * -1 d / d / r / 1 d -5 d r";
    Assertions.assertEquals(expected1, actual1a);
    Assertions.assertEquals(expected1, actual1b);
    Assertions.assertEquals(expected1, actual1c);
    Assertions.assertEquals(expected1, actual1d);

    String actual2a = Console.delimitConsoleInput("15 r 1 1 + - / 3 * 2 r 1 + + -");
    String expected2 = "15 r 1 1 + - / 3 * 2 r 1 + + -";
    Assertions.assertEquals(expected2, actual2a);
  }

  @Test
  void separateElementsTest4() {
    String actual1 = Console.delimitConsoleInput("");
    String expected1 = "";
    Assertions.assertEquals(expected1, actual1);

    String actual2 = Console.delimitConsoleInput("d");
    String expected2 = "d";
    Assertions.assertEquals(expected2, actual2);

    String actual3 = Console.delimitConsoleInput("r");
    String expected3 = "r";
    Assertions.assertEquals(expected3, actual3);

    String actual4 = Console.delimitConsoleInput("-");
    String expected4 = "-";
    Assertions.assertEquals(expected4, actual4);

    String actual5 = Console.delimitConsoleInput("0");
    String expected5 = "0";
    Assertions.assertEquals(expected5, actual5);
  }
}
