package org.example.prac.lambda;

import org.example.prac.lambda.pojo.User;

/*
lambda is used for enabling passing of functions in arguments

Supplier is a functional interface which has mehtod ->
T get()
that means it return type

Consumer is a function interface that takes one parameter and do not produce anything

void accept(T t)

 */

public class UserProfile {

    public void getUserDetails(CompleteHandler<User> ch) {

        User user = User.builder()
                .id("123")
                .name("Rohan")
                .build();
        ch.onComplete(user);
    }
}
