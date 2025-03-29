package com.taxi.management.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RideList extends JFrame {
    public RideList() {
        setTitle("Ride List");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        JLabel title = new JLabel("Completed Rides:");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setForeground(Color.YELLOW);
        title.setBounds(150, 50, 200, 30);
        add(title);

        // Table Data
        String[] columnNames = {"S No.", "Taxi No.", "Taxi Model", "Driver Name", "Driver No.", "Pickup Location", "Drop Location", "Estimate Fare"};
        Object[][] data = {
                {1, "MP09TA1234", "Toyota Innova", "Ramesh Kumar", "9876543210", "Station", "Airport", "₹350"},
                {2, "DL01XY5678", "Hyundai Verna", "Suresh Mehta", "8765432109", "Mall", "Hotel", "₹250"},
                {3, "MH04AB3456", "Honda City", "Amit Sharma", "7654321098", "Office", "Home", "₹200"},
                {4, "KA05CD7890", "Maruti Swift", "Rajesh Verma", "6543210987", "Market", "Station", "₹180"},
                {5, "GJ06EF4567", "Ford Ecosport", "Manoj Patil", "5432109876", "Home", "Hospital", "₹220"},
                {6, "TN07GH1234", "Mahindra XUV", "Vikram Singh", "4321098765", "College", "Library", "₹120"},
                {7, "UP08IJ5678", "Maruti Dzire", "Prakash Jha", "3210987654", "Gym", "Park", "₹100"},
                {8, "WB09KL7890", "Renault Duster", "Subodh Das", "2109876543", "Restaurant", "Bar", "₹150"},
                {9, "RJ10MN3456", "Skoda Rapid", "Arvind Rao", "1098765432", "Temple", "Home", "₹170"},
                {10, "HR11OP6789", "Tata Nexon", "Sunil Dutt", "9876543211", "Hotel", "Airport", "₹400"}
        };

        JTable rideTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(rideTable);
        scrollPane.setBounds(100, 100, 600, 182);
        add(scrollPane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(350, 320, 100, 30);
        add(refreshButton);

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
        new RideList();
    }
}
