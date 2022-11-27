package org.example.prac;

import lombok.extern.slf4j.Slf4j;
import org.example.prac.syntax.StreamChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


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

    @Test
    public void testList() {
        List<Integer> list = new ArrayList<>(10);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<Integer> future1 = executorService.submit(()->{
            return 2;
        });



        Future<Integer> future2 = executorService.submit(()->5);




    }
}
