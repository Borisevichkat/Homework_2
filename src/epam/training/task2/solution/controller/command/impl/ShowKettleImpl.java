package epam.training.task2.solution.controller.command.impl;

import epam.training.task2.solution.controller.ControllerException;
import epam.training.task2.solution.controller.command.Command;
import epam.training.task2.solution.product.Product;
import epam.training.task2.solution.service.CheapestProductService;
import epam.training.task2.solution.service.ProductService;
import epam.training.task2.solution.service.ServiceException;
import epam.training.task2.solution.service.ServiceProvider;

import java.util.ArrayList;

public class ShowKettleImpl implements Command {
    @Override
    public String execute(String request){
        try {
            ServiceProvider serviceProvider = ServiceProvider.getInstance();
            ProductService productService = serviceProvider.getProductService();
            ArrayList<Product> products = productService.getProductsByCategory("Kettle");

            String outputLine = "Kettle products:\n";
            for (Product product : products) {
                outputLine += product.toString() + "\n";
            }
            System.out.println(outputLine);
        } catch (ServiceException e) {
            // TODO...
        }
        return null;
    }
}