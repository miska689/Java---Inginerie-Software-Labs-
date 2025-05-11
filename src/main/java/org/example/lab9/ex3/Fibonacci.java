package org.example.lab9.ex3;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class to demonstrate the calculation and display of the Fibonacci sequence using threads.
 */
public class Fibonacci {
  public static void main(String[] args) {
    int n = 10;
    SharedFib shared = new SharedFib(n);

    Thread calculator = new Thread(new FibCalculator(shared));
    Thread displayer = new Thread(new FibDisplayer(shared));

    displayer.start();
    calculator.start();
  }
}

/**
 * Shared resource for managing the Fibonacci sequence.
 */
class SharedFib {
  public final List<Long> fibList = new ArrayList<>();
  public final int target;
  public boolean done = false;

  /**
   * Constructs a SharedFib instance with the specified target number of Fibonacci numbers.
   *
   * @param n the number of Fibonacci numbers to calculate
   */
  SharedFib(int n) {
    this.target = n;
  }

  /**
   * Adds a Fibonacci number to the list and notifies waiting threads.
   *
   * @param value the Fibonacci number to add
   */
  public synchronized void addValue(long value) {
    fibList.add(value);
    notifyAll();
    if (fibList.size() == target) {
      done = true;
      notifyAll();
    }
  }

  /**
   * Retrieves a Fibonacci number at the specified index.
   *
   * @param index the index of the Fibonacci number to retrieve
   * @return the Fibonacci number at the specified index
   */
  public synchronized long getValue(int index) {
    return fibList.get(index);
  }

  /**
   * Gets the current size of the Fibonacci list.
   *
   * @return the size of the Fibonacci list
   */
  public synchronized int size() {
    return fibList.size();
  }

  /**
   * Checks if the calculation of the Fibonacci sequence is complete.
   *
   * @return true if the calculation is complete, false otherwise
   */
  public synchronized boolean isDone() {
    return done;
  }
}

/**
 * Runnable class responsible for calculating the Fibonacci sequence.
 */
class FibCalculator implements Runnable {
  private final SharedFib shared;

  /**
   * Constructs a FibCalculator instance with the specified shared resource.
   *
   * @param shared the shared resource for storing Fibonacci numbers
   */
  FibCalculator(SharedFib shared) {
    this.shared = shared;
  }

  /**
   * Calculates the Fibonacci sequence and stores the results in the shared resource.
   */
  @Override
  public void run() {
    for (int i = 0; i < shared.target; i++) {
      long value = i < 2 ? i : shared.getValue(i - 1) + shared.getValue(i - 2);
      shared.addValue(value);
    }
  }
}

/**
 * Runnable class responsible for displaying the Fibonacci sequence.
 */
class FibDisplayer implements Runnable {
  private final SharedFib shared;

  /**
   * Constructs a FibDisplayer instance with the specified shared resource.
   *
   * @param shared the shared resource for retrieving Fibonacci numbers
   */
  FibDisplayer(SharedFib shared) {
    this.shared = shared;
  }

  /**
   * Displays the Fibonacci sequence as it is calculated.
   */
  @Override
  public void run() {
    int printed = 0;
    while (true) {
      synchronized (shared) {
        while (shared.size() == printed && !shared.isDone()) {
          try {
            shared.wait();
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
          }
        }
        while (printed < shared.size()) {
          System.out.printf("Fib[%d] = %d%n", printed, shared.getValue(printed));
          printed++;
        }
        if (shared.isDone() && printed == shared.size()) {
          return;
        }
      }
    }
  }
}