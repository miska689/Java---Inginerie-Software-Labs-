package org.example.lab9.ex1;

import static java.lang.Thread.sleep;

class Class1 implements Runnable {
  private String name;

  private static int nObjects = 0;

  Class1(String name) {
    this.name = name;
    nObjects++;
  }

  @Override
  public void run() {
    for (int i = 0; i < nObjects; i++) {
      System.out.println(name + " " + i);
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class ThreadsOperation {
  public static void main(String[] args) {
    Thread t1 = new Thread(new Class1("Thread 1"));
    Thread t2 = new Thread(new Class1("Thread 2"));
    Thread t3 = new Thread(new Class1("Thread 3"));

    t1.start();
    t2.start();
    t3.start();
  }
}
