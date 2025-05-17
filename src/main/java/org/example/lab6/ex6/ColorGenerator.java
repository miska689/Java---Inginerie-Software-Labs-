package org.example.lab6.ex6;

import java.util.Random;

public class ColorGenerator {
  private static final int MAX_ATTEMPTS = 10;

  /**
   * Generates a random RGB color with a saturation of 90% or less.
   *
   * @return a Color object with RGB values
   * @throws SaturatedException if unable to generate a valid color after 10 attempts
   */
  public static Color generateUnsaturatedColor() throws SaturatedException {
    Random rand = new Random();
    int attempts = 0;

    while (attempts < MAX_ATTEMPTS) {
      Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

      float[] hsv = color.toHSV();
      float saturation = hsv[1] * 100;

      assert saturation <= 90 : "Saturation exceeded 90: " + saturation;

      if (saturation <= 90) {
        return new Color(color.r, color.g, color.b);
      }

      attempts++;
    }

    throw new SaturatedException("Failed to generate an unsaturated color after 10 attempts.");
  }

  public static void main(String[] args) {
    try {
      Color color = generateUnsaturatedColor();
      System.out.println("Valid RGB color: " + color);
    } catch (SaturatedException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}
