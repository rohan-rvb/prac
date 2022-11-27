package org.example.prac.syntax;

import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


/*
Use of optional is not just to avoid null check, it provides various utility methods
 */

@RunWith(SpringRunner.class)
public class OptionalTest {
    @Test
    public void testOptional() {
        Optional<Integer> op = Optional.empty();
        System.out.println("op is : " + op.isPresent());

        Optional<String> ops = Optional.of(new String("hello"));
        System.out.println("ops is : " + ops.get());

        Optional<String> opNullable = Optional.ofNullable(new String("hello"));
        System.out.println("opnullable is : " + opNullable.get());
        opNullable = Optional.ofNullable(null);
        System.out.println("after null is : " + opNullable.isPresent());
        System.out.println("optional value if main value is null : " + opNullable.orElse("world"));
    }
}
