package org.example.prac.designpatterns.observer;


import org.example.prac.designpatterns.observer.observers.Observer;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyConsumers();
}
