package org.example.lab6.ex6;

/** Represents a color in the RGB color model. */
public class Color {
  public final int r, g, b; // Red, Green, and Blue components of the color

  /**
   * Constructs a Color instance with the specified RGB values.
   *
   * @param r the red component (0-255)
   * @param g the green component (0-255)
   * @param b the blue component (0-255)
   */
  public Color(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * Converts the RGB color to the HSV (Hue, Saturation, Value) color model.
   *
   * @return an array containing the HSV values: - [0]: Hue (0-360 degrees) - [1]: Saturation (0-1)
   *     - [2]: Value (0-1)
   */
  public float[] toHSV() {
    float rf = r / 255f;
    float gf = g / 255f;
    float bf = b / 255f;

    float max = Math.max(rf, Math.max(gf, bf));
    float min = Math.min(rf, Math.min(gf, bf));
    float delta = max - min;

    float h = 0;
    if (delta != 0) {
      if (max == rf) {
        h = 60 * (((gf - bf) / delta) % 6);
      } else if (max == gf) {
        h = 60 * (((bf - rf) / delta) + 2);
      } else {
        h = 60 * (((rf - gf) / delta) + 4);
      }
    }

    if (h < 0) h += 360;

    float s = max == 0 ? 0 : (delta / max);
    float v = max;

    return new float[] {h, s, v};
  }

  /**
   * Returns a string representation of the color in the RGB format.
   *
   * @return a string in the format "RGB(r, g, b)"
   */
  @Override
  public String toString() {
    return String.format("RGB(%d, %d, %d)", r, g, b);
  }
}
