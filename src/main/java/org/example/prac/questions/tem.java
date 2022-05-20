package org.example.prac.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private Semaphore s;
    List<Semaphore> locks = new ArrayList<>();

    public DiningPhilosophers() {
        s = new Semaphore(5);
        this.locks = new ArrayList<>();
        for(int i=0;i<=4;i++) {
            locks.add(new Semaphore(1));
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int p,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        s.acquire();
        locks.get(leftFork(p)).acquire();
        locks.get(rightFork(p)).acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks.get(leftFork(p)).release();
        locks.get(rightFork(p)).release();
        s.release();
    }


    int leftFork(int p) {
        return p;
    }

    int rightFork(int p) {
        return (p+1)%5;
    }
}

