package org.example.lab6.ex7;

import org.example.lab6.ex7.imageProcessor.Image;

public class TestImage {
  public static void main(String[] args) {
    Image img = new Image(5, 5);

    img.initializeRandomPixels();

    System.out.println("Original Image:");
    img.printImage();

    long t1 = img.removePixels(50, 50, 50);
    System.out.println("\nAfter Removing Pixels Under Threshold:");
    img.printImage();
    System.out.println("Time: " + t1 / 1_000_000.0 + " ms");

    long t2 = img.removeColorComponent("G");
    System.out.println("\nAfter Removing Green Component:");
    img.printImage();
    System.out.println("Time: " + t2 / 1_000_000.0 + " ms");

    long t3 = img.toGrayscale();
    System.out.println("\nAfter Grayscale Transformation:");
    img.printImage();
    System.out.println("Time: " + t3 / 1_000_000.0 + " ms");
  }
}
