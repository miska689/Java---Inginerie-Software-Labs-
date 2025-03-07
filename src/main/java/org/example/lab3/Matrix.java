package org.example.lab3;

import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {
  /**
   * Prints the given matrix in both row-wise and column-wise order.
   *
   * @param matrix the matrix to be printed, represented as an ArrayList of Integer arrays
   */
  public static void printMatrix(ArrayList<Integer[]> matrix) {
    System.out.println("Rows:");
    for (Integer[] row : matrix) {
      for (Integer i : row) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
    System.out.println();

    System.out.println("Columns:");
    for (int i = 0; i < matrix.size(); i++) {
      for (int j = 0; j < matrix.size() - i; j++) {
        System.out.print(matrix.get(matrix.size() - j - 1)[i] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Eliminates the elements in the given matrix that are not in the given range.
   *
   * @param matrix the matrix to be modified, represented as an ArrayList of Integer arrays
   * @param min the minimum value of the range
   * @param max the maximum value of the range
   */
  public static void eliminateElements(ArrayList<Integer[]> matrix, int min, int max) {
    if (min >= max) {
      System.out.println("Invalid range.");
      return;
    }

    for (int i = 0; i < matrix.size(); i++) {
      for (int j = 0; j < matrix.size() - i; j++) {
        if (matrix.get(matrix.size() - j - 1)[i] < min
            || matrix.get(matrix.size() - j - 1)[i] > max) {
          matrix.get(matrix.size() - j - 1)[i] = 0;
        }
      }
    }
  }

  /**
   * Prints the neighbors of the element at the given position in the given matrix.
   *
   * @param matrix the matrix to be printed, represented as an ArrayList of Integer arrays
   * @param row the row of the element
   * @param col the column of the element
   */
  public static void printNeighbor(ArrayList<Integer[]> matrix, int row, int col) {
    int matrixSize = matrix.size();

    if (row >= matrixSize || row < 0 || col >= matrix.get(row).length || col < 0) {
      System.out.println("Invalid position.");
      return;
    }

    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i >= matrixSize
            || i < 0
            || j >= matrix.get(i).length
            || j < 0
            || (j == col && i == row)) {
          continue;
        }

        System.out.print(matrix.get(i)[j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Generates a random array of the given length.
   *
   * @param length the length of the array
   * @return the generated array
   */
  public static Integer[] generateRandomArray(int length) {
    Integer[] randomArray = new Integer[length];

    for (int i = 0; i < length; i++) {
      randomArray[i] = (int) (Math.random() * 100);
    }

    return randomArray;
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Integer[]> matrix = new ArrayList<>();

    System.out.println("Enter the size of the matrix: ");
    int rows = scanner.nextInt();

    for (int i = 0; i < rows; i++) {
      matrix.add(Matrix.generateRandomArray(i + 1));
    }

    printMatrix(matrix);
    printNeighbor(matrix, 3, 1);
    eliminateElements(matrix, 20, 50);
    printMatrix(matrix);
  }
}
