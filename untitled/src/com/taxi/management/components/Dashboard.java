package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Dashboard extends JFrame implements ActionListener {
    private JTextField nameText, emailText, ageText, phoneText, pickupText, destinationText, dateText, timeText;
    private JComboBox<String> genderBox, paymentBox;
    private JButton bookButton, clearButton;
    private JLabel bookingCodeLabel;

    public Dashboard() {
        setTitle("Taxi Booking Dashboard");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background image
        ImageIcon bgIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/BACKG.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(800, 537, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 800, 537);
        add(background);
        background.setLayout(null);

        Font fieldFont = new Font("Arial", Font.BOLD, 14);
        Color fieldColor = Color.YELLOW;

        // Create Labels and Text Fields
        String[] labels = {"Name:", "E-mail:", "Age:", "Gender:", "Phone No:", "Pickup Location:", "Destination:", "Date:", "Time:", "Pay:"};
        int yOffset = 50;
        int labelX = 50, fieldX = 180, width = 200, height = 30;

        JLabel[] labelObjects = new JLabel[labels.length];
        JTextField[] textFields = {nameText = new JTextField(), emailText = new JTextField(), ageText = new JTextField(),
                phoneText = new JTextField(), pickupText = new JTextField(), destinationText = new JTextField(),
                dateText = new JTextField(), timeText = new JTextField()};

        for (int i = 0; i < labels.length; i++) {
            labelObjects[i] = new JLabel(labels[i]);
            labelObjects[i].setBounds(labelX, yOffset, 150, height);
            labelObjects[i].setFont(fieldFont);
            labelObjects[i].setForeground(fieldColor);
            background.add(labelObjects[i]);

            if (i != 3 && i != 9) {
                textFields[i].setBounds(fieldX, yOffset, width, height);
                background.add(textFields[i]);
            }
            yOffset += 40;
        }

        // Gender ComboBox
        String[] genders = {"Select One", "Male", "Female", "Other"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(320, 130, 100, height);
        background.add(genderBox);

        // Payment ComboBox
        String[] payments = {"Select One", "Cash", "UPI", "Net Banking", "Card"};
        paymentBox = new JComboBox<>(payments);
        paymentBox.setBounds(fieldX, 370, 150, height);
        background.add(paymentBox);

        // Buttons
        bookButton = new JButton("Book Ride");
        bookButton.setBounds(200, 420, 150, 40);
        bookButton.setBackground(Color.GREEN);
        bookButton.setForeground(Color.WHITE);
        bookButton.addActionListener(this);
        background.add(bookButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(380, 420, 150, 40);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        background.add(clearButton);

        // Booking Code Label
        bookingCodeLabel = new JLabel("", SwingConstants.CENTER);
        bookingCodeLabel.setBounds(150, 470, 500, 30);
        bookingCodeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bookingCodeLabel.setForeground(Color.YELLOW);
        background.add(bookingCodeLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            if (validateFields()) {
                int bookingCode = new Random().nextInt(9000) + 1000;
                bookingCodeLabel.setText("Your Booking Code: " + bookingCode);
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    private boolean validateFields() {
        try {
            if (nameText.getText().isEmpty() || emailText.getText().isEmpty() || ageText.getText().isEmpty() ||
                    phoneText.getText().isEmpty() || pickupText.getText().isEmpty() || destinationText.getText().isEmpty() ||
                    dateText.getText().isEmpty() || timeText.getText().isEmpty() || genderBox.getSelectedIndex() == 0 ||
                    paymentBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            int age = Integer.parseInt(ageText.getText());
            if (age < 18) {
                JOptionPane.showMessageDialog(this, "Age must be 18 or above!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            Long.parseLong(phoneText.getText()); // Validating phone number
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid age or phone number!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void clearFields() {
        nameText.setText("");
        emailText.setText("");
        ageText.setText("");
        phoneText.setText("");
        pickupText.setText("");
        destinationText.setText("");
        dateText.setText("");
        timeText.setText("");
        genderBox.setSelectedIndex(0);
        paymentBox.setSelectedIndex(0);
        bookingCodeLabel.setText("");
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
