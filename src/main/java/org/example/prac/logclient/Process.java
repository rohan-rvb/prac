package org.example.prac.logclient;

import lombok.Data;

@Data
public class Process {
    private final String id;
    private final long startTime;
    private long endTime;

    public Process(final String id, final long startTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = -1;
    }
}
