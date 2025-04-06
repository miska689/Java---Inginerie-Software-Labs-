package org.example.lab5.ex3;

public class Sphere extends SpatialFigure {
  private int radius;

  public Sphere(int radius) {
    super("Sphere");
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return 4 * Math.PI * radius * radius;
  }

  @Override
  public String toString() {
    return "Sphere{" + "radius=" + radius + ", area=" + getArea() + '}';
  }
}
