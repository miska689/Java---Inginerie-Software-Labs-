package org.example.lab6.ex1;

import java.util.Scanner;

public class ArrayExceptions {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[][] matrix = {
      {1, 2, 3, 1},
      {4, 5, 6},
      {7, 8, 9, 12, 23, 321}
    };

    System.out.println("Enter number of elements: ");
    int nElements = scanner.nextInt();

    int[] elements = new int[nElements];

    for (int i = 0; i < nElements; i++) {
      System.out.println("Enter element " + (i + 1) + ": ");
      elements[i] = scanner.nextInt();
    }

    System.out.println("Enter index: ");
    int index = scanner.nextInt();

    try {
      System.out.println("Element at index " + index + ": " + elements[index]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Array index out of bounds!");
    }
  }
}
