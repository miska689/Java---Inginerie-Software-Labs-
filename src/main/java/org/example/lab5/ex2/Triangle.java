package org.example.lab5.ex2;

public class Triangle implements IGeometricForm {
  @Override
  public double getArea(int a) {
    return (Math.sqrt(3) / 4) * a * a;
  }

  @Override
  public double getPerimeter(int a) {
    return 3 * a;
  }
}
