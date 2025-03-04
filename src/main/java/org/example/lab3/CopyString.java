package org.example.lab3;

import java.util.Scanner;
import org.example.lab3.SymbolCounter;

public class CopyString {
  public static String copyPartOfString(String str, int start, int end) {
    int finalLength = end - start;

    if (finalLength < 0) {
      return "";
    }

    char[] arrayStr = str.toCharArray();
    char[] result = new char[finalLength];

    System.arraycopy(arrayStr, start, result, 0, finalLength);

    return new String(result);
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a string:");
    String str = scanner.nextLine();

    System.out.println("Enter the character: ");
    char symbol = scanner.next().charAt(0);

    String result = copyPartOfString(str, 0, 3);

    System.out.println(
        "The symbol "
            + symbol
            + " appears "
            + SymbolCounter.symbolCounter(result.toCharArray(), symbol)
            + " times in the word "
            + result);
  }
}
