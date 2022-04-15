package org.example.prac.multithreading;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ThreadCreationTest {

    @Test
    public void testCreateThread() {
        ThreadCreation tc = new ThreadCreation();
        tc.start();
    }

}
