package epam.training.task2.solution.controller.command;

import epam.training.task2.solution.controller.command.impl.NoFoundCommandImpl;
import epam.training.task2.solution.controller.command.impl.ShowCheapestProductImpl;
import epam.training.task2.solution.controller.command.impl.ShowKettleImpl;

import java.util.HashMap;

public class CommandProvider {
    private HashMap<String, Command> commands = new HashMap<>();

    public CommandProvider() {
        commands.put("showCheapestProduct", new ShowCheapestProductImpl());
        commands.put("showKettle", new ShowKettleImpl());
        commands.put("nocommand", new NoFoundCommandImpl());
    }

    public Command getCommand(String commandName) {
        Command command;

        command = commands.get(commandName);
        if(command == null) {
            command = commands.get("nocommand");
        }

        return command;

    }

}