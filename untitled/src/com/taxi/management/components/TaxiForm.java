package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;

public class TaxiForm extends JFrame {
    public TaxiForm() {
        setTitle("Taxi Form");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        JLabel title = new JLabel("Enter Taxi Details ");
        title.setFont(new Font("Raleway", Font.BOLD, 20));
        title.setForeground(Color.YELLOW);
        title.setBounds(150, 50, 200, 30);
        add(title);


        JLabel model = new JLabel("Model Details :");
        model.setFont(new Font("Raleway", Font.BOLD, 15));
        model.setForeground(Color.YELLOW);
        model.setBounds(150, 100, 200, 30);
        add(model);

        JTextField modelField = new JTextField(15);
        modelField.setBounds(340, 100, 200, 30);
        add(modelField);

        JLabel driver = new JLabel("Driver Assigned :");
        driver.setFont(new Font("Raleway", Font.BOLD, 15));
        driver.setForeground(Color.YELLOW);
        driver.setBounds(150, 150, 200, 30);
        add(driver);

        JTextField driverField = new JTextField(15);
        driverField.setBounds(340, 150, 200, 30);
        add(driverField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(350, 200, 100, 30);
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
        new TaxiForm();
    }
}
