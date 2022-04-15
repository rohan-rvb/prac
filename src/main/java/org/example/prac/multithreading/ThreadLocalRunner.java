package org.example.prac.multithreading;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreadLocalRunner implements Runnable {
    private ThreadLocal<Integer> var = new ThreadLocal<>();

    @Override
    public void run() {
        var.set((int) (Math.random() * 50D));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("exception occurred", e);
        }

        log.info("thread local is : {}", var.get());
    }
}
