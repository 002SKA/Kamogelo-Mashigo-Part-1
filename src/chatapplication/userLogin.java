/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import java.util.Scanner;
import java.util.regex.Pattern;

public class userLogin {
    
    // User details fields
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cellNumber;
    private boolean isRegistered = false;

    // Scanner object for reading input from console
    private final Scanner scanner = new Scanner(System.in);

    // Method to validate username
    // Username must contain an underscore and be no longer than 5 characters
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to validate password
    // Password must be at least 8 characters, contain one uppercase, one digit, and one special character
    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#^&+=!$%*?])[A-Za-z\\d@#^&+=!$%*?]{8,}$";
        return Pattern.matches(regex, password);
    }

    // Method to validate phone number format
    // Cell number should start with '+' followed by country code and 10 digits
    public boolean checkCellPhoneNumber() {
        String regex = "^\\+\\d{1,3}\\d{10}$";
        return Pattern.matches(regex, cellNumber);
    }

    // Method to register a new user using console input
    public String registerUser() {
        // Prompt for first name
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        if (firstName.trim().isEmpty()) return "Registration cancelled.";

        // Prompt for last name
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        if (lastName.trim().isEmpty()) return "Registration cancelled.";

        // Prompt for username
        System.out.print("Enter username (must contain '_' and be ≤ 5 characters): ");
        username = scanner.nextLine();
        if (username.trim().isEmpty()) return "Registration cancelled.";

        // Prompt for password
        System.out.print("Enter password (min 8 chars, capital letter, number, special char): ");
        password = scanner.nextLine();
        if (password.trim().isEmpty()) return "Registration cancelled.";

        // Prompt for cell number
        System.out.print("Enter cell phone number (e.g., +27607126325): ");
        cellNumber = scanner.nextLine();
        if (cellNumber.trim().isEmpty()) return "Registration cancelled.";

        // Validate inputs
        if (!checkUserName()) {
            System.out.println("Username is not correctly formatted. It must contain an underscore and be no more than five characters.");
            return "Username format incorrect.";
        }

        if (!checkPasswordComplexity()) {
            System.out.println("Password is not correctly formatted. It must contain at least eight characters, a capital letter, a number, and a special character.");
            return "Password format incorrect.";
        }

        if (!checkCellPhoneNumber()) {
            System.out.println("Cell number format is incorrect. It must start with an international code followed by 10 digits.");
            return "Cell number format incorrect.";
        }

        // All inputs valid, user registered
        isRegistered = true;
        System.out.println("Username successfully captured.");
        System.out.println("Password successfully captured.");
        System.out.println("Cell phone number successfully added.");
        System.out.println("User registered successfully.");
        return "Registration successful!";
    }

    // Method to allow user login using console input
    public boolean loginUser() {
        // Prompt for username and password
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Check credentials
        return enteredUsername.equals(username) && enteredPassword.equals(password);
    }

    // Display login result message
    public void returnLoginStatus(boolean loginStatus) {
        if (loginStatus) {
            System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }

    // Getters for testing or accessing private fields
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellnumber() {
        return cellNumber;
    }

    public boolean isRegistered() {
        return isRegistered;
    }
}
    

   
    

