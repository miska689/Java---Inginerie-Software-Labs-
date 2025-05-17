package org.example.lab7.ex6;

import java.util.*;

public class Employee implements Comparable<Employee> {
  private String name;
  private int age;
  private int salary;

  public Employee(String name, int age, int salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public int compareTo(Employee o) {
    return this.name.compareTo(o.name);
  }

  @Override
  public String toString() {
    return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Employee> employees = new ArrayList<>();

    System.out.print("Enter the number of employees: ");
    int n = Integer.parseInt(scanner.nextLine());

    for (int i = 0; i < n; i++) {
      System.out.println("Employee " + (i + 1) + ":");
      System.out.print("Name: ");
      String name = scanner.nextLine();
      System.out.print("Age: ");
      int age = Integer.parseInt(scanner.nextLine());
      System.out.print("Salary: ");
      int salary = Integer.parseInt(scanner.nextLine());

      employees.add(new Employee(name, age, salary));
    }

    System.out.println("\nEmployees sorted by name:");
    Collections.sort(employees);
    for (Employee employee : employees) {
      System.out.println(employee);
    }

    System.out.println("\nEmployees sorted by age:");
    employees.sort((a, b) -> -Integer.compare(a.getAge(), b.getAge()));
    for (Employee employee : employees) {
      System.out.println(employee);
    }

    System.out.println("\nEmployees sorted by name and salary:");
    employees.sort(
        Comparator.comparing(Employee::getName)
            .thenComparing(Comparator.comparing(Employee::getSalary).reversed()));
    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}
