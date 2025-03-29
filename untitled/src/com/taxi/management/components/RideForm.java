package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;

public class RideForm extends JFrame {
    public RideForm() {
        setTitle("Ride Form");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        JLabel title = new JLabel("Enter Ride Details:");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setForeground(Color.YELLOW);
        title.setBounds(150, 50, 200, 30);
        add(title);

        JLabel pickup = new JLabel("Pickup Location:");
        pickup.setFont(new Font("Raleway", Font.BOLD, 15));
        pickup.setBounds(150, 100, 200, 30);
        pickup.setForeground(Color.YELLOW);
        add(pickup);

        JTextField pickupField = new JTextField(15);
        pickupField.setBounds(340, 100, 200, 30);
        add(pickupField);

        JLabel dropoff = new JLabel("Drop-off Location:");
        dropoff.setFont(new Font("Raleway", Font.BOLD, 15));
        dropoff.setBounds(150, 150, 200, 30);
        dropoff.setForeground(Color.YELLOW);
        add(dropoff);

        JTextField dropoffField = new JTextField(15);
        dropoffField.setBounds(340, 150, 200, 30);
        add(dropoffField);

        JLabel fare = new JLabel("Estimated Fare:");
        fare.setFont(new Font("Raleway", Font.BOLD, 15));
        fare.setBounds(150, 200, 200, 30);
        fare.setForeground(Color.YELLOW);
        add(fare);

        JTextField fareField = new JTextField(15);
        fareField.setBounds(340, 200, 200, 30);
        add(fareField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 250, 100, 30);
        add(submitButton);

        // Set background image
        ImageIcon bgIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/BACKG.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(800, 537, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 800, 537);
        add(background);
        background.setLayout(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RideForm();
    }
}
