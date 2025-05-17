package org.example.lab6.ex7.imageProcessor;

import java.util.Random;

public class Image {
  private final int height, width;
  private final Pixel[][] pixels;

  /**
   * Constructor to create an Image object with specified dimensions.
   *
   * @param height Number of rows (height)
   * @param width Number of columns (width)
   */
  public Image(int height, int width) {
    this.height = height;
    this.width = width;
    this.pixels = new Pixel[height][width];
  }

  /** Initializes the image with random pixel values. */
  public void initializeRandomPixels() {
    Random rand = new Random();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        pixels[i][j] = new Pixel(r, g, b);
      }
    }
  }

  /**
   * Initializes the image with a specific color.
   *
   * @param minR Minimum red value (0-255)
   * @param minG Minimum green value (0-255)
   * @param minB Minimum blue value (0-255)
   */
  public long removePixels(int minR, int minG, int minB) {
    long start = System.nanoTime();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        Pixel p = pixels[i][j];
        if (p.r < minR || p.g < minG || p.b < minB) {
          pixels[i][j] = new Pixel(0, 0, 0);
        }
      }
    }
    return System.nanoTime() - start;
  }

  /**
   * Initializes the image with a specific color.
   *
   * @param component The color component to remove ("R", "G", or "B")
   */
  public long removeColorComponent(String component) {
    long start = System.nanoTime();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pixels[i][j].removeComponent(component);
      }
    }
    return System.nanoTime() - start;
  }

  /** Converts the image to grayscale using the luminosity method. */
  public long toGrayscale() {
    long start = System.nanoTime();
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        pixels[i][j].toGrayscale();
      }
    }
    return System.nanoTime() - start;
  }

  public void printImage() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(pixels[i][j] + " ");
      }
      System.out.println();
    }
  }
}
