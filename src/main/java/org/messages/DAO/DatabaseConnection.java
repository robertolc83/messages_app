package org.messages.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public Connection get_connection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");

        }catch(SQLException ex){
            System.out.println(ex);
        }
        return connection;
    }
}
