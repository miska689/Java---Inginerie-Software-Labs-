package org.example.lab4;

import java.util.ArrayList;

public class Circle {
  private int colorRGBA; // 0xRRGGBBAA
  private int radius;
  private int[] position; // [x, y]

  public Circle(int colorRGBA, int radius, int[] position) {
    this.colorRGBA = colorRGBA;
    this.radius = radius;
    this.position = position;
  }

  public int getColorRGBA() {
    return colorRGBA;
  }

  public void setColorRGBA(int colorRGBA) {
    this.colorRGBA = colorRGBA;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public int[] getPosition() {
    return position;
  }

  public void setPosition(int[] position) {
    this.position = position;
  }

  public void setX(int x) {
    this.position[0] = x;
  }

  public void setY(int y) {
    this.position[1] = y;
  }

  public int getX() {
    return this.position[0];
  }

  public int getY() {
    return this.position[1];
  }

  /**
   * Returns the circles from the given quadrant.
   *
   * @param circles the circles
   * @param quadrant the quadrant
   * @param includeFullSize include the full size of the circle
   * @return the circles from the given quadrant
   */
  public static ArrayList<Circle> getCirclesFromQuadrant(
      Circle[] circles, int quadrant, boolean includeFullSize) {
    ArrayList<Circle> result = new ArrayList<>();

    int x, y;

    for (Circle circle : circles) {
      x = includeFullSize ? circle.getX() - circle.getRadius() : circle.getX();
      y = includeFullSize ? circle.getY() - circle.getRadius() : circle.getY();

      switch (quadrant) {
        case 1:
          if (x > 0 && y > 0) {
            result.add(circle);
          }
          break;
        case 2:
          if (x < 0 && y > 0) {
            result.add(circle);
          }
          break;
        case 3:
          if (x < 0 && y < 0) {
            result.add(circle);
          }
          break;
        case 4:
          if (x > 0 && y < 0) {
            result.add(circle);
          }
          break;
        default:
          break;
      }
    }

    return result;
  }

  /**
   * Returns the circles from the given vertical or horizontal line.
   *
   * @param circles the circles
   * @param line the line
   * @param isVertical true if the line is vertical, false if the line is horizontal
   * @return the circles from the given vertical or horizontal line
   */
  public static ArrayList<Circle> getCircleFromVerticalOrVertical(
      Circle[] circles, int line, boolean isVertical) {
    ArrayList<Circle> result = new ArrayList<>();

    for (Circle circle : circles) {
      if (isVertical) {
        if (circle.getX() == line) {
          result.add(circle);
        }
      } else {
        if (circle.getY() == line) {
          result.add(circle);
        }
      }
    }

    return result;
  }

  /**
   * Returns the circles from the given color interval.
   *
   * @param circles the circles
   * @param color1 the first color
   * @param color2 the second color
   * @return the circles from the given color interval
   */
  public static ArrayList<Circle> getCirclesFromColorInterval(
      Circle[] circles, int color1, int color2) {
    ArrayList<Circle> result = new ArrayList<>();

    if (color1 > color2) {
      color1 = color1 ^ color2;
      color2 = color1 ^ color2;
      color1 = color1 ^ color2;
    }

    for (Circle circle : circles) {
      if (circle.getColorRGBA() >= color1 && circle.getColorRGBA() <= color2) {
        result.add(circle);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Circle[] circles = new Circle[4];
    circles[0] = new Circle(0x000000FF, 1, new int[] {2, 2});
    circles[1] = new Circle(0x0000FFFF, 1, new int[] {-1, 1});
    circles[2] = new Circle(0x00FFFFFF, 1, new int[] {1, -1});
    circles[3] = new Circle(0x00000000, 1, new int[] {-1, -1});

    ArrayList<Circle> circlesFromQuadrant = Circle.getCirclesFromQuadrant(circles, 1, false);
    ArrayList<Circle> fullCircleFromQuadrant = Circle.getCirclesFromQuadrant(circles, 1, true);
    ArrayList<Circle> circlesFromVertical =
        Circle.getCircleFromVerticalOrVertical(circles, 1, true);
    ArrayList<Circle> circlesFromHorizontal =
        Circle.getCircleFromVerticalOrVertical(circles, 1, false);
    ArrayList<Circle> circlesFromColorInterval =
        Circle.getCirclesFromColorInterval(circles, 0x000000FF, 0x00FFFFFF);

    System.out.println(circlesFromQuadrant);
    System.out.println(fullCircleFromQuadrant);
    System.out.println(circlesFromVertical);
    System.out.println(circlesFromHorizontal);
    System.out.println(circlesFromColorInterval);
  }
}
