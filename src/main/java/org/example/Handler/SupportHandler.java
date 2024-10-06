package org.example.Handler;

import org.example.EnumOperation.Operation;

import static org.example.EnumOperation.Operation.SUPPORT;

public class SupportHandler extends MessageHandler {

    public SupportHandler() {
        super();
    }

    public SupportHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String message, Operation s) {
        if (!s.equals(SUPPORT)) {
            nextHandler.handle(message,s);
        } else {
            System.out.println("Это служба поддержки");
        }
    }
}
