package org.example.PatternObserver;

import java.util.ArrayList;
import java.util.List;

public class MessageBoard implements Subject{

    private ArrayList<Observer> observers = new ArrayList<>();

    private List<String> posts = new ArrayList<>();

    //TODO подписка
    @Override
    public void attach(Observer observer) {
    observers.add(observer);
    }
    //TODO отписка
    @Override
    public void detach(Observer observer) {
    observers.remove(observer);
    }
    //TODO уведомление
    @Override
    public void notifyObservers(String message) {
        observers.forEach(observer -> observer.update(message));
    }
    //TODO уведомление о новом посте
    public void notifyNewPost(String post){
        posts.add(post);
        notifyObservers(post);
    }


}
