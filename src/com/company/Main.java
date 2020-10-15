package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Reader r = new Reader("Triangles");
        r.setVisible(true);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setSize(600,750);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
    }
}
