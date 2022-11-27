package org.example.prac.syntax.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
public class JavaStreams {
    @Test
    public void testStream() {
        Stream<Integer> stream = Stream.of(1,1,2,2,3,3,4);
        stream.filter(it -> it > 2)
                .map(it -> it * 2)
                .distinct()
                .forEach(it -> System.out.println("element " + it));

    }
}
