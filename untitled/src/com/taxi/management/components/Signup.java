package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JTextField userText, emailText, ageText, phoneText;
    JPasswordField passText;
    JComboBox<String> genderBox, userTypeBox;
    JLabel userIdLabel;
    JButton signupButton, loginButton, clearButton;

    public Signup() {
        setTitle("Taxi Signup");
        setSize(800, 537);
        setLocationRelativeTo(null);
        setUndecorated(false);
        setLayout(null);

        // Set background image
        ImageIcon bgIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/BACKG.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(800, 537, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 800, 537);
        add(background);
        background.setLayout(null);

        // Generate random user ID
        String userId = "TX" + new Random().nextInt(10000);
        userIdLabel = new JLabel("User ID: " + userId);
        userIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        userIdLabel.setBounds(300, 20, 200, 30);
        userIdLabel.setForeground(Color.YELLOW);
        background.add(userIdLabel);

        Font fieldFont = new Font("Arial", Font.BOLD, 16); // Font for all labels
        Color fieldColor = Color.YELLOW; // Yellow color for labels

        // Username
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(250, 60, 100, 30);
        userLabel.setFont(fieldFont);
        userLabel.setForeground(fieldColor);
        background.add(userLabel);
        userText = new JTextField();
        userText.setBounds(370, 60, 200, 30);
        background.add(userText);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(250, 100, 100, 30);
        emailLabel.setFont(fieldFont);
        emailLabel.setForeground(fieldColor);
        background.add(emailLabel);
        emailText = new JTextField();
        emailText.setBounds(370, 100, 200, 30);
        background.add(emailText);

        // Password
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(250, 140, 100, 30);
        passLabel.setFont(fieldFont);
        passLabel.setForeground(fieldColor);
        background.add(passLabel);
        passText = new JPasswordField();
        passText.setBounds(370, 140, 200, 30);
        background.add(passText);

        // Age
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(250, 180, 100, 30);
        ageLabel.setFont(fieldFont);
        ageLabel.setForeground(fieldColor);
        background.add(ageLabel);
        ageText = new JTextField();
        ageText.setBounds(370, 180, 50, 30);
        background.add(ageText);

        // Gender Dropdown
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(450, 180, 100, 30);
        genderLabel.setFont(fieldFont);
        genderLabel.setForeground(fieldColor);
        background.add(genderLabel);
        String[] genders = {"Select One", "Male", "Female", "Other"};
        genderBox = new JComboBox<>(genders);
        genderBox.setBounds(520, 180, 100, 30);
        background.add(genderBox);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone No:");
        phoneLabel.setBounds(250, 220, 100, 30);
        phoneLabel.setFont(fieldFont);
        phoneLabel.setForeground(fieldColor);
        background.add(phoneLabel);
        phoneText = new JTextField();
        phoneText.setBounds(370, 220, 200, 30);
        background.add(phoneText);

        // Signup as (User/Admin)
        JLabel userTypeLabel = new JLabel("Signup as:");
        userTypeLabel.setBounds(250, 260, 100, 30);
        userTypeLabel.setFont(fieldFont);
        userTypeLabel.setForeground(fieldColor);
        background.add(userTypeLabel);
        String[] userTypes = {"Select One", "User", "Admin", "Driver"};
        userTypeBox = new JComboBox<>(userTypes);
        userTypeBox.setBounds(370, 260, 200, 30);
        background.add(userTypeBox);

        // Signup Button
        signupButton = new JButton("Sign Up");
        signupButton.setBounds(280, 320, 100, 30);
        signupButton.setBackground(Color.GREEN);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);
        background.add(signupButton);

        // Clear Button
        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 320, 100, 30);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.addActionListener(this);
        background.add(clearButton);

        // "Already have an account?" label
        JLabel alreadyAccountLabel = new JLabel("Already have an account?");
        alreadyAccountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        alreadyAccountLabel.setForeground(Color.WHITE);
        alreadyAccountLabel.setBounds(320, 370, 250, 30);
        background.add(alreadyAccountLabel);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(360, 410, 100, 30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        background.add(loginButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            // Validate all fields before signing up
            if (userText.getText().isEmpty() || emailText.getText().isEmpty() ||
                    new String(passText.getPassword()).isEmpty() || ageText.getText().isEmpty() ||
                    phoneText.getText().isEmpty() || genderBox.getSelectedIndex() == 0 ||
                    userTypeBox.getSelectedIndex() == 0) {

                JOptionPane.showMessageDialog(this, "Please fill all the fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Signup Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Login(); // Redirect to Login Page
                dispose();
            }
        } else if (e.getSource() == loginButton) {
            new Login(); // Open Login Page
            dispose();
        } else if (e.getSource() == clearButton) {
            // Clear all fields
            userText.setText("");
            emailText.setText("");
            passText.setText("");
            ageText.setText("");
            phoneText.setText("");
            genderBox.setSelectedIndex(0);
            userTypeBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
