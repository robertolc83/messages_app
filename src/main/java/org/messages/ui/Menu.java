package org.messages.ui;

import org.messages.service.MessageService;

import java.util.Scanner;

public class Menu {
    public static void uiMenu(){
        int response=0;
        do {
            System.out.println("\n********MENU*********");
            System.out.println("::Message Application");
            System.out.println("1. Create Message");
            System.out.println("2. List Messages");
            System.out.println("3. Delete Message");
            System.out.println("4. Update Message");
            System.out.println("5. Exit");

            Scanner scanner = new Scanner(System.in);
            response = Integer.valueOf(scanner.nextLine());

            switch (response){
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.readMessage();
                    break;
                case 3:
                    MessageService.deleteMessage();
                    break;
                case 4:
                    MessageService.updateMessage();
                    break;
                case 5:
                    System.out.println("Thanks for Your Visit");
                    break;
                default:
                    System.out.println("Warning: Invalid Option");
            }

        }while (response != 5);
        System.out.println("You Have Exited the Application");
    }
}
