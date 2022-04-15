package org.example.prac.multithreading;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
public class LockRunnerTest {

    @SneakyThrows
    @Test
    public void testLocking() {
        LockRunner lockRunner = new LockRunner();
        ExecutorService executor = Executors.newFixedThreadPool(20);
        int i;
        for(i=1;i<100;i++) {
            int finalI = i;
            Thread th = new Thread(()->lockRunner.updateWithoutLock(String.valueOf(finalI)));
            th.start();
            //executor.submit(()->lockRunner.updateWithoutLock(String.valueOf(finalI)));
        }

        Thread.sleep(5000);
        //executor.awaitTermination(5, TimeUnit.SECONDS);
        log.info("final data : {}", lockRunner.getData());
    }
}
