package org.example.prac.lambda;


/*
Functional interface have exactly one method as abstract, it can have many default methods.
The annotation is used to give compile errors if someone tries to add method in this interface.
 */

@FunctionalInterface
public interface CompleteHandler<T> {
    void onComplete(T t);
}
