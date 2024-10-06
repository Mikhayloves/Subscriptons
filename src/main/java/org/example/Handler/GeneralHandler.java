package org.example.Handler;

import org.example.EnumOperation.Operation;

import static org.example.EnumOperation.Operation.GENERAL;

public class GeneralHandler extends MessageHandler {
    public GeneralHandler() {
        super();
    }

    public GeneralHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String message, Operation s) {
            if (s.equals(GENERAL)) {
                System.out.printf("Вышел новый пост ------>  %s\n", message);
            }
            if (nextHandler !=null){
                nextHandler.handle(message, s);
            }
    }

    @Override
    public void setNextHandler(MessageHandler nextHandler) {
        super.setNextHandler(nextHandler);
    }

}
