package org.example.lab5.ex2;

public class Square implements IGeometricForm {
  @Override
  public double getArea(int a) {
    return a * a;
  }

  @Override
  public double getPerimeter(int a) {
    return 4 * a;
  }
}
