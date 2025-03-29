package com.taxi.management.models;

public class Driver {
    private int id;
    private String name;
    private String phoneNumber;
    private String licenseNumber;
    private double rating;

    public Driver(int id, String name, String phoneNumber, String licenseNumber, double rating) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getLicenseNumber() { return licenseNumber; }
    public double getRating() { return rating; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public void setRating(double rating) { this.rating = rating; }
}
