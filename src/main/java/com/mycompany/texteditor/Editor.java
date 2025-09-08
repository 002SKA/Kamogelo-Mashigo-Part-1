/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texteditor;

/**
 *
 * @author RC_Student_lab
 */
public class Editor {
     String[] lines;
    int lineCount;

    public Editor(int size) {
        lines = new String[size];
        lineCount = 0;
    }

    public void addLine(String text) {
        if (lineCount < lines.length) {
            lines[lineCount] = text;
            lineCount++;
            System.out.println("Line added.");
        } else {
            System.out.println("No more space to add text!");
        }
    }

    public void viewText() {
        System.out.println("\n--- Your Text Document ---");
        for (int i = 0; i < lineCount; i++) {
            System.out.println((i + 1) + ": " + lines[i]);
        }
        System.out.println("--------------------------\n");
    }

    public void deleteLine(int lineNumber) {
        if (lineNumber <= lineCount && lineNumber > 0) {
            for (int i = lineNumber - 1; i < lineCount - 1; i++) {
                lines[i] = lines[i + 1];
            }
            lines[lineCount - 1] = null;
            lineCount--;
            System.out.println("Line deleted.");
        } else {
            System.out.println("Invalid line number!");
        }
    }
}
