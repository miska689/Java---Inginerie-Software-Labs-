package org.example.lab5.ex4;

import java.util.Scanner;

public class Fraction {
  protected int numerator;
  protected int denominator;

  public Fraction() {}

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public void setDenominator(int denominator) {
    this.denominator = denominator;
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }
  }

  protected int cmmcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return cmmcd(b, a % b);
  }

  public void reduce() {
    int gcd = cmmcd(numerator, denominator); // Greatest Common Divisor
    numerator /= gcd;
    denominator /= gcd;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter n of fractions: ");
    int n = scanner.nextInt();

    Fraction[] fractions = new Fraction[n];

    for (int i = 0; i < n; i++) {
      System.out.print("Enter numerator and denominator for fraction " + (i + 1));
      System.out.print(" (numerator): ");
      int numerator = scanner.nextInt();
      System.out.print(" (denominator): ");
      int denominator = scanner.nextInt();
      fractions[i] = new Fraction(numerator, denominator);
    }

    for (Fraction fraction : fractions) {
      System.out.println("fraction: " + fraction);
    }
    System.out.println();

    System.out.println("Reducing fractions...");
    for (Fraction fraction : fractions) {
      fraction.reduce();
      System.out.println("Reduced fraction: " + fraction);
    }
    System.out.println();

    System.out.print("Enter numerator and denominator for the new fraction: ");
    System.out.print(" (numerator): ");
    int newNumerator = scanner.nextInt();
    System.out.print(" (denominator): ");
    int newDenominator = scanner.nextInt();

    FractionExtra newFraction = new FractionExtra(newNumerator, newDenominator);

    System.out.println("New fraction: " + newFraction);
    System.out.println("Is the new fraction superunitary? " + newFraction.superunitary());
    newFraction.reduce();
    System.out.println("Reduced new fraction: " + newFraction);
  }
}
