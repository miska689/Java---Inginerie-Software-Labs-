package org.example.lab7.ex1;

public class Generic<T> {
  boolean isEqual(T a, T b) {
    return a.equals(b);
  }

  public static void main(String[] args) {
    Generic<String> stringGeneric = new Generic<>();
    Generic<Integer> integerGeneric = new Generic<>();

    System.out.println(stringGeneric.isEqual("Hello", "Hello"));
    System.out.println(integerGeneric.isEqual(1, 1));

    System.out.println(stringGeneric.isEqual("Hello", "World"));
    System.out.println(integerGeneric.isEqual(1, 2));
  }
}
