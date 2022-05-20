package org.example.prac.designpatterns.observer.observers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ScreenObserver implements Observer{
    @Override
    public void update(int value) {
        log.info("[Display] Current value of stock : {}", value);
    }
}
