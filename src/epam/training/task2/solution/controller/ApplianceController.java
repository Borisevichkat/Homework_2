package epam.training.task2.solution.controller;

import epam.training.task2.solution.controller.command.Command;
import epam.training.task2.solution.controller.command.CommandProvider;
import epam.training.task2.solution.controller.ControllerException;

public class ApplianceController implements Controller {

    private final CommandProvider provider = new CommandProvider();

    public String doAction(String request) {
        String commandName;
        commandName = request.split("\\s+_\\|_\\s+",2)[0];

        Command command;
        command = provider.getCommand(commandName);

        String response;
        response = command.execute(request);

        return response;
    }

}
