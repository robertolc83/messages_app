package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        DatabaseConnection databaseConnection = new DatabaseConnection();

        try(Connection cnx = databaseConnection.get_connection()){

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}