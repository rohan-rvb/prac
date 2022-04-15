package org.example.prac.logclient;

public interface LogClient {
    void start(String processId);
    void end(String processId);
    void poll();
}
