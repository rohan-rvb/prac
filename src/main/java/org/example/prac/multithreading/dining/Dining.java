package org.example.prac.multithreading.dining;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

@Slf4j
public class Dining {
    private Semaphore table;
    List<Semaphore> forks = new ArrayList<>();
    private int stock;

    public Dining(int count) {
        table = new Semaphore(count);
        for(int i=0;i<count;i++) {
            forks.add(new Semaphore(1));
        }

        stock = 10;
    }

    public void startEating(int p) throws InterruptedException {
        table.acquire();
        forks.get(right(p)).acquire();
        forks.get(left(p)).acquire();
        log.info("Eating philosopher : {}", p);
        updateStock();
        Thread.sleep(1000);
        log.info("Complete eating {}", p);
        forks.get(left(p)).release();
        forks.get(right(p)).release();
        table.release();
    }

    private synchronized void updateStock() {
        stock--;
    }

    public int getStock() {
        return stock;
    }

    private int right(int i) {
        return i;
    }

    private int left(int i) {
        return (i+1)%5;
    }
}
