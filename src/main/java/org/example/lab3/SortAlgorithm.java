package org.example.lab3;

import org.example.lab4.Student;

import java.util.Scanner;

public class SortAlgorithm {
  /**
   * Sorts the given array using the bubble sort algorithm.
   *
   * @param <T> the type of elements in the array
   * @param array the array to be sorted
   * @param sortOperation the comparison operation defining the sort order
   */
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

  /**
   * Partitions the given array for the quicksort algorithm.
   *
   * @param <T> the type of elements in the array
   * @param arr the array to be partitioned
   * @param low the starting index of the partition
   * @param high the ending index of the partition
   * @param sortOperation the comparison operation defining the sort order
   * @return the index of the pivot element after partition
   */
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

  /**
   * Sorts the given array using the quicksort algorithm.
   *
   * @param arr array to be sorted
   * @param low index of the first element
   * @param high index of the last element
   * @param sortOperation comparison operation defining the sort order
   * @param <T> type of elements in the array
   */
  public static <T> void quickSort(T[] arr, int low, int high, SortOperation<T> sortOperation) {
    if (low < high) {
      int pivot = SortAlgorithm.partition(arr, low, high, sortOperation);

      quickSort(arr, low, pivot - 1, sortOperation);
      quickSort(arr, pivot + 1, high, sortOperation);
    }
  }

  public static void main() {
    Scanner scanner = new Scanner(System.in);

    Integer[] array = new Integer[10];

    for (int i = 0; i < 10; i++) {
      System.out.println("Enter number " + i + ": ");
      array[i] = scanner.nextInt();
    }

    Integer[] array2 = array.clone();

    System.out.println("Sorting using bubble sort:");
    SortAlgorithm.bubbleSort(array, (a, b) -> a > b);
    for (int n : array) {
      System.out.print(n + " ");
    }
    System.out.println();

    System.out.println("Sorting using quick sort:");
    SortAlgorithm.quickSort(array2, 0, array.length - 1, (a, b) -> a > b);
    for (int n : array) {
      System.out.print(n + " ");
    }
  }
}
