package com.taxi.management.models;

import java.util.Date;

public class Ride {
    private int id;
    private int passengerId;
    private int driverId;
    private String pickupLocation;
    private String dropLocation;
    private Date rideDate;
    private double fare;

    public Ride(int id, int passengerId, int driverId, String pickupLocation, String dropLocation, Date rideDate, double fare) {
        this.id = id;
        this.passengerId = passengerId;
        this.driverId = driverId;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.rideDate = rideDate;
        this.fare = fare;
    }

    public int getId() { return id; }
    public int getPassengerId() { return passengerId; }
    public int getDriverId() { return driverId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDropLocation() { return dropLocation; }
    public Date getRideDate() { return rideDate; }
    public double getFare() { return fare; }

    public void setId(int id) { this.id = id; }
    public void setPassengerId(int passengerId) { this.passengerId = passengerId; }
    public void setDriverId(int driverId) { this.driverId = driverId; }
    public void setPickupLocation(String pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(String dropLocation) { this.dropLocation = dropLocation; }
    public void setRideDate(Date rideDate) { this.rideDate = rideDate; }
    public void setFare(double fare) { this.fare = fare; }
}
