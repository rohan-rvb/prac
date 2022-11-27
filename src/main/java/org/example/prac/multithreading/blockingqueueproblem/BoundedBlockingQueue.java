package org.example.prac.multithreading.blockingqueueproblem;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue {
    private int size;
    List<Integer> list;
    private ReentrantLock lock = new ReentrantLock();

    public BoundedBlockingQueue(int capacity) {
        this.size = capacity;
        list = new ArrayList<>(capacity);
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (this) {
            while (list.size()==size) {
                wait();
            }

            lock.lock();

            System.out.println("producing : " + element);
            list.add(element);
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        int result;
        synchronized (this) {
            while (list.size()==0) {
                wait();
            }

            lock.lock();
           // TimeUnit.SECONDS.sleep(4);
            result = list.get(0);
            list.remove(0);
            notify();
            lock.unlock();
        }

        System.out.println("consumed : " + result);
        return result;
    }

    public int size() {
        return size;
    }
}
