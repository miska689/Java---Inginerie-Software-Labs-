package org.example.lab5.ex4;

public class FractionExtra extends Fraction {
  public FractionExtra(int numerator, int denominator) {
    super(numerator, denominator);
  }

  public boolean superunitary() {
    return numerator > denominator;
  }

  @Override
  protected int cmmcd(int a, int b) {
    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }
    return a;
  }
}
