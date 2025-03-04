package org.example.lab3;

import java.util.Scanner;

public class PrintBase {
  /**
   * Prints the number in the given base.
   *
   * @param number the number to be printed
   * @param base the base in which the number will be printed
   */
  public static void printBase(int number, int base) {
    if (base > 16 || base < 2) {
      return;
    }

    if (number >= base) {
      printBase(number / base, base);
    }

    if (number % base > 9) {
      System.out.print((char) (number % base + 55));
    } else {
      System.out.print(number % base);
    }
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int number = scanner.nextInt();

    System.out.print(number + " in base 2: ");
    printBase(number, 2);
    System.out.println();
    System.out.println();

    System.out.print(number + " in base 8: ");
    printBase(number, 8);
    System.out.println();
    System.out.println();

    System.out.print(number + " in base 16: ");
    printBase(number, 16);
    System.out.println();
    System.out.println();
  }
}
