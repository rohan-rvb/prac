package org.example.prac.syntax.streams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class MethodReferences {
    public static int getLen(String str) {
        return str.length();
    }

    @Test
    public void testMethodReference() {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("word");
        list.stream().mapToInt(MethodReferences::getLen)
                .forEach(System.out::println);
    }
}
