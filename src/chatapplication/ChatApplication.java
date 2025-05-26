/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatapplication;

import javax.swing.*;
import java.util.*;


public class ChatApplication {
  
    private static int messageCount = 0;
   
    public static void main(String[] args) {
      userLogin login = new userLogin();

        // Welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the registration system", "Welcome", JOptionPane.INFORMATION_MESSAGE);

        // Registration
        String registrationResults = login.registerUser();

        if (login.isRegistered()) {
            boolean loginStatus = login.loginUser();
            login.returnLoginStatus(loginStatus);

            if (loginStatus) {
                JOptionPane.showMessageDialog(null, "Welcome to QuickChat!", "Chat Ready", JOptionPane.INFORMATION_MESSAGE);

                // Ask number of messages to send
                int totalMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages would you like to send?"));
                StringBuilder summary = new StringBuilder("Summary of messages:\n");

                for (int i = 0; i < totalMessages; i++) {
                    String recipient = JOptionPane.showInputDialog("Enter recipient number (e.g., +27712345678):");
                    if (!recipient.matches("^\\+\\d{1,3}\\d{10}$")) {
                        JOptionPane.showMessageDialog(null, "Invalid recipient number. Must include international code and 10 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    String message = JOptionPane.showInputDialog("Enter your message (max 250 characters):");

                    if (message.length() > 250) {
                        JOptionPane.showMessageDialog(null, "Message exceeds 250 characters. Please shorten it.", "Error", JOptionPane.ERROR_MESSAGE);
                        continue;
                    }

                    // Generate ID and hash
                    String messageID = UUID.randomUUID().toString().substring(0, 10);
                    String[] words = message.split(" ");
                    String messageHash = "00:" + message.length() + ":" + (words.length > 0 ? words[0] : "") + ":" + (words.length > 1 ? words[words.length - 1] : "");

                    // Choose action
                    Object[] options = {"Send", "Discard", "Store"};
                    int choice = JOptionPane.showOptionDialog(null, "Choose an action for the message:", "Message Action",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (choice == 0) {
                        JOptionPane.showMessageDialog(null, "Message successfully sent!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        messageCount++;
                    } else if (choice == 1) {
                        JOptionPane.showMessageDialog(null, "Message discarded.", "Discarded", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Message stored for later.", "Stored", JOptionPane.INFORMATION_MESSAGE);
                        messageCount++;
                    }

                    // Add to summary
                    summary.append("Msg ID: ").append(messageID)
                            .append("\nHash: ").append(messageHash)
                            .append("\nRecipient: ").append(recipient)
                            .append("\nMessage: ").append(message)
                            .append("\n-----------------\n");
                }

                // Show summary
                summary.append("Total messages sent/stored: ").append(messageCount);
                JOptionPane.showMessageDialog(null, summary.toString(), "Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Exit message
        JOptionPane.showMessageDialog(null, "Thank you for using our system. GOODBYE!", "Exit", JOptionPane.INFORMATION_MESSAGE);
    }
}  
 