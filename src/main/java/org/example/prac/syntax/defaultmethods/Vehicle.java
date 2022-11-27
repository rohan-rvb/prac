package org.example.prac.syntax.defaultmethods;


/*
If a class implements more than one interface and
they have common default method, then it should implement that common method.
 */

public interface Vehicle {
    public void ride();

    default void printName() {
        System.out.println("default name");
    }

    //static methods cannot be overriden and also only way to call them
    // is via Vehicle.cleanVehicle()
    static void cleanVehicle() {
        System.out.println("cleaning");
    }
}