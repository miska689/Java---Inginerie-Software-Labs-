package org.example.lab3;

import java.util.Scanner;
import org.example.lab3.PrintBase;

public class SplitBytes {
  public static void main() {
    Scanner scanner = new Scanner(System.in);

    int mask = 0b11111111;

    System.out.println("Enter a number bigger that 16.777.216:");
    int n = scanner.nextInt();
    int result = 0;

    for (int i = 0; i < 4; i++) {
      result = n & (mask << (i * 8));
      System.out.println("Byte " + (i + 1) + ": " + result);

      System.out.print("Biniary: ");
      PrintBase.printBase(result, 2);
      System.out.println();

      System.out.print("Octal: ");
      PrintBase.printBase(result, 8);
      System.out.println();

      System.out.print("Hexadecimal: ");
      PrintBase.printBase(result, 16);
      System.out.println();
      System.out.println();
    }
  }
}
