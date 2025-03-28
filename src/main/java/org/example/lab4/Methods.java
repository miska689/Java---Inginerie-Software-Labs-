package org.example.lab4;

import java.util.Scanner;

public class Methods {
  /**
   * Returns the arithmetic mean of the numbers.
   *
   * @param numbers the numbers
   * @return the arithmetic mean of the numbers
   */
  static double arithmeticMean(int... numbers) {
    int sum = 0;

    for (int number : numbers) {
      sum += number;
    }

    return (double) sum / numbers.length;
  }

  /**
   * Returns an array of random numbers.
   *
   * @param n the number of random numbers
   * @return an array of random numbers
   */
  static double[] getRandomNumbers(int n) {
    double[] numbers = new double[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = Math.random();
    }

    return numbers;
  }

  /**
   * Returns the text in uppercase.
   *
   * @param text the text
   * @return the text in uppercase
   */
  static String toUpperCase(char[] text) {
    for (char c : text) {
      if (c >= 'a' && c <= 'z') {
        c -= 32;
      }
    }

    return new String(text);
  }

  static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number: ");
    int number = scanner.nextInt();

    System.out.println(arithmeticMean(1, 2, 3, 4, 5));
    System.out.println(getRandomNumbers(number));
    System.out.println(toUpperCase(new char[] {'a', 'b', 'c'}));
  }
}
