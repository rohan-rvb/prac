package org.example.prac.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LambdaTest {

    @Test
    public void testLambda() {
        UserProfile userProfile = new UserProfile();
        userProfile.getUserDetails(user -> {
            System.out.println("User Id : " + user.getId());
            System.out.println("User Name : " + user.getName());
        });
    }
}
