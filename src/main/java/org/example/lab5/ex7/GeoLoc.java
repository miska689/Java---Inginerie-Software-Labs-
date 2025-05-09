package org.example.lab5.ex7;

public class GeoLoc {
  private double latitude;
  private double longitude;

  public GeoLoc(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  // Getters and setters
  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
