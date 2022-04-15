package org.example.prac.designpatterns.strategy.ex1.flyStrategy;

public class Ifly implements Flys{
    @Override
    public String fly() {
        return "I can fly";
    }
}
