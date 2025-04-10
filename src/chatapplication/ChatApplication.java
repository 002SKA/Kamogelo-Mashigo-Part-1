/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapplication;

import java.util.Scanner;


public class ChatApplication {

   
    public static void main(String[] args) {
        
 Scanner scanner = new Scanner(System.in); // Scanner for any needed input
        userLogin login = new userLogin(); // Create login object

        // Welcome message
        System.out.println("==================================");
        System.out.println(" Welcome to the registration system");
        System.out.println("==================================");

        // Registration process
        String registrationResults = login.registerUser();
        System.out.println(registrationResults); // Show registration result

        // If registration successful, proceed to login
        if (login.isRegistered()) {
            boolean loginStatus = login.loginUser(); // Login process
            login.returnLoginStatus(loginStatus);    // Display login message
        }

        // Exit message
        System.out.println("----------------------------------");
        System.out.println("Thank you for using our system. GOODBYE!");
        System.out.println("----------------------------------");

        scanner.close(); // Close the scanner
    }
}