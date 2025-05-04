package org.example.lab8.ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormatSymbols;
import java.util.Objects;

public class DatePrinter {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      System.out.print("Enter your date of birth (dd MM yyyy, month as string!): ");

      while (!Objects.equals(line = reader.readLine(), "x") && !Objects.equals(line, "X")) {
        String[] dateParts = line.split(" ");

        int day = Integer.parseInt(dateParts[0]);

        int month = Integer.parseInt(dateParts[1]);

        int year = Integer.parseInt(dateParts[2]);

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
          System.out.println("Leap year");
        } else {
          System.out.println("Not a leap year");
        }

        String[] months = new DateFormatSymbols().getMonths();

        System.out.println("Your date of birth is: " + day + " " + months[month - 1] + " " + year);
        System.out.print("Enter your date of birth (dd MM yyyy, month as string!): ");
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
  }
}
