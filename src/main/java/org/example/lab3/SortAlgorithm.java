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

  public static <T> int partition(T[] arr, int low, int high, SortOperation<T> sortOperation) {
    T pivot = arr[high];

    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (sortOperation.compare(arr[j], pivot)) {
        i++;
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    T temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  public static <T> void quickSort(T[] arr, int low, int high, SortOperation<T> sortOperation) {
    if (low < high) {
      int pivot = SortAlgorithm.partition(arr, low, high, sortOperation);

      quickSort(arr, low, pivot - 1, sortOperation);
      quickSort(arr, pivot + 1, high, sortOperation);
    }
  }

  public static void main() {
    Integer[] array = {3, 60, 35, 2, 45, 320, 5};

    //    SortAlgorithm.bubbleSort(array, (a, b) -> a > b);
    SortAlgorithm.quickSort(array, 0, array.length - 1, (a, b) -> a <= b);

    for (int n : array) {
      System.out.print(n + " ");
    }
  }
}
