package org.example.prac.designpatterns.observer.observers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StockObserver implements Observer{
    @Override
    public void update(int value) {
        log.info("[StockApplication] Got updated stock value : {}", value);
    }
}
