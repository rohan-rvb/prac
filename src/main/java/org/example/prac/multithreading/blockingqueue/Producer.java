package org.example.prac.multithreading.blockingqueue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@Service
public class Producer implements Runnable{
    BlockingQueue<String> queue=null;

    public Producer(BlockingQueue queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            log.info("producing message 1");
            String message = "Message1";
            queue.put(message);
            Thread.sleep(2000);
            log.info("producing message 2");
            message = "Message2";
            queue.put(message);
            Thread.sleep(2000);
            log.info("producing message 3");
            message = "Message3";
            queue.put(message);
        } catch (InterruptedException ex) {
            log.info("failed to produce", ex);
        }
    }
}
