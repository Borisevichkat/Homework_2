package epam.training.task2.solution.service.impl;

import epam.training.task2.solution.product.*;
import epam.training.task2.solution.service.ParseProductService;

public class ParseProductServiceImpl implements ParseProductService {

    @Override
    public Product generateProduct(String productName, String[] params) {
        Product newProduct = null;
        switch (productName) {
            case ("Oven"):
                newProduct = OvenProduct.parseString(params).build();
                break;
            case ("Laptop"):
                newProduct = LaptopProduct.parseString(params).build();
                break;
            case ("Refrigerator"):
                newProduct = RefrigeratorProduct.parseString(params).build();
                break;
            case ("TabletPC"):
                newProduct = TabletPCProduct.parseString(params).build();
                break;
            case ("VacuumCleaner"):
                newProduct = VacuumCleanerProduct.parseString(params).build();
                break;
            case ("Kettle"):
                newProduct = KettleProduct.parseString(params).build();
                break;
            case ("Speakers"):
                newProduct = SpeakersProduct.parseString(params).build();
                break;
        }
        return newProduct;
    }
}
