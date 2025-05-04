package org.example.lab8.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReaderTest {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String dateOfBirth;

      System.out.print("Enter your date of birth (dd MM yyyy, month as string!): ");

      dateOfBirth = reader.readLine();

      String[] dateParts = dateOfBirth.split(" ");

      int day = Integer.parseInt(dateParts[0]);

      String month = dateParts[1];

      int year = Integer.parseInt(dateParts[2]);

      System.out.println("Your date of birth is: " + day + " " + month + " " + year);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
