package org.example.lab3;

@FunctionalInterface
public interface SortOperation<T> {
  boolean compare(T a, T b);
}
