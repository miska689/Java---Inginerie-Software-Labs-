package org.example.lab6.ex3;

public class Class2 extends Class1 implements Int1, Int2 {
  public Class2(double number1, double number2) {
    super(number1, number2);
  }

  @Override
  public String toString() {
    return "Class2{" + "number3=" + number3 + ", number4=" + number4 + '}';
  }

  @Override
  public double product(double number1, double number2) {
    return number1 * number2;
  }

  @Override
  public int sum(int a, int b) {
    return a + b;
  }
}
