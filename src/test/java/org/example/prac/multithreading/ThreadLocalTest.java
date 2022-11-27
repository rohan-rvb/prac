package org.example.prac.multithreading;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
public class ThreadLocalTest {

    @Test
    public void testThreadLocalVariables() throws InterruptedException {
        ThreadLocalRunner threadLocalRunner = new ThreadLocalRunner();
        Thread th1 = new Thread(threadLocalRunner);
        Thread th2 = new Thread(threadLocalRunner);

        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }

    @Test
    public void testAny() {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(5);
            }
        };
        int arr[][] = new int[5][10];


        log.info("list is {}", list);


    }

}
