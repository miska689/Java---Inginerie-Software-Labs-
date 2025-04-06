package org.example.lab5.ex3;

public abstract class SpatialFigure {
  protected String name;

  public SpatialFigure(String name) {
    this.name = name;
  }

  public abstract double getArea();

  public abstract String toString();
}
