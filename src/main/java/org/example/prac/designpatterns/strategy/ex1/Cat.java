package org.example.prac.designpatterns.strategy.ex1;

import org.example.prac.designpatterns.strategy.ex1.flyStrategy.NFly;

public class Cat extends Animal{

    public Cat() {
        super(new NFly());
    }
}
