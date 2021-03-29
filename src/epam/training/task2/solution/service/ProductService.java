package epam.training.task2.solution.service;

import epam.training.task2.solution.product.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> getProducts() throws ServiceException;
    ArrayList<Product> getProductsByCategory(String category) throws ServiceException;
}
