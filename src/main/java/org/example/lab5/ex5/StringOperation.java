package org.example.lab5.ex5;

import org.example.lab3.SortAlgorithm; // lab3 | SortAlgorithm.java
import org.example.lab3.SortOperation; // lab3 | SortAlgorithm.java

public class StringOperation {
  public static void main(String[] args) {
    String[] strings = {"Mpple", "banana", "Miwi", "grape", "orange"};

    SortOperation<String> stringSortOperation =
        (a, b) -> a.length() > b.length(); // sort by length (longest first)
    SortOperation<String> stringSortOperation2 =
        (a, b) -> a.length() < b.length(); // sort by length (shortest first)
    SortOperation<String> stringSortOperation3 =
        (a, b) ->
            a.toLowerCase().compareTo(b.toLowerCase()) < 0; // sort by alphabetical order (A-Z)
    SortOperation<String> stringSortOperation4 =
        (a, b) -> a.charAt(0) == 'M' && b.charAt(0) != 'M'; // sort by alphabetical order m

    SortAlgorithm.quickSort(strings, 0, strings.length - 1, stringSortOperation);
    System.out.println("Sorted by length (longest first):");
    for (String str : strings) {
      System.out.print(str + " ");
    }
    System.out.println();

    SortAlgorithm.quickSort(strings, 0, strings.length - 1, stringSortOperation2);
    System.out.println("Sorted by length (shortest first):");
    for (String str : strings) {
      System.out.print(str + " ");
    }
    System.out.println();

    SortAlgorithm.quickSort(strings, 0, strings.length - 1, stringSortOperation3);
    System.out.println("Sorted by alphabetical order (A-Z):");
    for (String str : strings) {
      System.out.print(str + " ");
    }
    System.out.println();

    SortAlgorithm.quickSort(strings, 0, strings.length - 1, stringSortOperation4);
    System.out.println("Sorted by alphabetical order m:");
    for (String str : strings) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}
