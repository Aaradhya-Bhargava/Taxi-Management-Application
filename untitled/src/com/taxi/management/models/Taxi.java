package com.taxi.management.models;

public class Taxi {
    private int id;
    private String model;
    private String licensePlate;
    private int driverId; // Foreign key for the assigned driver

    public Taxi(int id, String model, String licensePlate, int driverId) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
        this.driverId = driverId;
    }

    public int getId() { return id; }
    public String getModel() { return model; }
    public String getLicensePlate() { return licensePlate; }
    public int getDriverId() { return driverId; }

    public void setId(int id) { this.id = id; }
    public void setModel(String model) { this.model = model; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setDriverId(int driverId) { this.driverId = driverId; }
}
