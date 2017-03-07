// **********************************************************
// Author:hongyu luo
// Cryptsy Trender
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package driver;

import java.io.IOException;
import java.util.Scanner;

import systems.*;


public class MyParser {

  /**
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    // keeps asking user for input
      System.out.println("enter the market ID");
      String input = in.nextLine();
      // parses whitespace
      // String[] input_string = input.split("\\s+");
      // uses in
      while (true) {
      Parser new_parse =
          new Parser(
              "http://pubapi.cryptsy.com/api.php?method=singlemarketdata&marketid="
                  + input);
      // deletes newparse for the garbage collector
      new_parse = null;
    }
  }
}
