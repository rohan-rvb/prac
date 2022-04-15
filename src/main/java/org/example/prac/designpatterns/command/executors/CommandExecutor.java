package org.example.prac.designpatterns.command.executors;

public abstract class CommandExecutor {
    private String name;

    public CommandExecutor(String name) {
        this.name = name;
    }

    public abstract void execute() ;

    public boolean isApplicable(String name) {
        return this.name.equalsIgnoreCase(name);
    }
}
