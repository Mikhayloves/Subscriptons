package org.example.Handler;

import org.example.EnumOperation.Operation;

import static org.example.EnumOperation.Operation.SPAM;

public class SpamHandler extends MessageHandler {

    public SpamHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    public SpamHandler() {
        super();
    }

    @Override
    public void handle(String message, Operation s) {
        System.out.println("Проверка нa спам");
        if (!s.equals(SPAM)){
            System.out.println("Спама не обнаружено");
            nextHandler.handle(message,s);
        } else
            throw new RuntimeException("Это спам");

        }
    }
