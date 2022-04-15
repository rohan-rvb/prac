package org.example.prac.multithreading.blockingqueue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;

@Slf4j
@Service
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            log.info("inside loop");
            try {
                String message = this.queue.take().toString();
                log.info("received message : {}", message);
            } catch (InterruptedException e) {
                log.info("failed to receive message", e);
            }
        }
    }
}
