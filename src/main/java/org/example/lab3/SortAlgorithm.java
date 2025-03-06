package org.example.lab3;

@FunctionalInterface
interface SortOperation<T> {
  boolean compare(T a, T b);
}

public class SortAlgorithm {
  public static <T> void bubbleSort(T[] array, SortOperation<T> sortOperation) {
    int n = array.length;
    T temp;

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < (n - i); j++) {
        if (sortOperation.compare(array[j - 1], array[j])) {
          temp = array[j - 1];
          array[j - 1] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void main() {
    Integer[] array = {3, 60, 35, 2, 45, 320, 5};

    SortAlgorithm.bubbleSort(array, (a, b) -> a > b);

    for (int n : array) {
      System.out.print(n + " ");
    }
  }
}
