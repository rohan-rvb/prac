package org.example.prac.syntax;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RunWith(SpringRunner.class)
public class ListStreamTest {

    @Test
    public void testStream() {
        //consider this list stores user names
        List<String> users = new ArrayList<String>(){{
            add("Tom");
            add("Harry");
            add("Mike");
        }};

        List<String> result = users.stream()
                .filter(user -> user.length() <= 4)
                .collect(Collectors.toList());

        log.info("Result list : {}", result);
    }
}
