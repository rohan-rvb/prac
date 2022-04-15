package org.example.prac.multithreading;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ThreadCreationRunnableTest {

    @Test
    public void testThreadCreationRunnable() {
        ThreadCreationRunnable tc = new ThreadCreationRunnable();
        Thread th = new Thread(tc);
        th.start();
    }
}
