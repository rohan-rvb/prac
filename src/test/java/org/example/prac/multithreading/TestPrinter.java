package org.example.prac.multithreading;

import org.example.prac.multithreading.turn.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestPrinter {

    @Test
    public void testPrint() throws InterruptedException {
        Printer printer = new Printer(11);
        Thread t1 = new Thread(()->{
            try {
                printer.PrintZero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                printer.PrintOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(()->{
            try {
                printer.PrintEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}
