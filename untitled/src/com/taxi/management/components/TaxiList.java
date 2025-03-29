package com.taxi.management.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TaxiList extends JFrame {
    public TaxiList() {
        setTitle("Taxi List");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        JLabel title = new JLabel("Available Taxis:");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setForeground(Color.YELLOW);
        title.setBounds(150, 50, 200, 30);
        add(title);

        // Create table with demo data
        String[] columnNames = {"S No.", "Model", "Taxi No.", "Driver Name", "Phone No."};
        Object[][] data = {
                {1, "Toyota Camry", "MP09 AB 1234", "John Doe", "9876543210"},
                {2, "Honda Accord", "DL05 XY 5678", "Alice Smith", "9876543211"},
                {3, "Ford Focus", "MH12 CD 9012", "Robert Brown", "9876543212"},
                {4, "Hyundai Verna", "KA03 EF 3456", "David Wilson", "9876543213"},
                {5, "Nissan Altima", "RJ14 GH 7890", "Emily Davis", "9876543214"},
                {6, "Chevrolet Malibu", "TN07 IJ 1234", "Michael Johnson", "9876543215"},
                {7, "Volkswagen Jetta", "WB08 KL 5678", "Sophia Martinez", "9876543216"},
                {8, "Mazda 3", "UP10 MN 9012", "Daniel Anderson", "9876543217"},
                {9, "Kia Optima", "HR26 OP 3456", "Jessica White", "9876543218"},
                {10, "Tesla Model 3", "GJ01 QR 7890", "William Lee", "9876543219"}
        };

        JTable taxiTable = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(taxiTable);
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
        new TaxiList();
    }
}
