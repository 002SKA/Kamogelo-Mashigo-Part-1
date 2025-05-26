/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;

public class userLogin {
    
    // User fields
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cellNumber;
    private boolean isRegistered = false;

    // Method to validate username format
    // Must contain underscore and be ≤ 10 characters
    public boolean checkUserName() {
        return username.contains("_") && username.length() <=10;
    }

    // Method to validate password complexity
    // Must be at least 8 chars, with uppercase, number and special character
    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#^&+=!$%*?])[A-Za-z\\d@#^&+=!$%*?]{8,}$";
        return Pattern.matches(regex, password);
    }

    // Method to validate international phone number (e.g. +27761234567)
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+\\d{1,3}\\d{10}$";
        return Pattern.matches(regex, cellNumber);
    }

    // Register a user using JOptionPane
    public String registerUser() {
        // First name
        firstName = JOptionPane.showInputDialog(null, "Enter your first name:", "Registration", JOptionPane.PLAIN_MESSAGE);
        if (firstName == null || firstName.trim().isEmpty()) return "Registration cancelled.";

        // Last name
        lastName = JOptionPane.showInputDialog(null, "Enter your last name:", "Registration", JOptionPane.PLAIN_MESSAGE);
        if (lastName == null || lastName.trim().isEmpty()) return "Registration cancelled.";

        // Username
        username = JOptionPane.showInputDialog(null, "Enter username (must contain '_' and be ≤ 10 characters):", "Registration", JOptionPane.PLAIN_MESSAGE);
        if (username == null || username.trim().isEmpty()) return "Registration cancelled.";

        // Password
        password = JOptionPane.showInputDialog(null, "Enter password (min 8 chars, capital letter, number, special char):", "Registration", JOptionPane.PLAIN_MESSAGE);
        if (password == null || password.trim().isEmpty()) return "Registration cancelled.";

        // Cell number
        cellNumber = JOptionPane.showInputDialog(null, "Enter cell phone number (e.g. +27761234567):", "Registration", JOptionPane.PLAIN_MESSAGE);
        if (cellNumber == null || cellNumber.trim().isEmpty()) return "Registration cancelled.";

        // Validation
        boolean validUsername = checkUserName();
        boolean validPassword = checkPasswordComplexity();
        boolean validCell = checkCellPhoneNumber();

        if (!validUsername) {
            JOptionPane.showMessageDialog(null, "Username must contain '_' and be no more than 5 characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return "Username format incorrect.";
        }

        if (!validPassword) {
            JOptionPane.showMessageDialog(null, "Password must have 8+ characters, a capital letter, a number, and a special character.", "Error", JOptionPane.ERROR_MESSAGE);
            return "Password format incorrect.";
        }

        if (!validCell) {
            JOptionPane.showMessageDialog(null, "Cell number must include international code and 10 digits (e.g. +27761234567).", "Error", JOptionPane.ERROR_MESSAGE);
            return "Cell number format incorrect.";
        }

        isRegistered = true;
        JOptionPane.showMessageDialog(null, "Username, password and cell number captured successfully!\nUser registered successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        return "Registration successful!";
    }

    // Login the user using JOptionPane
    public boolean loginUser() {
        String enteredUsername = JOptionPane.showInputDialog(null, "Enter username:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (enteredUsername == null) return false;

        String enteredPassword = JOptionPane.showInputDialog(null, "Enter password:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (enteredPassword == null) return false;

        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    // Show login result using JOptionPane
    public void returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again.", "Login Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getters
    public String getUsername() 
    { return username; }
    
    public String getPassword() 
    { return password; }
    
    public String getCellnumber() 
    { return cellNumber; }
    
    public boolean isRegistered() 
    { return isRegistered; }
    
}
