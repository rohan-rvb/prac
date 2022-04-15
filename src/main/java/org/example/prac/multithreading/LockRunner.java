package org.example.prac.multithreading;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Data
public class LockRunner {
    private String data;
    private Lock lock;

    public LockRunner() {
        this.data = "initial_data";
        this.lock = new ReentrantLock();
    }

    public void update(String str) {
        lock.lock();
        try {
            this.data = this.data.concat(str);
            log.info("updated string : {}", this.data);
        } finally {
            lock.unlock();
        }
    }

    public void updateWithoutLock(String str) {
        this.data = this.data.concat(str);
        //log.info("[Without Lock] string : {}", this.data);
    }

}
