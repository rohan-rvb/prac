package org.example.prac.multithreading.racecondition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Service
public class Calculator {
    private int sum = 0;
    private Lock lock;

    public Calculator() {
        this.lock = new ReentrantLock();
    }

    public synchronized void calculateWithSync() {
        setSum(getSum() + 1);
    }

    public void calculateWithoutSync() {
        setSum(getSum() + 1);
    }

    public void calculateWithLock() {
        lock.lock();
        log.info("setting with lock on thread {}", Thread.currentThread().getName());
        try {
            setSum(getSum() + 1);
        } finally {
            log.info("done with lock on thread {}", Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return this.sum;
    }
}
