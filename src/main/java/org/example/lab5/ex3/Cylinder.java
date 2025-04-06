package org.example.lab5.ex3;

public class Cylinder extends SpatialFigure {
  private final int radius;
  private final int height;

  public Cylinder(int radius, int height) {
    super("Cylinder");
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double getArea() {
    return 2 * Math.PI * radius * (radius + height);
  }

  @Override
  public String toString() {
    return "Cylinder{" + "radius=" + radius + ", height=" + height + ", area=" + getArea() + '}';
  }
}
