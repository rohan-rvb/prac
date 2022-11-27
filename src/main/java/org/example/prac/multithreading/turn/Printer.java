package org.example.prac.multithreading.turn;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    private int zeroCount;
    private int turn;
    private int count;
    private int maxLimit;
    private ReentrantLock lock = new ReentrantLock();

    public Printer(int maxLimit) {
        turn = 0;
        zeroCount = 0;
        count=1;
        this.maxLimit = maxLimit;
    }

    public synchronized void PrintZero() throws InterruptedException {
        while (count < maxLimit) {
            synchronized (this) {
                if (turn!=0) {
                    wait();
                }
                lock.lock();
                System.out.println("Zero");
                if(zeroCount ==0 ) {
                    zeroCount = 1;
                    turn = 1;
                } else {
                    zeroCount = 0;
                    turn = 2;
                }
                notifyAll();
                lock.unlock();
            }

        }

    }

    public synchronized void PrintOdd() throws InterruptedException {
        while (count < maxLimit) {
            synchronized (this) {
                if (turn!=1) {
                    wait();
                }
                lock.lock();
                System.out.println(count + "      Odd");
                turn = 0;
                count++;
                notifyAll();
                lock.unlock();
            }
        }


    }

    public synchronized void PrintEven() throws InterruptedException {
        while (count < maxLimit) {
            synchronized (this) {
                if (turn!=2) {
                    wait();
                }
                lock.lock();
                System.out.println(count + "    Even");
                count++;
                turn = 0;
                notifyAll();
                lock.unlock();
            }
        }


    }

}
