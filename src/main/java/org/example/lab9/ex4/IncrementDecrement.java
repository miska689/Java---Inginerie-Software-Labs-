package org.example.lab9.ex4;

/**
 * Interface representing a counter with methods to increment, decrement, and retrieve its value.
 */
interface Counter {
  /**
   * Increments the counter value.
   */
  void increment();

  /**
   * Decrements the counter value.
   */
  void decrement();

  /**
   * Retrieves the current value of the counter.
   *
   * @return the current value of the counter
   */
  int getValue();
}

/**
 * A thread-safe implementation of the Counter interface using synchronized methods.
 */
class SharedResource implements Counter {
  private int value = 0;

  /**
   * Increments the counter value in a thread-safe manner.
   */
  @Override
  public synchronized void increment() {
    value++;
  }

  /**
   * Decrements the counter value in a thread-safe manner.
   */
  @Override
  public synchronized void decrement() {
    value--;
  }

  /**
   * Retrieves the current value of the counter in a thread-safe manner.
   *
   * @return the current value of the counter
   */
  @Override
  public synchronized int getValue() {
    return value;
  }
}

/**
 * A non-thread-safe implementation of the Counter interface.
 */
class SharedResourceUnsafe implements Counter {
  private int value = 0;

  /**
   * Increments the counter value without thread safety.
   */
  @Override
  public void increment() {
    value++;
  }

  /**
   * Decrements the counter value without thread safety.
   */
  @Override
  public void decrement() {
    value--;
  }

  /**
   * Retrieves the current value of the counter without thread safety.
   *
   * @return the current value of the counter
   */
  @Override
  public int getValue() {
    return value;
  }
}

/**
 * A worker class that performs increment and decrement operations on a Counter instance.
 */
class Worker implements Runnable {
  private final Counter counter;
  private final int iterations;

  /**
   * Constructs a Worker instance.
   *
   * @param counter    the Counter instance to operate on
   * @param iterations the number of increment and decrement operations to perform
   */
  public Worker(Counter counter, int iterations) {
    this.counter = counter;
    this.iterations = iterations;
  }

  /**
   * Executes the increment and decrement operations on the Counter instance.
   */
  @Override
  public void run() {
    for (int i = 0; i < iterations; i++) {
      counter.increment();
      counter.decrement();
    }
  }
}

/**
 * Main class to test the behavior of synchronized and unsynchronized Counter implementations.
 */
public class IncrementDecrement {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Synchronized");
    Counter sync = new SharedResource();
    runTest(sync);

    System.out.println();
    System.out.println("Unsynchronized");
    Counter unsync = new SharedResourceUnsafe();
    runTest(unsync);
  }

  /**
   * Runs a test with multiple threads performing operations on a Counter instance.
   *
   * @param counter the Counter instance to test
   * @throws InterruptedException if thread execution is interrupted
   */
  private static void runTest(Counter counter) throws InterruptedException {
    Thread t1 = new Thread(new Worker(counter, 100000));
    Thread t2 = new Thread(new Worker(counter, 100000));
    Thread t3 = new Thread(new Worker(counter, 100000));
    t1.start();
    t2.start();
    t3.start();
    t1.join();
    t2.join();
    t3.join();
    System.out.printf("Final: %d", counter.getValue());
  }
}