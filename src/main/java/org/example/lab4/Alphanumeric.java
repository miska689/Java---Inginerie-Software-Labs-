package org.example.lab4;

import java.util.Random;
import java.util.Scanner;

public class Alphanumeric {
  public char[] chars;

  public Alphanumeric(int nChars) {
    Random random = new Random();

    char[] alphanumeric =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    this.chars = new char[random.nextInt(1, nChars)];

    for (int i = 0; i < this.chars.length; i++) {
      this.chars[i] = alphanumeric[random.nextInt(alphanumeric.length)];
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number: ");
    int number = scanner.nextInt();

    Alphanumeric alphanumeric = new Alphanumeric(number);

    System.out.println(alphanumeric.chars);

    String text = new String(alphanumeric.chars);

    text = text.replaceAll("[0-9]", "*");

    System.out.println(text);
  }
}
