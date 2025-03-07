package org.example.lab3;

import java.util.Random;
import java.util.Scanner;

public class Cryptography {
  /**
   * Validate data
   *
   * @param data Data to validate
   * @param key Key
   * @param keyNumber Key number
   * @return True if data is valid, false otherwise
   */
  public static boolean validateData(String data, String key, int[] keyNumber) {
    int sum = 0;

    for (int i = 0; i < data.length(); i++) {
      for (int j = 0; j < key.length(); j++) {
        if (data.charAt(i) == key.charAt(j)) {
          sum += keyNumber[j] + i + 1;
        }
      }
    }

    return sum > 100;
  }

  /**
   * Generate key number
   *
   * @param key Key
   * @return Key number
   */
  public static int[] generateKeyNumber(String key) {
    Random random = new Random();

    key = Cryptography.removeDuplicateLetters(key);

    int[] keyNumber = new int[key.length()];

    for (int i = 0; i < key.length(); i++) {
      keyNumber[i] = random.nextInt(100);
    }

    return keyNumber;
  }

  /**
   * Remove duplicate letters
   *
   * @param str String
   * @return String without duplicate letters
   */
  public static String removeDuplicateLetters(String str) {
    return str.chars()
        .sorted()
        .distinct()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter data: ");
    String data = scanner.nextLine();

    String key = "hld";
    int[] keyNumber = Cryptography.generateKeyNumber(key);

    if (Cryptography.validateData(data, key, keyNumber)) {
      System.out.println("Data is valid");
    } else {
      System.out.println("Data is not valid");
    }
  }
}
