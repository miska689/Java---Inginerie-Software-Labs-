package org.example.lab6.ex7.imageProcessor;

public class Pixel {
  public int r, g, b;

  /**
   * Constructor to create a Pixel object with RGB values.
   *
   * @param r Red component (0-255)
   * @param g Green component (0-255)
   * @param b Blue component (0-255)
   */
  public Pixel(int r, int g, int b) {
    this.r = Math.max(0, Math.min(255, r));
    this.g = Math.max(0, Math.min(255, g));
    this.b = Math.max(0, Math.min(255, b));
  }

  /**
   * Removes the specified color component from the pixel.
   *
   * @param component The color component to remove ("R", "G", or "B")
   */
  public void removeComponent(String component) {
    switch (component.toUpperCase()) {
      case "R" -> this.r = 0;
      case "G" -> this.g = 0;
      case "B" -> this.b = 0;
    }
  }

  /** Converts the pixel to grayscale using the luminosity method. */
  public void toGrayscale() {
    int gray = (int) (0.21 * r + 0.71 * g + 0.07 * b);
    this.r = gray;
    this.g = gray;
    this.b = gray;
  }

  @Override
  public String toString() {
    return "(" + r + "," + g + "," + b + ")";
  }
}
