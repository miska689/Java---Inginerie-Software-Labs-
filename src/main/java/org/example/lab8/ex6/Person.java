package org.example.lab8.ex6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Person {
  public String firstname;
  public String surname;
  public String phoneNumber;
  public String dateOfBirth;
  public String facebook;

  public Person(String person) {
    String[] parts = person.split("/");

    this.firstname = parts[0];
    this.surname = parts[1];
    this.phoneNumber = parts[2];
    this.dateOfBirth = parts[3];
    this.facebook = parts[4];
  }

  @Override
  public String toString() {
    return String.join("/", firstname, surname, phoneNumber, dateOfBirth, facebook);
  }

  public static void writeToFile(String filename, List<Person> personList) {
    try (BufferedWriter write = new BufferedWriter(new FileWriter(filename))) {
      for (Person person : personList) {
        write.write(person.toString());
        write.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }

  public static void main(String[] args) throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("input.csv"));
    List<Person> validFirstNames = new ArrayList<>();
    List<Person> validPhoneNumber = new ArrayList<>();
    List<Person> validDateOfBirth = new ArrayList<>();
    List<Person> validFacebook = new ArrayList<>();

    for (String line : lines) {
      Person person = new Person(line);

      if (person.firstname.equals("Andrei") || person.firstname.equals("Nicolae")) {
        validFirstNames.add(person);
      }
      if (person.phoneNumber.startsWith("+40")) {
        validPhoneNumber.add(person);
      }
      if (person.dateOfBirth.matches("\\d{2}-12-\\d{4}")) {
        validDateOfBirth.add(person);
      }
      if (person.facebook.matches(".*facebook\\.com\\\\profile.*\\?id=\\d+")) {
        validFacebook.add(person);
      }
    }

    writeToFile("output1.csv", validFirstNames);
    writeToFile("output2.csv", validPhoneNumber);
    writeToFile("output3.csv", validDateOfBirth);
    writeToFile("output4.csv", validFacebook);
    System.out.println("Data written to output files successfully.");
  }
}
