/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.texteditor;

/**
 *
 * @author RC_Student_lab
 */
class AdvancedEditor extends Editor {
       public AdvancedEditor(int size) {
        super(size);
    }

    public void searchWord(String word) {
        boolean found = false;
        for (int i = 0; i < lineCount; i++) {
            if (lines[i].contains(word)) {
                System.out.println("Found in line " + (i + 1) + ": " + lines[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Word not found in document.");
        }
    }
}
