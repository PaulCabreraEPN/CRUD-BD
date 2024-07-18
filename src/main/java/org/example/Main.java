package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/Lista_estudiantes";
        String user="root";
        String passw="123456";
        PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,user,passw);
            System.out.println("Conectado com sucesso");
            //Prepara la sentencia SQL
            String sql="UPDATE estudiantes SET b1 = ? where cedula = ?";
            ps = connection.prepareStatement(sql);
            //Seteamos los valores de la sentencia previa
            ps.setInt(1,20);
            ps.setString(2,"6000263486");
            ps.executeUpdate();
            int a = ps.getUpdateCount();
            System.out.println("Tiene " + a + " lineas actualizadas");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            //Cerramos la conección
            try {
                if (ps!=null){
                    ps.close();
                }
                if (connection!=null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }
}