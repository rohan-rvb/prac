package org.example.prac.lambda;

import org.example.prac.lambda.pojo.User;

public class UserProfile {
    public void getUserDetails(CompleteHandler<User> ch) {
        User user = User.builder()
                .id("123")
                .name("Rohan")
                .build();
        ch.onComplete(user);
    }
}
