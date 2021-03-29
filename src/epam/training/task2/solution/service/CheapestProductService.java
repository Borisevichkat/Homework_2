package epam.training.task2.solution.service;

import epam.training.task2.solution.product.Product;

import java.util.ArrayList;

public interface CheapestProductService {

    ArrayList<Product> getCheapestProducts() throws ServiceException;
}
