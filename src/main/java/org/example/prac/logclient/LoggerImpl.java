package org.example.prac.logclient;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class LoggerImpl implements LogClient{
    private final TreeMap<Long, Process> queue;
    private final Map<String, Process> processes;

    public LoggerImpl() {
        this.queue = new TreeMap<>(Comparator.comparingLong(startTime -> startTime));
        this.processes = new HashMap<>();
    }

    @Override
    public void start(String processId) {
        long startTime = System.currentTimeMillis();
        Process process = new Process(processId, startTime);
        processes.put(processId, process);
        queue.put(startTime, process);
    }

    @Override
    public void end(String processId) {
        long endTime = System.currentTimeMillis();
        Process process = processes.get(processId);
        process.setEndTime(endTime);
    }

    @Override
    public void poll() {
        if (queue.firstEntry() == null) {
            return;
        }
        Process process = queue.firstEntry().getValue();
        log.info("got process in poll: {}", process.getId());
        if (process.getEndTime() != -1) {
            log.info("Process : {}, start : , end : ", process.getId());
            processes.remove(process.getId());
            queue.pollFirstEntry();
        } else {
            log.info("No tasks");
        }
    }
}
