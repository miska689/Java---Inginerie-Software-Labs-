package org.example.lab5.ex7;

public class MotorizedVehicle extends Vehicle {
  private GeoLoc location;

  public MotorizedVehicle(int maxPassengers, String color, int maxSpeed, GeoLoc location) {
    super(maxPassengers, color, maxSpeed);
    this.location = location;
  }

  // Getters and setters
  public GeoLoc getLocation() {
    return location;
  }

  public void setLocation(GeoLoc location) {
    this.location = location;
  }
}