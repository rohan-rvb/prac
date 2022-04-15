package org.example.prac.multithreading.evenoddproblem;

import lombok.Data;

@Data
public class State {
    private PrinterType next;

    public State(PrinterType next) {
        this.next = next;
    }
}
