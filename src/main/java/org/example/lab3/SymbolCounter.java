package org.example.lab3;

import java.util.Scanner;

public class SymbolCounter {
  public static int symbolCounter(char[] letters, char symbol) {
    int symbolCount = 0;

    for (char letter : letters) {
      if (letter == symbol) {
        symbolCount++;
      }
    }

    return symbolCount;
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter your word: ");
    String name = scanner.nextLine();

    char[] letters = name.toCharArray();

    System.out.print("Enter the symbol you want to count: ");
    char symbol = scanner.next().charAt(0);

    int symbolCount = SymbolCounter.symbolCounter(letters, symbol);

    System.out.println(
        "The symbol " + symbol + " appears " + symbolCount + " times in the word " + name);
  }
}
