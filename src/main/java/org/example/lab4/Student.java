package org.example.lab4;

import java.util.Scanner;
import java.util.SimpleTimeZone;

import org.example.lab3.SortAlgorithm;

public class Student {
  private String name;
  private String phoneNumber;
  private double grade;

  private boolean validatePhoneNumber(String phoneNumber) {
    return phoneNumber != null
        && phoneNumber.replaceAll("[.\\-]", "").length() == 10 // If phone number is 10 digits
        && phoneNumber.replaceAll("[.\\-]", "").matches("\\d+"); // If phone number is numeric
  }

  public Student(String args) {
    String[] data = args.split("\\^\\^\\^"); // name^^^phoneNumber^^^grade

    if (data.length != 3) {
      throw new IllegalArgumentException("Invalid data");
    }

    this.name = data[0];

    if (!this.validatePhoneNumber(data[1])) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Invalid phone number");

      System.out.println("Enter phone number: ");
      this.phoneNumber = scanner.next();

      if (!this.validatePhoneNumber(this.phoneNumber)) {
        System.out.println("Invalid phone number");
        System.exit(1);
      }
    }

    this.phoneNumber = data[1];

    try {
      this.grade = Double.parseDouble(data[2]);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Invalid grade");
    }
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public double getGrade() {
    return grade;
  }

  public static void main(String[] args) {
    Student[] students = {
      new Student("John Doe^^^1234567890^^^8.5"),
      new Student("Jane Doe^^^1234567890^^^9.0"),
      new Student("Alice^^^123-123-1233^^^7.5"),
      new Student("Alice^^^1234567890^^^7.32"),
      new Student("Bob^^^1234567890^^^6.0"),
      new Student("Charlie^^^1234567890^^^5.5"),
      new Student("David^^^1234567890^^^4.0"),
    };

    // Sort by name
    SortAlgorithm.quickSort(
        students, 0, students.length - 1, (a, b) -> a.getName().compareTo(b.getName()) < 0);

    for (Student student : students) {
      System.out.println(student.getName() + " " + student.getGrade());
    }
    System.out.println();

    // Sort by grade
    SortAlgorithm.quickSort(
        students, 0, students.length - 1, (a, b) -> a.getGrade() > b.getGrade());

    for (Student student : students) {
      System.out.println(student.getName() + " " + student.getGrade());
    }
  }
}
