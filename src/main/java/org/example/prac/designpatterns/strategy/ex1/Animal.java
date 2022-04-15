package org.example.prac.designpatterns.strategy.ex1;

import org.example.prac.designpatterns.strategy.ex1.flyStrategy.Flys;

abstract public class Animal {
    private String name;
    private Flys flys;

    public Animal(Flys flys) {
        this.flys = flys;
    }

    public String letsFly() {
        return this.flys.fly();
    }
}
