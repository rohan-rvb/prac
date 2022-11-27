package org.example.prac.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
public class ThreadCreationTest {

    @Test
    public void testCreateThread() {
        ThreadCreation tc = new ThreadCreation();
        tc.start();
    }

    @Test
    public void testWithRunnable() throws InterruptedException {
        ThreadCreationRunnable tc = new ThreadCreationRunnable();
        Thread th = new Thread(tc);
        th.start();

        th.join();
    }

    @Test
    public void testWithLambda() throws InterruptedException {
        Thread th = new Thread(() -> log.info("hey i am lambda, executing in {}", Thread.currentThread().getName()));
        th.start();
        th.join();
    }



}
