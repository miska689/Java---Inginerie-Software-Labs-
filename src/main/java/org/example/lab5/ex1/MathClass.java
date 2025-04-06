package org.example.lab5.ex1;

@FunctionalInterface
interface FIAdd {
  double add(double a, double b);
}

@FunctionalInterface
interface FISub {
  double sub(double a, double b);
}

@FunctionalInterface
interface FIMul {
  double mul(double a, double b);
}

@FunctionalInterface
interface FIDiv {
  double div(double a, double b);
}

public class MathClass implements FIAdd, FISub, FIMul, FIDiv {

  public MathClass() {}

  @Override
  public double add(double a, double b) {
    return a + b;
  }

  @Override
  public double sub(double a, double b) {
    return a - b;
  }

  @Override
  public double mul(double a, double b) {
    return a * b;
  }

  @Override
  public double div(double a, double b) {
    return a / b;
  }
}
