package org.messages.DAO;

import org.messages.model.Message;

import java.sql.*;
import java.util.ArrayList;

public class MessageDAO {

    public static void createMessageDB(Message message){
        DatabaseConnection dbConnection = new DatabaseConnection();
        String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?,?)";
        PreparedStatement preparedStatement = null;

        try(Connection connection = dbConnection.get_connection()){
            try{
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,message.getMessage());
                preparedStatement.setString(2,message.getAuthorMessage());
                preparedStatement.executeUpdate();
                System.out.println("Message Created");

            }catch(SQLException ex){
                System.out.println("Could Not Create Message");
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static ArrayList<Message> readMessageDB(){
        ArrayList<Message> messages = new ArrayList<>();
        DatabaseConnection dbConnection = new DatabaseConnection();
        String query ="SELECT * FROM `mensajes`";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try(Connection connection = dbConnection.get_connection()){
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Message message = new Message();
                message.setId(resultSet.getInt("id_mensaje"));
                message.setMessage(resultSet.getString("mensaje"));
                message.setAuthorMessage(resultSet.getString("autor_mensaje"));
                message.setDateMessage(resultSet.getString("fecha_mensaje"));

                messages.add(message);

            }
        }catch(SQLException ex) {
            System.out.println("Query: " + ex);
        }
        return messages;
    }

    public static void deleteMessageDB(int id){
        DatabaseConnection dbConnection = new DatabaseConnection();
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM `mensajes` WHERE `id_mensaje` = ?";
        int countRowUpdated = 0;

        try(Connection connection = dbConnection.get_connection()) {
            try {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,id);
                countRowUpdated = preparedStatement.executeUpdate();

                if(countRowUpdated > 0){
                    System.out.println("The Message Has Been Deleted");
                }else {
                    System.out.println("The Message Was Not Found");
                }
            }catch(SQLException ex){
                System.out.println("Could Not Delete Message");
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void updateMessageDB(Message message){
        DatabaseConnection dbConnection = new DatabaseConnection();
        PreparedStatement preparedStatement = null;
        int countRowUpdated = 0;

        try(Connection connection = dbConnection.get_connection()) {
            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
            try{
                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1,message.getMessage());
                preparedStatement.setInt(2,message.getId());
                countRowUpdated = preparedStatement.executeUpdate();

                if (countRowUpdated > 0)
                    System.out.println("\nMessage modified");
                else {
                    System.out.println("No Modifications!!!!");
                }

            }catch(SQLException e){
                System.out.println("Could Not Update Message");
                System.out.println(e);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }

    }
}
