package org.example.lab7.ex5;

import java.util.*;

public class Student implements Comparable<Student> {
  private String name;
  private String group;
  private double grade;

  public Student(String name, String group, double grade) {
    this.name = name;
    this.group = group;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public String getGroup() {
    return group;
  }

  public double getGrade() {
    return grade;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  @Override
  public int compareTo(Student other) {
    int gradeCompare = Double.compare(other.grade, this.grade);
    if (gradeCompare != 0) return gradeCompare;
    return this.name.compareTo(other.name);
  }

  @Override
  public String toString() {
    return name + " | Group: " + group + " | Grade: " + grade;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    SortedSet<Student> students = new TreeSet<>();

    System.out.print("Number of students: ");
    int n = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < n; i++) {
      System.out.println("Student " + (i + 1) + ":");
      System.out.print("Name: ");
      String name = scanner.nextLine();
      System.out.print("Group: ");
      String group = scanner.nextLine();
      System.out.print("Grade: ");
      double grade = Double.parseDouble(scanner.nextLine());

      students.add(new Student(name, group, grade));
    }

    System.out.println("\nAll students (sorted):");
    for (Student s : students) {
      System.out.println(s);
    }

    System.out.println("\nStudents with grade >= 8:");
    for (Student s : students) {
      if (s.getGrade() >= 8) {
        System.out.println(s);
      }
    }

    System.out.print("\nEnter group to filter: ");
    String filterGroup = scanner.nextLine();

    System.out.println("Students from group " + filterGroup + ":");
    students.forEach(
        s -> {
          if (s.getGroup().equals(filterGroup)) {
            System.out.println(s);
          }
        });
  }
}
