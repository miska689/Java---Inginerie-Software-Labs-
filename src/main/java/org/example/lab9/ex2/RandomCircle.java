package org.example.lab9.ex2;

import com.googlecode.lanterna.graphics.Theme;

import java.util.Random;

class RandomNumber extends Thread {
  public int number;

  @Override
  public void run() {
    Random random = new Random();

    this.number = random.nextInt(30);
  }
}

class GenerateCircle extends Thread {
  public int radius;

  GenerateCircle(int radius) {
    this.radius = radius;
  }

  @Override
  public void run() {
    if (radius % 3 == 0) {
      System.out.println("Area of circle is " + 2 * Math.PI * radius * radius);
    } else {
      System.out.println("Radius must be exact divided by zero");
    }
  }
}

public class RandomCircle {
  public static void main(String[] args) {
    RandomNumber randomNumber = new RandomNumber();
    randomNumber.start();
    try {
      randomNumber.join();
    } catch (InterruptedException e) {
      e.getStackTrace();
    }

    Thread generateCircle = new GenerateCircle(randomNumber.number);
    generateCircle.start();
  }
}
