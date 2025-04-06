package org.example.lab5.ex7;

public class Vehicle {
  private int maxPassengers;
  private String color;
  private int maxSpeed;

  public Vehicle(int maxPassengers, String color, int maxSpeed) {
    this.maxPassengers = maxPassengers;
    this.color = color;
    this.maxSpeed = maxSpeed;
  }

  // Getters and setters
  public int getMaxPassengers() {
    return maxPassengers;
  }

  public void setMaxPassengers(int maxPassengers) {
    this.maxPassengers = maxPassengers;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }
}
