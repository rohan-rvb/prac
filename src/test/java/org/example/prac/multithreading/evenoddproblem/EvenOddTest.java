package org.example.prac.multithreading.evenoddproblem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EvenOddTest {

    @Test
    public void testEvenOdd() throws InterruptedException {
        final State state = new State(PrinterType.ODD);
        Printer oddP = new Printer(2, state, 1, PrinterType.ODD, PrinterType.EVEN, 15);
        Printer evenP = new Printer(2, state, 2, PrinterType.EVEN, PrinterType.ODD, 15);

        Thread oth = new Thread(oddP);
        Thread eth = new Thread(evenP);
        oth.start();
        eth.start();
    }
}
