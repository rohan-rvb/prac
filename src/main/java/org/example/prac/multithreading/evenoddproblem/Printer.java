package org.example.prac.multithreading.evenoddproblem;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Printer implements Runnable {
    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentType;
    private final PrinterType nextType;
    private final int maxValue;

    public Printer(final Integer step, State state, Integer currentValue,
                   PrinterType currentType, PrinterType nextType, Integer maxValue) {
        this.step = step;
        this.state = state;
        this.currentValue = currentValue;
        this.currentType = currentType;
        this.nextType = nextType;
        this.maxValue = maxValue;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (this.currentType != state.getNext()) {
                    state.wait();
                }
                log.info("currentPrinter : {} , currentValue : {}", currentType, currentValue);
                currentValue += step;
                state.setNext(this.nextType);
                state.notifyAll();
            }

        }
    }
}
