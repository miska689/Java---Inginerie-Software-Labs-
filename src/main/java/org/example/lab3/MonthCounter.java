package org.example.lab3;

import java.util.Arrays;
import java.util.Scanner;

public class MonthCounter {
  public static void getMonthNameOrIndex(String input) {
    String[] months = {
      "January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"
    };

    try {
      int monthNumber = Integer.parseInt(input);
      if (monthNumber < 1 || monthNumber > 12) {
        System.out.println("Invalid month number");
      } else {
        System.out.println(months[monthNumber - 1]);
      }
    } catch (NumberFormatException e) {
      boolean isMonth = Arrays.asList(months).contains(input);

      if (isMonth) {
        System.out.println(Arrays.asList(months).indexOf(input) + 1);
      } else {
        System.out.println("Invalid month name");
      }
    }
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Month or number: ");
    String input = scanner.nextLine();

    MonthCounter.getMonthNameOrIndex(input);
  }
}
