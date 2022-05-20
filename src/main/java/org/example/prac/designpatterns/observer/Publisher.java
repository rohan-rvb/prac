package org.example.prac.designpatterns.observer;

import lombok.extern.slf4j.Slf4j;
import org.example.prac.designpatterns.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Publisher implements Subject{
    private List<Observer> consumers;
    private int stockValue;

    public Publisher() {
        this.consumers = new ArrayList<>();
    }

    @Override
    public void register(Observer o) {
        this.consumers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int index = consumers.indexOf(o);
        consumers.remove(index);
    }

    @Override
    public void notifyConsumers() {
        for (Observer o : consumers) {
            o.update(this.stockValue);
        }
    }

    public void setState(int stockValue) {
        this.stockValue = stockValue;
        notifyConsumers();
    }
}
