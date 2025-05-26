/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapplication;

import javax.swing.JOptionPane;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
   
  private String[] sentMessages = new String[10]; // Initial capacity
    private int totalMessages = 0;

    // Validate Message ID (max 10 characters)
    public boolean checkMessageID(String messageID) {
        return messageID.length() <= 10;
    }

    // Validate recipient cell number (starts with + and 10+ digits)
    public boolean checkRecipientCell(String cellNumber) {
        return cellNumber.matches("^\\+\\d{10,}$");
    }

    // Create a hash using the message content
    public String createMessageHash(String message) {
        String[] words = message.trim().split("\\s+");
        if (words.length < 4) return "INVALID-HASH";
        return (words[0].substring(0, 2) + ":" + words.length + ":" + words[0] + "-" + words[words.length - 1]).toUpperCase();
    }

    // Generate a random 10-digit message ID
    public String createMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    // Allow user to send, discard, or store message
    public String sendMessage(String messageID, String recipient, String message, String messageHash) {
        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        int choice = JOptionPane.showOptionDialog(null, "Choose what to do with the message:",
                "Send Options", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            case 0:
                addMessageToArray(message);
                totalMessages++;
                JOptionPane.showMessageDialog(null, "Message successfully sent.");
                return "sent";
            case 1:
                JOptionPane.showMessageDialog(null, "Message disregarded.");
                return "discarded";
            case 2:
                storeMessageAsJSON(messageID, recipient, message, messageHash);
                JOptionPane.showMessageDialog(null, "Message stored.");
                return "stored";
            default:
                return "cancelled";
        }
    }

    // Add a message to the array, resizing if necessary
    private void addMessageToArray(String message) {
        if (totalMessages == sentMessages.length) {
            // Resize array
            String[] newArray = new String[sentMessages.length * 2];
            System.arraycopy(sentMessages, 0, newArray, 0, sentMessages.length);
            sentMessages = newArray;
        }
        sentMessages[totalMessages] = message;
    }

    // Print all sent messages
    public String printMessages() {
        if (totalMessages == 0) return "No messages sent yet.";
        StringBuilder output = new StringBuilder("Sent Messages:\n");
        for (int i = 0; i < totalMessages; i++) {
            output.append("- ").append(sentMessages[i]).append("\n");
        }
        return output.toString();
    }

    // Return total number of messages sent
    public int returnTotalMessages() {
        return totalMessages;
    }

    // Store message as a JSON object in messages.json
    @SuppressWarnings("unchecked")
    public void storeMessageAsJSON(String messageID, String recipient, String message, String messageHash) {
        JSONObject msgObj = new JSONObject();
        msgObj.put("MessageID", messageID);
        msgObj.put("Recipient", recipient);
        msgObj.put("Message", message);
        msgObj.put("MessageHash", messageHash);

        JSONArray msgArray = new JSONArray();

        try {
            FileReader reader = new FileReader("messages.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            msgArray = (JSONArray) obj;
            reader.close();
        } catch (IOException | ParseException e) {
            // File doesn't exist or is empty — start new array
        }

        msgArray.add(msgObj);

        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(msgArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // View last few messages from messages.json
    public String viewRecentMessages(int count) {
        JSONArray msgArray;
        StringBuilder result = new StringBuilder("Recent Messages:\n");

        try {
            FileReader reader = new FileReader("messages.json");
            JSONParser parser = new JSONParser();
            msgArray = (JSONArray) parser.parse(reader);

            int start = Math.max(0, msgArray.size() - count);
            for (int i = start; i < msgArray.size(); i++) {
                JSONObject msg = (JSONObject) msgArray.get(i);
                result.append("Message ID: ").append(msg.get("MessageID")).append("\n")
                      .append("Recipient: ").append(msg.get("Recipient")).append("\n")
                      .append("Message: ").append(msg.get("Message")).append("\n")
                      .append("Hash: ").append(msg.get("MessageHash")).append("\n\n");
            }

            reader.close();
        } catch (IOException | ParseException e) {
            return "No messages stored or error reading file.";
        }

        return result.toString();
    }
}




    

