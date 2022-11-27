package org.example.prac.syntax.datastructures;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@Slf4j
@RunWith(SpringRunner.class)
public class HashMapTest {

    @Test
    public void testHashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        hashMap.put(6,7);

        hashMap.forEach((key, val) -> {
            log.info("hashmap key : {}, val : {}", key, val);
        });

        if (hashMap.containsKey(2)) {
            log.info("1 found, val : {}", hashMap.get(1));
        }


    }
}
