package com.taxi.management.services;

import com.taxi.management.models.Ride;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingService {
    public boolean bookRide(Ride ride) {
        String sql = "INSERT INTO rides (passenger_id, driver_id, pickup_location, drop_location, ride_date, fare) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ride.getPassengerId());
            stmt.setInt(2, ride.getDriverId());
            stmt.setString(3, ride.getPickupLocation());
            stmt.setString(4, ride.getDropLocation());
            stmt.setDate(5, new java.sql.Date(ride.getRideDate().getTime()));
            stmt.setDouble(6, ride.getFare());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
