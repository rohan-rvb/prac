package org.example.prac.multithreading.dining;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@RunWith(SpringRunner.class)
public class DiningTest {

    @SneakyThrows
    @Test
    public void testDining() {
        Dining dining = new Dining(5);
        List<ExecutorService> executors = new ArrayList<>();
        for (int i=0;i<5;i++) {
            executors.add(Executors.newSingleThreadExecutor());
        }
        for(int i=0;i<5;i++) {
            ExecutorService executor = executors.get(i);
            int finalI = i;
            executor.submit(() -> {
                try {
                    startDine(finalI, dining);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for(int i=0;i<5;i++) {
            executors.get(i).awaitTermination(3, TimeUnit.SECONDS);
        }
    }

    public void startDine(int i, Dining dining) throws InterruptedException {
        String str = "wer";
        log.info("starting dine :  {}", i);
        while(true) {
            if (dining.getStock() <= 0) {
                break;
            }

            try {
                dining.startEating(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Thread.sleep(1000);
        }
    }
}
