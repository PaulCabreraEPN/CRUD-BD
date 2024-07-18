package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Seleccion().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    }
}