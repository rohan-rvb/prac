package org.example.prac.syntax.defaultmethod;

import org.example.prac.multithreading.racecondition.Calculator;
import org.example.prac.syntax.defaultmethods.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestDefaultMethod {

    @Test
    public void testCar() {
        Car car = new Car();
        car.ride();
        car.printName();
    }
}
