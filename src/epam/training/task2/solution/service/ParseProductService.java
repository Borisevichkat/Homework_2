package epam.training.task2.solution.service;

import epam.training.task2.solution.product.Product;

public interface ParseProductService {
    Product generateProduct(String productName, String[] params) throws ServiceException;
}
