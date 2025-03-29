package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;

public class DriverInfo extends JFrame {
    public DriverInfo() {
        setTitle("Driver Information");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        JLabel title = new JLabel("Driver Information:");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setForeground(Color.YELLOW);
        title.setBounds(150, 20, 300, 30);
        add(title);

        // Load and set driver image
        ImageIcon driverIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/driver.png");
        Image driverImg = driverIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel driverPhoto = new JLabel(new ImageIcon(driverImg));
        driverPhoto.setBounds(200, 60, 180, 180);
        add(driverPhoto);

        // Driver Details
        JLabel nameLabel = new JLabel("Name: John Doe");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(500, 60, 200, 30);
        add(nameLabel);

        JLabel ageLabel = new JLabel("Age: 30");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setBounds(500, 90, 200, 30);
        add(ageLabel);

        JLabel sexLabel = new JLabel("Sex: Male");
        sexLabel.setFont(new Font("Arial", Font.BOLD, 16));
        sexLabel.setForeground(Color.WHITE);
        sexLabel.setBounds(500, 120, 200, 30);
        add(sexLabel);

        JLabel phoneLabel = new JLabel("Phone: 9876543210");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setBounds(500, 150, 200, 30);
        add(phoneLabel);

        // Rating stars (4.2 rating)
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        ratingLabel.setForeground(Color.WHITE);
        ratingLabel.setBounds(500, 180, 100, 30);
        add(ratingLabel);

        // Star rating (4.2 -> 4 full stars, 1 partially filled)
        JLabel starLabel = new JLabel("\u2605\u2605\u2605\u2605\u00BD"); // Unicode for stars (4 full, 1 half)
        starLabel.setFont(new Font("Arial", Font.BOLD, 18));
        starLabel.setForeground(Color.RED); // Red-filled stars
        starLabel.setBounds(560, 180, 100, 30);
        add(starLabel);

        // Display numeric rating value (4.2)
        JLabel ratingValue = new JLabel("4.2");
        ratingValue.setFont(new Font("Arial", Font.BOLD, 16));
        ratingValue.setForeground(Color.WHITE);
        ratingValue.setBounds(630, 180, 50, 30);
        add(ratingValue);

        // Set background image
        ImageIcon bgIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/BACKG.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(800, 537, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 800, 537);
        add(background);
        background.setLayout(null);

        // Bring labels to the front
        title.setOpaque(false);
        driverPhoto.setOpaque(false);
        nameLabel.setOpaque(false);
        ageLabel.setOpaque(false);
        sexLabel.setOpaque(false);
        phoneLabel.setOpaque(false);
        ratingLabel.setOpaque(false);
        starLabel.setOpaque(false);
        ratingValue.setOpaque(false);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DriverInfo();
    }
}
