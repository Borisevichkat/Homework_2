package epam.training.task2.solution.controller.command;

import epam.training.task2.solution.controller.ControllerException;

public interface Command {
    String execute(String request);
}
