package org.example.lab5.ex3;

public class Cube extends SpatialFigure {
  private int side;

  public Cube(int side) {
    super("Cube");
    this.side = side;
  }

  @Override
  public double getArea() {
    return 6 * side * side;
  }

  @Override
  public String toString() {
    return "Cube{" + "side=" + side + ", area=" + getArea() + '}';
  }
}
