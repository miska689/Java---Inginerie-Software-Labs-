package org.example.lab4;

public class Matrix {
  private int[][] matrix;
  private int rows;
  private int columns;

  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.matrix = new int[rows][columns];
  }

  public Matrix(int[][] matrix) {
    this.matrix = matrix;
  }

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public int getElement(int row, int column) {
    return matrix[row][column];
  }

  public void setElement(int row, int column, int value) {
    matrix[row][column] = value;
  }

  /**
   * Returns an array of numbers that are close to the given number.
   *
   * @param number the number to compare
   * @return an array of numbers that are close to the given number
   */
  public int[] getAppropriateNumber(int number) {
    int[] result = new int[9];
    int index = 0;

    for (int[] row : matrix) {
      for (int element : row) {
        if (element < number + number * 0.05 && element > number - number * 0.05) {
          result[index] = element;
          index++;
        }
      }
    }

    return result;
  }

  /**
   * Prints the matrix.
   */
  public void print() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Matrix matrix = new Matrix(3, 3);

    matrix.setElement(0, 0, 1);
    matrix.setElement(0, 1, 2);
    matrix.setElement(0, 2, 3);
    matrix.setElement(1, 0, 4);
    matrix.setElement(1, 1, 5);
    matrix.setElement(1, 2, 6);
    matrix.setElement(2, 0, 7);
    matrix.setElement(2, 1, 8);
    matrix.setElement(2, 2, 9);

    matrix.print();

    int[] result = matrix.getAppropriateNumber(5);

    for (int element : result) {
      System.out.print(element + " ");
    }
  }
}
