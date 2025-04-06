package org.example.lab5.ex3;

public class Dyeing implements IPaint {
  private final SpatialFigure figure;

  public Dyeing(SpatialFigure figure) {
    this.figure = figure;
  }

  public double getPaintCost() {
    return this.figure.getArea() * paintPerUnitOfArea;
  }

  public static void main(String[] args) {
    Dyeing dyeingCube = new Dyeing(new Cube(3));
    Dyeing dyeingSphere = new Dyeing(new Sphere(4));
    Dyeing dyeingCylinder = new Dyeing(new Cylinder(3, 4));

    System.out.println("Paint cost for sphere: " + dyeingSphere.getPaintCost());
    System.out.println("Paint cost for cube: " + dyeingCube.getPaintCost());
    System.out.println("Paint cost for cylinder: " + dyeingCylinder.getPaintCost());
  }
}
