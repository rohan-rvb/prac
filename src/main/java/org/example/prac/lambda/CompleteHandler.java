package org.example.prac.lambda;

@FunctionalInterface
public interface CompleteHandler<T> {
    void onComplete(T t);
}
