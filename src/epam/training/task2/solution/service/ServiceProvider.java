package epam.training.task2.solution.service;

import epam.training.task2.solution.service.impl.CheapestProductServiceImpl;
import epam.training.task2.solution.service.impl.ParseProductServiceImpl;
import epam.training.task2.solution.service.impl.ProductServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final ParseProductService parseProductService = new ParseProductServiceImpl();
    private final ProductService productService = new ProductServiceImpl();
    private final CheapestProductService cheapestProductService = new CheapestProductServiceImpl();

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    public ParseProductService getParseProductService() {
        return parseProductService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public CheapestProductService getCheapestProductService() {
        return cheapestProductService;
    }

}
