package org.example.lab5;

public class Hexagon implements IGeometricForm {
  @Override
  public double getArea(int a) {
    return Math.PI * a * a;
  }

  @Override
  public double getPerimeter(int a) {
    return 2 * Math.PI * a;
  }
}
