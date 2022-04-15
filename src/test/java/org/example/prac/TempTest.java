package org.example.prac;

import lombok.extern.slf4j.Slf4j;
import org.example.prac.syntax.StreamChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@Slf4j
@RunWith(SpringRunner.class)
public class TempTest {

    @Test
    public void tempTest() {
        String []arr = new String[]{"abaa","abaab","aabbb","bab","ab"};
        StreamChecker s = new StreamChecker(arr);
        log.info("querying {} : result : {}", 'd', s.search("aab"));
    }

    @Test
    public void testReverse() {
        String str = "abc";
        StringBuilder input1 = new StringBuilder();
        input1.append(str);
        input1.reverse();
System.out.println();
        log.info("reversed {}", input1);
    }
}
