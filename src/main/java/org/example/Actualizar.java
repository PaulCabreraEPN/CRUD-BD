package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Actualizar {
    public JPanel MainPanel;
    private JButton button1;
    private JTextField cedula;
    private JLabel nombre;
    private JTextField b1;
    private JTextField b2;
    private JButton actualizarButton;
    private JLabel mensaje;

    public Actualizar() {
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String url="jdbc:mysql://localhost:3306/Lista_estudiantes";
                String user="root";
                String passw="123456";
                PreparedStatement ps1 = null;
                PreparedStatement ps2 = null;
                Connection connection = null;

                try {
                    connection = DriverManager.getConnection(url,user,passw);
                    System.out.println("Conectado com sucesso");
                    //Prepara la sentencia SQL
                    String sql1="UPDATE estudiantes SET b1 = ? where cedula = ?";
                    String sql2="UPDATE estudiantes SET b2 = ? where cedula = ?";
                    ps1 = connection.prepareStatement(sql1);
                    ps2 = connection.prepareStatement(sql2);

                    //Seteamos los valores de la sentencia previa
                    ps1.setInt(1,Integer.parseInt(b1.getText()));
                    ps1.setString(2,cedula.getText());
                    ps1.executeUpdate();
                    ps2.setInt(1, Integer.parseInt(b2.getText()));
                    ps2.setString(2,cedula.getText());
                    ps2.executeUpdate();
                    int a = ps1.getUpdateCount() + ps2.getUpdateCount();
                    System.out.println("Tiene " + a + " lineas actualizadas");

                    mensaje.setText("Estudiantes actualizados con exito");

                }catch (SQLException e1){
                    System.out.println(e1.getMessage());
                }finally {
                    //Cerramos la conección
                    try {
                        if (ps1!=null){
                            ps1.close();
                        }
                        if (connection!=null){
                            connection.close();
                        }
                    }catch (SQLException e1){
                        System.out.println(e1.getMessage());
                    }
                }
            }
        });
    }
}
