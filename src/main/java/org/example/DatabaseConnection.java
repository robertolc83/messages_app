package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection get_connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
            if(connection != null){
                System.out.println("Conexión Exitosa");
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        return connection;
    }
}
