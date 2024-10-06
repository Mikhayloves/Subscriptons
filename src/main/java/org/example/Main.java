package org.example;

import org.example.Handler.GeneralHandler;
import org.example.Handler.MessageHandler;
import org.example.Handler.SpamHandler;
import org.example.Handler.SupportHandler;
import org.example.PatternObserver.MessageBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.EnumOperation.Operation.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<User> users = new ArrayList<>();
    public static MessageBoard messageBoard = new MessageBoard();
    public static final int CHOICE_ADD_SUB = 1;
    public static final int CHOICE_REMOVE_SUB = 2;
    public static final int CHOICE_NEWPOST = 3;
    public static void main(String[] args) {

        while (true) {
            menu();
            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 5) {
                System.out.println("Вы вышли");
                break;
            }
            switch (input) {
                case CHOICE_ADD_SUB:
                    addUsers();
                    break;
                case CHOICE_REMOVE_SUB:
                    removeUsers();
                    break;
                case CHOICE_NEWPOST:
                    newPost();
                    break;
                case 4:
                    System.out.println("Все пользователи: ");
                    for (Object s : users) {
                        System.out.println(s);
                    }
            }
        }
    }

    public static void menu() {
        System.out.println("1. Добавить подписчика\n2. Удалить подписчика\n3. Написать новый пост\n4. Выход");
    }

    public static void addUsers() {
        System.out.println("Введите имя пользователя");
        String name = scanner.next();
        User newusers = new User(name);
        users.add(newusers);
        System.out.printf("Пользователь с ником %s ,добавлен", name);
        messageBoard.attach(newusers);
        System.out.println();
    }

    public static void removeUsers() {
        System.out.println("Введите имя кого хотите удалить");
        String removename = scanner.next();
        users.removeIf(users1 -> users1.getName().equalsIgnoreCase(removename));
    }

    public static void newPost() {
        MessageHandler spamhandler = new SpamHandler();
        MessageHandler supporthandler = new SupportHandler(spamhandler);
        MessageHandler generalhandler = new GeneralHandler(supporthandler);
        System.out.println("Введите сообщение: ");
        String message = scanner.nextLine();
        if (message.equalsIgnoreCase("Spam")) {
            generalhandler.handle(message, SPAM);
        } else if (message.equalsIgnoreCase("Support")) {
            generalhandler.handle(message, SUPPORT);
        } else if (message.equalsIgnoreCase("General")) {
            generalhandler.handle(message, GENERAL);
        }
        messageBoard.notifyObservers(message);
    }
}
