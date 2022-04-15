package org.example.prac.questions.turn;

import java.util.concurrent.Semaphore;

public class FooSemaphore {
    private Semaphore s2;
    private Semaphore s3;

    public FooSemaphore() {
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        printSecond.run();
        s3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        printThird.run();
    }
}
