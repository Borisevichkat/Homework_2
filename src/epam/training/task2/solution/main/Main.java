package epam.training.task2.solution.main;

import epam.training.task2.solution.controller.ApplianceController;
import epam.training.task2.solution.controller.Controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ApplianceController();
        controller.doAction("showCheapestProduct");
        controller.doAction("showKettle");
    }
}
