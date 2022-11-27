package org.example.prac.multithreading.blockingqueueproblem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
public class TestBoundedBlockingQueue {

    @Test
    public void testBlocking() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        BoundedBlockingQueue blockingQueue = new BoundedBlockingQueue(2);

        for(int i=0;i<9;i++) {
            executorService.submit(()->{

                try {
                    int num = new Random().nextInt(100);
                    blockingQueue.enqueue(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        ExecutorService cexecutorService = Executors.newFixedThreadPool(8);


        for (int i=0;i<3;i++) {
            cexecutorService.submit(()->{

                try {
                    int result = blockingQueue.dequeue();
                    System.out.println("Consumed : " + result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        cexecutorService.awaitTermination(10, TimeUnit.SECONDS);


    }

    @Test
    public void testBLock() {

    }
}
