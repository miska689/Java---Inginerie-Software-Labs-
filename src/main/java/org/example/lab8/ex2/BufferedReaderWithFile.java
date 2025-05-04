package org.example.lab8.ex2;

import java.io.*;

public class BufferedReaderWithFile {
  public static void main(String[] args) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader(System.getProperty("user.dir") + "/1text.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] dateParts = line.split(" ");

        int day = Integer.parseInt(dateParts[0]);

        String month = dateParts[1];

        int year = Integer.parseInt(dateParts[2]);

        System.out.println("Your date of birth is: " + day + " " + month + " " + year);
      }

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
