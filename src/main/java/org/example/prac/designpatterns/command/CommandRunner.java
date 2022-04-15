package org.example.prac.designpatterns.command;

import org.example.prac.designpatterns.command.executors.CommandExecutor;
import org.example.prac.designpatterns.command.pojo.Command;

import java.util.List;

public class CommandRunner {
    private List<CommandExecutor> commandExecutors;

    public CommandRunner(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    public String run(Command command) {
        /*
        for(CommandExecutor commandExecutor : commandExecutors) {
            if(commandExecutor.isApplicable(command.getName())) {
                commandExecutor.execute();
                return "Executed" + command.getName();
            }
        }

         */
        return "Invalid Command";
    }
}
