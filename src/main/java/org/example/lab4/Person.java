package org.example.lab4;

import java.util.Scanner;

public class Person {
  private String name;
  private double latitude;
  private double longitude;

  public Person() {
    this.name = null;
    this.latitude = 0.0;
    this.longitude = 0.0;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter number of persons: ");
    int nPerson = scanner.nextInt();

    Person[] persons = new Person[nPerson];

    for (int i = 0; i < nPerson; i++) {
      persons[i] = new Person();

      System.out.println("Enter name of person " + (i + 1) + ": ");
      persons[i].setName(scanner.next());

      System.out.println("Enter latitude of person " + (i + 1) + ": ");
      persons[i].setLatitude(scanner.nextDouble());

      System.out.println("Enter longitude of person " + (i + 1) + ": ");
      persons[i].setLongitude(scanner.nextDouble());
    }

    for (int i = 0; i < nPerson; i++) {
      System.out.println(
          "Person "
              + (i + 1)
              + ": "
              + persons[i].getName()
              + " ("
              + persons[i].getLatitude()
              + ", "
              + persons[i].getLongitude()
              + ")");
    }
  }
}
