package org.example.prac.designpatterns.strategy.ex1;

import org.example.prac.designpatterns.strategy.ex1.flyStrategy.Ifly;

public class Bird extends Animal{

    public Bird() {
        super(new Ifly());
    }
}
