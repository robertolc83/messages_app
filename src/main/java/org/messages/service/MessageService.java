package org.messages.service;

import org.messages.model.Message;
import org.messages.DAO.MessageDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class MessageService {
    public static void createMessage(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write the Message:");
        String message = String.valueOf(scanner.nextLine());

        System.out.println("Author of the Message:");
        String author = String.valueOf(scanner.nextLine());
        //CREAMOS EL OBJETO
        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setAuthorMessage(author);

        MessageDAO.createMessageDB(messageObj);
    }

    public static void readMessage(){
        ArrayList<Message> messages = MessageDAO.readMessageDB();

        for (Message message: messages) {
            System.out.println("");
            System.out.println("ID: "+message.getId());
            System.out.println("Message: "+message.getMessage());
            System.out.println("Author: "+message.getAuthorMessage());
            System.out.println("Date: "+message.getDateMessage());
        }
    }

    public static void deleteMessage(){
        Scanner scanner = new Scanner(System.in);

        readMessage();

        System.out.println("\nWrite the ID of the Message: ");
        int id_message = Integer.valueOf(scanner.nextLine());

        MessageDAO.deleteMessageDB(id_message);
    }

    public static void updateMessage(){
        Scanner scanner = new Scanner(System.in);

        readMessage();

        System.out.println("\nWrite the ID of the Message to Modify: ");
        int id_message = Integer.valueOf(scanner.nextLine());

        System.out.println("Write the Message: ");
        String message = String.valueOf(scanner.nextLine());

        //CREAMOS EL OBJETO
        Message messageObj = new Message();
        messageObj.setMessage(message);
        messageObj.setId(id_message);

        MessageDAO.updateMessageDB(messageObj);
    }
}
