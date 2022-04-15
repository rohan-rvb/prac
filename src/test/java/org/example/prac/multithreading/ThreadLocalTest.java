package org.example.prac.multithreading;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

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
}
