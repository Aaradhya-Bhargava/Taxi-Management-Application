package com.taxi.management.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4;
    JTextField textFieldUsername;
    JPasswordField passwordField;
    JComboBox<String> loginAsComboBox;
    JButton buttonLogin, buttonClear, buttonSignup;

    public Login() {
        super("Taxi Management System");

        // Database Connection (Modify with your credentials)
        String jdbcURL = "jdbc:mysql://localhost:3306/taxi_management";
        String dbUser = "root"; // Replace with your MySQL username
        String dbPassword = "your_password"; // Replace with your MySQL password


        // Background Image
        ImageIcon bgIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/BG.png");
        Image bgImage = bgIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        JLabel backgroundLabel = new JLabel(new ImageIcon(bgImage));
        backgroundLabel.setBounds(0, 0, 800, 500);
        add(backgroundLabel);

        // Taxi Logo
        ImageIcon logoIcon = new ImageIcon("D:/taxi-management/untitled/src/Icons/Logo.png");
        Image resizedLogo = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(resizedLogo));
        logoLabel.setBounds(300, 10, 200, 100); // Adjusted position to suit background
        backgroundLabel.add(logoLabel);


        // Welcome Text
        label1 = new JLabel("WELCOME TO TAXI MANAGEMENT");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 42));
        label1.setBounds(50, 80, 950, 110);
        backgroundLabel.add(label1);

        // Username Field
        label2 = new JLabel("Username:");
        label2.setFont(new Font("Raleway", Font.BOLD, 20));
        label2.setForeground(Color.BLACK);
        label2.setBounds(180, 180, 200, 30);
        backgroundLabel.add(label2);

        textFieldUsername = new JTextField(15);
        textFieldUsername.setBounds(320, 180, 230, 30);
        textFieldUsername.setFont(new Font("Arial", Font.BOLD, 18));
        backgroundLabel.add(textFieldUsername);

        // Password Field
        label3 = new JLabel("Password:");
        label3.setFont(new Font("Raleway", Font.BOLD, 20));
        label3.setForeground(Color.BLACK);
        label3.setBounds(180, 220, 200, 30);
        backgroundLabel.add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(320, 220, 230, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 18));
        backgroundLabel.add(passwordField);

        // Login As Field
        label4 = new JLabel("Login as:");
        label4.setFont(new Font("Raleway", Font.BOLD, 20));
        label4.setForeground(Color.BLACK);
        label4.setBounds(180, 260, 200, 30);
        backgroundLabel.add(label4);

        loginAsComboBox = new JComboBox<>(new String[]{"Select One", "User", "Admin", "Driver"});
        loginAsComboBox.setBounds(320, 260, 230, 30);
        loginAsComboBox.addActionListener(e -> removeDefaultOption());
        backgroundLabel.add(loginAsComboBox);

        // Buttons
        buttonLogin = new JButton("LOGIN");
        buttonLogin.setFont(new Font("Arial", Font.BOLD, 14));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setBackground(Color.BLACK);
        buttonLogin.setBounds(250, 310, 100, 30);
        buttonLogin.addActionListener(this);
        backgroundLabel.add(buttonLogin);

        buttonClear = new JButton("CLEAR");
        buttonClear.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setBackground(Color.BLACK);
        buttonClear.setBounds(370, 310, 100, 30);
        buttonClear.addActionListener(this);
        backgroundLabel.add(buttonClear);

        buttonSignup = new JButton("SIGN UP");
        buttonSignup.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignup.setForeground(Color.WHITE);
        buttonSignup.setBackground(Color.BLACK);
        buttonSignup.setBounds(250, 380, 230, 30);
        buttonSignup.addActionListener(this);
        backgroundLabel.add(buttonSignup);

        // Already have an account? Label
        JLabel alreadyHaveAccount = new JLabel("Not Having an account?");
        alreadyHaveAccount.setFont(new Font("Raleway", Font.PLAIN, 16));
        alreadyHaveAccount.setForeground(Color.BLACK);
        alreadyHaveAccount.setBounds(290, 350, 200, 30);
        backgroundLabel.add(alreadyHaveAccount);

        // Setting Frame Properties
        setLayout(null);
        setSize(800, 537);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogin) {
            String username = textFieldUsername.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String role = (String) loginAsComboBox.getSelectedItem();

            if (username.isEmpty() || password.isEmpty() || role.equals("Select One")) {
                JOptionPane.showMessageDialog(null, "All fields must be filled.");
            } else if (authenticateUser(username, password, role)) {
                JOptionPane.showMessageDialog(null, "Login Successful");

                // Open Dashboard and close login window
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credentials");
            }
        } else if (e.getSource() == buttonClear) {
            textFieldUsername.setText("");
            passwordField.setText("");
            loginAsComboBox.setSelectedIndex(0);
        } else if (e.getSource() == buttonSignup) {
            new Signup(); // Redirect to Signup page
            setVisible(false);
        }
    }

    private boolean authenticateUser(String username, String password, String role) {
        boolean isAuthenticated = false;
        String jdbcURL = "jdbc:mysql://localhost:3306/taxi_management";
        String dbUser = "root"; // Replace with your MySQL username
        String dbPassword = "your_password"; // Replace with your MySQL password

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String query = "SELECT * FROM users WHERE username=? AND password=? AND role=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, role);

                try (ResultSet resultSet = statement.executeQuery()) {
                    isAuthenticated = resultSet.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    private void removeDefaultOption() {
        if (loginAsComboBox.getSelectedItem().equals("Select One")) {
            loginAsComboBox.removeItem("Select One");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
