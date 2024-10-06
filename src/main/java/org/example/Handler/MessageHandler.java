package org.example.Handler;

import org.example.EnumOperation.Operation;

public abstract class MessageHandler {
    protected MessageHandler nextHandler;

    public  MessageHandler(){
    }


    public MessageHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }


    public void setNextHandler(MessageHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handle(String message, Operation s);
}